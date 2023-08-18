package com.walker.service.simulation;



import com.walker.service.map.Coordinate;
import com.walker.service.map.IntegerMap;
import com.walker.model.rovers.Rover;
import com.walker.model.simulation.SimulationContext;
import com.walker.service.simulation.SimulationStep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScanningStep implements SimulationStep {

    @Override
    public void execute(SimulationContext context) {
        IntegerMap integerMap = context.getIntegerMap();
        Rover rover = context.getRover();

        Coordinate roverPosition = rover.getCurrentPosition();
        Set<Integer> resourcesFound = new HashSet<>();
        List<Coordinate> monitoredResourceCoordinates = new ArrayList<>();

        int mapDimension = integerMap.getDimension();

        // Scan the entire map for resources
        for (int x = 0; x < mapDimension; x++) {
            for (int y = 0; y < mapDimension; y++) {
                Coordinate currentCoordinate = new Coordinate(x, y);
                int resource = integerMap.getValue(x, y);

                if ((resource == 2 || resource == 3) && !monitoredResourceCoordinates.contains(currentCoordinate)) {
                    // Resource found, add it to the set of resourcesFound
                    resourcesFound.add(resource);
                    monitoredResourceCoordinates.add(currentCoordinate);
                   // System.out.println("Monitored resources: " + monitoredResourceCoordinates);
                    context.setMonitoredResourceCoordinate(monitoredResourceCoordinates);
                }
            }
        }

        // Update the context with the resources found during the scanning step
        Set<Integer> monitoredResources = context.getMonitoredResources();
        monitoredResources.addAll(resourcesFound);
        context.setMonitoredResources(monitoredResources);
    }
}


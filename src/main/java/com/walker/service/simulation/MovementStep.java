package com.walker.service.simulation;


import com.walker.model.rovers.Rover;
import com.walker.model.rovers.RoverPlacer;
import com.walker.model.settings.Settings;
import com.walker.model.simulation.SimulationContext;
import com.walker.service.map.Coordinate;
import com.walker.service.map.IntegerMap;
import com.walker.service.roverFactory.FactoryImpl;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class MovementStep implements SimulationStep {


    @Override
    public void execute(SimulationContext context) {

        IntegerMap integerMap = context.getIntegerMap();
        Rover rover = context.getRover();
        RoverPlacer roverPlacer = new RoverPlacer();
        List<Coordinate> monitoredResourceCoordinates = context.getMonitoredResourceCoordinate();
        boolean commandCenterExists = false;
        Coordinate commandCenterLocation = null;


        System.out.println(integerMap);
        for (Coordinate resourceToGet : new ArrayList<>(monitoredResourceCoordinates)) {


            if (rover.getResourceCoordinates().size() < Settings.NUM_RESOURCES_TO_BUILD_COMMAND_CENTER) {
                RoverCommands.collectResource(rover.getCurrentPosition(), resourceToGet, integerMap, rover, monitoredResourceCoordinates);
            } else {

                if (!commandCenterExists) {
                    commandCenterLocation = resourceToGet;
                    RoverCommands.buildCommandCenter(rover, integerMap, commandCenterLocation);
                    commandCenterExists = true;
                }

                // Assemble a new rover using the FactoryImpl
                FactoryImpl factory = new FactoryImpl();
                Coordinate startLocationForNewRover = roverPlacer.findEmptyAdjacentSpot(integerMap,commandCenterLocation);
                Rover newRover = factory.assembleRover(context.getConfiguration(), startLocationForNewRover);
                newRover.setId(2);

                for (int i = 0 ; i < monitoredResourceCoordinates.size() - 1; i++) {
                    System.out.println( " remaining resources : " + monitoredResourceCoordinates.size());
                    RoverCommands.collectResource(rover.getCurrentPosition(), monitoredResourceCoordinates.get(i), integerMap, rover, monitoredResourceCoordinates);

                    if (i + 1 < monitoredResourceCoordinates.size()) {
                        RoverCommands.collectResource(newRover.getCurrentPosition(), monitoredResourceCoordinates.get(i + 1), integerMap, newRover, monitoredResourceCoordinates);
                    } else {
                        System.out.println("No more resources to collect.");
                        System.out.println(" Mission Successful ");
                    }
                }
                }
            }

        }

    }


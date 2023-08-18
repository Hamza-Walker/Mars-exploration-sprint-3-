package com.walker.service.simulation;

import com.walker.model.exploration.ExplorationOutcome;
import com.walker.service.map.Coordinate;
import com.walker.service.map.IntegerMap;
import com.walker.model.rovers.Rover;
import com.walker.model.simulation.SimulationContext;
import com.walker.service.simulation.SimulationStep;

import java.util.HashSet;
import java.util.Set;

public class AnalysisStep implements SimulationStep {

    @Override
    public void execute(SimulationContext context) {
        // Implement the logic for the Analysis step here
        // For example, analyze the resources collected by the rover and update the exploration outcome in the context.
        // Use the IntegerMap instead of the Map.
        Rover rover = context.getRover();
        IntegerMap integerMap = context.getIntegerMap();

        Set<Integer> collectedResources = new HashSet<>();
        Set<Integer> monitoredResources = context.getMonitoredResources();

        for (Coordinate coordinate : rover.getResourceCoordinates()) {
            int resourceValue = integerMap.getValue(coordinate.getX(), coordinate.getY());
            if (resourceValue != 0) {
                collectedResources.add(resourceValue);
            }
        }

        // Check if all monitored resources are collected by the rover
        if (collectedResources.containsAll(monitoredResources)) {
            // All resources have been collected, update the exploration outcome to SUCCESS
            context.setExplorationOutcome(ExplorationOutcome.COLONIZABLE);
        } else {
            // Not all resources have been collected, update the exploration outcome to INCOMPLETE
            context.setExplorationOutcome(ExplorationOutcome.INCOMPLETE);
        }
    }
}

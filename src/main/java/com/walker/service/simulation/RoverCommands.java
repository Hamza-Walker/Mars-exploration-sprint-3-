package com.walker.service.simulation;

import com.walker.model.commandCenter.CommandCenter;
import com.walker.model.rovers.Rover;
import com.walker.model.settings.Settings;
import com.walker.service.map.Coordinate;
import com.walker.service.map.IntegerMap;

import java.util.List;

public class RoverCommands {


    public static void collectResource(Coordinate currentCoordinate, Coordinate targetResource, IntegerMap integerMap, Rover rover, List<Coordinate> monitoredResourceCoordinates) {
        List<Coordinate> path = AStarPathFinder.findPath(integerMap, currentCoordinate, targetResource);

        if (path == null) {
            System.out.println("No path found to the target resource.");
            return;
        }

        for (Coordinate coordinate : path) {
            System.out.println(" Rover " + rover.getId() + " Moving to: " + coordinate);
            simulateDelay(Settings.MOVEMENT_DELAY_MS);
        }

        System.out.println("Arrived at the resource. Loading...");
        simulateDelay(2000); // Loading time

        System.out.println("Resource collected!");

        // Update rover position, add collected resource to rover's inventory,
        // and remove resource from the original list
        rover.setCurrentPosition(targetResource);
        rover.addResourceCoordinate(targetResource);
        monitoredResourceCoordinates.remove(targetResource);

    }
    public static void buildCommandCenter(Rover rover, IntegerMap integerMap, Coordinate commandCenterLocation) {
        // Check if the rover has collected at least four resources
        if (rover.getResourceCoordinates().size() < 4) {
            System.out.println("Insufficient resources to build a command center.");
            return;
        }


        // Simulate the construction process with a delay
        System.out.println("Building command center...");
        simulateDelay(3000); // Construction time

        // Create a command center instance and update the rover's status
        CommandCenter commandCenter = new CommandCenter(1, commandCenterLocation.toString(), "Under Construction", rover.getResourceCoordinates());
        System.out.println("Command center built!");
        commandCenter.setStatus("Operational");
    }

    private static void simulateDelay(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

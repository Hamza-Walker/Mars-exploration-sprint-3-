package com.walker.service.simulation;

import com.walker.model.simulation.SimulationContext;
import com.walker.service.configuration.Configuration;
import com.walker.model.exploration.ExplorationOutcome;
import com.walker.service.maploader.MapLoader;
import com.walker.service.map.Coordinate;
import com.walker.service.map.IntegerMap;
import com.walker.service.roverFactory.Factory;
import com.walker.service.roverFactory.FactoryImpl;
import com.walker.model.rovers.Rover;
import com.walker.model.rovers.RoverPlacer;

import java.util.Arrays;
import java.util.List;


public class ExplorationSimulator {

    private final MapLoader mapLoader;
    private final RoverPlacer roverPlacer;

    public ExplorationSimulator(MapLoader mapLoader, RoverPlacer roverPlacer) {
        this.mapLoader = mapLoader;
        this.roverPlacer = roverPlacer;
    }


    public void simulateExploration(Configuration config) {

        // Step : 1 (Generate the Map)
        IntegerMap integerMap = mapLoader.createIntegerMap(config.mapPath());

        // Step : 2 (Set the Landing Coordinates for the spaceShip)
        Coordinate spaceshipCoordinate = config.landingSpot();

        // Step : 3 (Deploy the rover on an empty spot adjacent to the spaceship)
        Coordinate roverStartCoordinate = roverPlacer.findEmptyAdjacentSpot(integerMap, spaceshipCoordinate);
        Factory factory = new FactoryImpl();
        Rover rover = factory.assembleRover(config, roverStartCoordinate);

        roverPlacer.deployRover(integerMap, rover, roverStartCoordinate);


        // Create the simulation context and start the exploration
        SimulationContext context = new SimulationContext(
                config.numberOfSteps(),
                config.timeOut(),
                rover,
                integerMap,
                config.resources(),
                ExplorationOutcome.INCOMPLETE,
                config
        );

        // Start the exploration loop
        explore(context);

    }



    private void explore(SimulationContext context) {
        List<SimulationStep> steps = Arrays.asList(
                new ScanningStep(),
                new MovementStep()
        );

        for (int i = 0; i < context.getStepsToTimeout(); i++) {
            for (SimulationStep step : steps) {
                step.execute(context);
            }
        }
    }

}

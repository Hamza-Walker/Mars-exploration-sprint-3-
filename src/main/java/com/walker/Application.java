package com.walker;

import com.walker.service.configuration.ConfigurationImpl;
import com.walker.model.settings.Settings;
import com.walker.service.maploader.MapLoader;
import com.walker.service.maploader.MapLoaderImpl;
import com.walker.model.rovers.RoverPlacer;
import com.walker.service.simulation.ExplorationSimulator;

public class Application {

    public static void main(String[] args) {
        // Simulator Set_up
        MapLoader mapLoader = new MapLoaderImpl();
        RoverPlacer roverPlacer = new RoverPlacer();
        ExplorationSimulator explorationSimulator = new ExplorationSimulator(mapLoader, roverPlacer);
        
        // Configuration parameters
        ConfigurationImpl config = new ConfigurationImpl(
                Settings.NUMBER_OF_STEPS,
                Settings.TIMEOUT,
                Settings.ROVER_ID,
                Settings.LANDING_SPOT,
                Settings.SIGHT_RANGE,
                Settings.MAP_FILE,
                Settings.RESOURCES
        );

        // Run the Simulation !!
        explorationSimulator.simulateExploration(config);
    }
}
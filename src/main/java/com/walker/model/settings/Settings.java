package com.walker.model.settings;

import com.walker.service.map.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class Settings {
    public static final String MAP_FILE = "src/main/resources/exploration-2.map";
    public static final int NUMBER_OF_STEPS = 1;
    public static final int TIMEOUT = 1;
    public static final int ROVER_ID = 1;
    public static final Coordinate LANDING_SPOT = new Coordinate(0, 0);
    public static final int SIGHT_RANGE = 5;
    public static final Set<Integer> RESOURCES = new HashSet<>();
    public static final int NUM_RESOURCES_TO_BUILD_COMMAND_CENTER = 4;
    public static final int MOVEMENT_DELAY_MS = 150;


}

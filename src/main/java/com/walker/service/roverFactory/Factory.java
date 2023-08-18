package com.walker.service.roverFactory;

import com.walker.service.configuration.Configuration;
import com.walker.service.map.Coordinate;
import com.walker.model.rovers.Rover;


public interface Factory {
     Rover assembleRover(Configuration config, Coordinate StartLocation);
}

package com.walker.service.roverFactory;

import com.walker.service.configuration.Configuration;
import com.walker.service.map.Coordinate;
import com.walker.model.rovers.Rover;

public class FactoryImpl implements Factory {
    @Override
    public Rover assembleRover(Configuration config, Coordinate startLocation) {
        return new Rover(config.roverID(), startLocation.getX(), startLocation.getY(), config.sightRange());
    }
}

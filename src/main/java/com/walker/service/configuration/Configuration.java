package com.walker.service.configuration;


import com.walker.service.map.Coordinate;

import java.util.Set;

public interface Configuration {
    int numberOfSteps();
    int timeOut();
    int roverID();
    Coordinate landingSpot();
    int sightRange();
    String mapPath();

    Set <Integer> resources();
}
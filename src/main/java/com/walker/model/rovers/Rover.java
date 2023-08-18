package com.walker.model.rovers;


import com.walker.service.map.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Rover {
    private int id;
    private Coordinate currentPosition;
    private int sight;
    private final List<Coordinate> resourceCoordinates;

    public Rover(int id, int x, int y, int sight) {
            this.id = id;
        this.currentPosition = new Coordinate(x, y);
        this.sight = sight;
        this.resourceCoordinates = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Coordinate getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Coordinate currentPosition) {
        this.currentPosition = currentPosition;
    }

    public List<Coordinate> getResourceCoordinates() {
        return resourceCoordinates;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addResourceCoordinate(Coordinate resourceCoordinate) {
        this.resourceCoordinates.add(resourceCoordinate);
        // this keyword is used to differentiate between instance variables and method parameters with the same name.
    }

    @Override
    public String toString() {
        return "Rover{" +
                "id='" + id + '\'' +
                ", currentPosition=" + currentPosition +
                ", sight=" + sight +
                ", resourceCoordinates=" + resourceCoordinates +
                '}';
    }

}

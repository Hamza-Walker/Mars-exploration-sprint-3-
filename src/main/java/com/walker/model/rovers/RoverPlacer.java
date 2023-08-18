package com.walker.model.rovers;

import com.walker.service.map.Coordinate;
import com.walker.service.map.IntegerMap;

public class RoverPlacer {
    public void deployRover(IntegerMap integerMap, Rover rover, Coordinate emptyAdjacentSpot) {
        if (emptyAdjacentSpot == null) {
            System.out.println("No empty adjacent spot found, unable to deploy the rover");
            return;
        }

        int x = emptyAdjacentSpot.getX();
        int y = emptyAdjacentSpot.getY();

        rover.setCurrentPosition(new Coordinate(x,y));
        integerMap.setValue(x, y, rover.getId());

    }

    public Coordinate findEmptyAdjacentSpot(IntegerMap integerMap, Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();

        if (isValidCoordinate(x - 1, y, integerMap) && isEmptySpot(x - 1, y, integerMap)) {
            return new Coordinate(x - 1, y);
        } else if (isValidCoordinate(x + 1, y, integerMap) && isEmptySpot(x + 1, y, integerMap)) {
            return new Coordinate(x + 1, y);
        } else if (isValidCoordinate(x, y - 1, integerMap) && isEmptySpot(x, y - 1, integerMap)) {
            return new Coordinate(x, y - 1);
        } else if (isValidCoordinate(x, y + 1, integerMap) && isEmptySpot(x, y + 1, integerMap)) {
            return new Coordinate(x, y + 1);
        }

        return null;
    }

    private boolean isValidCoordinate(int x, int y, IntegerMap integerMap) {
        int dimension = integerMap.getDimension();
        return x >= 0 && x < dimension && y >= 0 && y < dimension;
    }


    public boolean isEmptySpot(int x, int y, IntegerMap integerMap) {
        return x >= 0 && x < integerMap.getDimension() &&
                y >= 0 && y < integerMap.getDimension() &&
                integerMap.getValue(x, y) == 0 ;
    }
}

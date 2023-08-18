package com.walker.service.map;

import com.walker.service.map.Coordinate;

import java.util.Arrays;

public class IntegerMap {
    private final int[][] representation;

    public IntegerMap(int[][] representation) {
        this.representation = representation;
    }

    public int getValue(int x, int y) {
        return representation[y][x];
    }

    public int getDimension() {
        return representation.length;
    }

    public void setValue(int x, int y, int value) {
        representation[y][x] = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int[] row : representation) {
            sb.append(Arrays.toString(row)).append(System.lineSeparator());
        }

        return sb.toString();
    }
}

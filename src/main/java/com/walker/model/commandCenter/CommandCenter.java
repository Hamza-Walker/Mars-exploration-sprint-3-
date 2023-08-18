package com.walker.model.commandCenter;

import com.walker.service.map.Coordinate;

import java.util.List;

public class CommandCenter {
    private int id ;
    private String location;
    private String status;
    private List <Coordinate> resourcesOnStock;

    public CommandCenter(int id, String location, String status, List <Coordinate> resourcesOnStock) {
        this.id = id;
        this.location = location;
        this.status = status;
        this.resourcesOnStock = resourcesOnStock;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Command Center " + id + ":\n" +
                "Location: " + location + "\n" +
                "Status: " + status + "\n" +
                "Resources on Stock: " + resourcesOnStock.toString();
    }
}

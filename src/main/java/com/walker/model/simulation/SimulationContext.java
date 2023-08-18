package com.walker.model.simulation;



import com.walker.model.exploration.ExplorationOutcome;
import com.walker.service.configuration.Configuration;
import com.walker.service.map.Coordinate;
import com.walker.service.map.IntegerMap;
import com.walker.model.rovers.Rover;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SimulationContext {
    private final int numberOfSteps;
    private final int stepsToTimeout;
    private final Configuration configuration;
    private int step; // Add the step variable
    private Rover rover;
    private final IntegerMap integerMap; // Add the IntegerMap property
    private Set<Integer> monitoredResources;
    private ExplorationOutcome explorationOutcome;
    public List<Coordinate> monitoredResourceCoordinate = new ArrayList<>();


    public SimulationContext(
            int numberOfSteps,
            int stepsToTimeout,
            Rover rover,
            IntegerMap integerMap, // Add the IntegerMap parameter
            Set<Integer> monitoredResources,
            ExplorationOutcome explorationOutcome,
            Configuration config
    ) {
        this.numberOfSteps = numberOfSteps;
        this.stepsToTimeout = stepsToTimeout;
        this.step = 0; // Set the initial step to 0
        this.rover = rover;
        this.integerMap = integerMap; // Assign the IntegerMap object
        this.monitoredResources = monitoredResources;
        this.explorationOutcome = explorationOutcome;
        this.configuration = config;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public int getStepsToTimeout() {
        return stepsToTimeout;
    }

    public int getStep() {
        return step;
    }
    public List<Coordinate> getMonitoredResourceCoordinate() {
        return monitoredResourceCoordinate;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public Rover getRover() {
        return rover;
    }

    public IntegerMap getIntegerMap() {
        return integerMap; // Add a getter for IntegerMap
    }

    public Set<Integer> getMonitoredResources() {
        return monitoredResources;
    }

    public ExplorationOutcome getExplorationOutcome() {
        return explorationOutcome;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public void setMonitoredResources(Set<Integer> monitoredResources) {
        this.monitoredResources = monitoredResources;
    }

//    public void addMonitoredResourceCoordinate(Coordinate coordinate){
//        this.monitoredResourceCoordinate.add(coordinate);
//    }

    public void setMonitoredResourceCoordinate(List<Coordinate> monitoredResourceCoordinate) {
        this.monitoredResourceCoordinate = monitoredResourceCoordinate;
    }

    public void setExplorationOutcome(ExplorationOutcome explorationOutcome) {
        this.explorationOutcome = explorationOutcome;
    }
}

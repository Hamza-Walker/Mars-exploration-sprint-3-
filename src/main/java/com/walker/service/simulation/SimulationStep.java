package com.walker.service.simulation;

import com.walker.model.simulation.SimulationContext;

public interface SimulationStep {
    void execute(SimulationContext context);
}


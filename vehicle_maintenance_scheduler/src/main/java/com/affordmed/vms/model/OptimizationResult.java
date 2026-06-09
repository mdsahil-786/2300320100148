package com.affordmed.vms.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OptimizationResult {

    private List<Vehicle> selectedVehicles;

    private Integer totalImpact;

    private Integer totalDuration;
}
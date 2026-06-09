package com.affordmed.vms.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OptimizedScheduleResponse {

    private Integer depotId;

    private Integer mechanicHours;

    private Integer totalImpact;

    private Integer totalDuration;

    private List<String> selectedTaskIds;
}
package com.affordmed.vms.controllers;

import com.affordmed.vms.model.OptimizedScheduleResponse;
import com.affordmed.vms.services.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/scheduler")
@RequiredArgsConstructor
public class SchedulerController {

    private final SchedulerService schedulerService;

    @GetMapping("/{depotId}")
    public OptimizedScheduleResponse optimizeSchedule(
            @PathVariable Integer depotId
    ) {

        return schedulerService.optimizeSchedule(depotId);
    }
}
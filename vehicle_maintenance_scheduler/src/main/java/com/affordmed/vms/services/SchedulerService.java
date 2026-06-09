package com.affordmed.vms.services;

import com.affordmed.vms.model.Depot;
import com.affordmed.vms.model.DepotResponse;
import com.affordmed.vms.model.OptimizedScheduleResponse;
import com.affordmed.vms.model.VehicleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final com.affordmed.vms.services.EvaluationApiService evaluationApiService;

    public OptimizedScheduleResponse optimizeSchedule(
            Integer depotId
    ) {

        DepotResponse depotResponse =
                evaluationApiService.getDepots();

        VehicleResponse vehicleResponse =
                evaluationApiService.getVehicles();

        Depot selectedDepot =
                depotResponse
                        .getDepots()
                        .stream()
                        .filter(depot ->
                                depot.getId()
                                        .equals(depotId))
                        .findFirst()
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Depot not found"
                                )
                        );

        return OptimizedScheduleResponse
                .builder()
                .depotId(selectedDepot.getId())
                .mechanicHours(
                        selectedDepot.getMechanicHours()
                )
                .totalImpact(0)
                .totalDuration(0)
                .selectedTaskIds(null)
                .build();
    }
}
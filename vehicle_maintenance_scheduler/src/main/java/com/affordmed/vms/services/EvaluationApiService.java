package com.affordmed.vms.services;

import com.affordmed.vms.model.DepotResponse;
import com.affordmed.vms.model.VehicleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class EvaluationApiService {

    private final RestTemplate restTemplate;

    private static final String DEPOT_URL =
            "http://4.224.186.213/evaluation-service/depots";

    private static final String VEHICLE_URL =
            "http://4.224.186.213/evaluation-service/vehicles";

    public DepotResponse getDepots() {

        return restTemplate.getForObject(
                DEPOT_URL,
                DepotResponse.class
        );
    }

    public VehicleResponse getVehicles() {

        return restTemplate.getForObject(
                VEHICLE_URL,
                VehicleResponse.class
        );
    }
}
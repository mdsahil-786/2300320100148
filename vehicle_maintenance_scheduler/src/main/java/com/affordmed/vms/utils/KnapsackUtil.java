package com.affordmed.vms.utils;

import com.affordmed.vms.model.OptimizationResult;
import com.affordmed.vms.model.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnapsackUtil {

    public static OptimizationResult optimize(
            List<Vehicle> vehicles,
            int capacity
    ) {

        int n = vehicles.size();

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            Vehicle vehicle = vehicles.get(i - 1);
            for (int w = 0; w <= capacity; w++) {
                if (vehicle.getDuration() <= w) {
                    dp[i][w] = Math.max(
                            vehicle.getImpact()
                                    + dp[i - 1][w - vehicle.getDuration()],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        List<Vehicle> selectedVehicles = new ArrayList<>();
        int totalDuration = 0;
        int w = capacity;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Vehicle vehicle = vehicles.get(i - 1);
                selectedVehicles.add(vehicle);
                totalDuration += vehicle.getDuration();
                w -= vehicle.getDuration();
            }
        }
        Collections.reverse(selectedVehicles);
        return new OptimizationResult(
                selectedVehicles,
                dp[n][capacity],
                totalDuration
        );
    }
}
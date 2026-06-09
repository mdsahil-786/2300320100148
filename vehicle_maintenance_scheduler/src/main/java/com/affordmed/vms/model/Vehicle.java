package com.affordmed.vms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Vehicle {

    @JsonProperty("TaskID")
    private String taskId;

    @JsonProperty("Duration")
    private Integer duration;

    @JsonProperty("Impact")
    private Integer impact;
}
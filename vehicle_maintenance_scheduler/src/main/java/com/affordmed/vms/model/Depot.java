

package com.affordmed.vms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Depot {

    @JsonProperty("ID")
    private Integer id;

    @JsonProperty("MechanicHours")
    private Integer mechanicHours;
}
package com.taurus.financeapi.modules.kitty.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KittyRequest {
    private String name;
    private String description;
    private Float goal;
    private Integer categoryId;
    @JsonProperty("quantity_available")
    private Integer quantityAvailable;
}

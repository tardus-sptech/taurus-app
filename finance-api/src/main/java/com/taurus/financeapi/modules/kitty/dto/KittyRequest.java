package com.taurus.financeapi.modules.kitty.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class KittyRequest {
    @NotBlank(message = "name is required.")
    private String name;
    @NotBlank(message = "description is required.")
    private String description;
    @Min(0)
    @NotNull(message = "goal is required.")
    private Float goal;
    @NotNull(message = "categoryId is required.")
    private Integer categoryId;
    @JsonProperty("quantity_available")
    @NotNull(message = "quantityAvailable is required.")
    private Integer quantityAvailable;
}

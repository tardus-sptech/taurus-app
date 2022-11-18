package com.taurus.financeapi.modules.spent.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SpentRequest {
    @NotBlank()
    private String name;
    @NotNull
    @Min(1)
    private Double value;
    @NotNull
    private Integer categoryId;
    @NotNull
    private Integer userId;

    public void updateValue(Double newValue) {
        value = newValue - value;
    }
}

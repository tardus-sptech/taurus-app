package com.taurus.financeapi.modules.spent.dto;

import lombok.Data;

@Data
public class SpentRequest {
    private String name;
    private Double value;
    private Integer categoryId;
}

package com.taurus.financeapi.modules.spentlimit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpentLimitRequest {
    private Double categorySpent;
    private Integer categoryId;
    private Integer userId;
}

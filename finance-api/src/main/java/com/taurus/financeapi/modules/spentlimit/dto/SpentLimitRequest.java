package com.taurus.financeapi.modules.spentlimit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpentLimitRequest {
    private Month month;
    private Double currentLimit;
    private Double monthSpent;
    private Double categorySpent;
    private Integer categoryId;
    private Integer userId;
}

package com.taurus.financeapi.modules.spentlimit.dto;

import lombok.Data;

import java.time.Month;


@Data
public class SpentLimitRequest {
    private Integer id;
    private Month month;
    private Double currentLimit;
    private Double monthSpent;
    private Double categorySpent;
    private Integer categoryId;
    private Integer userId;
}

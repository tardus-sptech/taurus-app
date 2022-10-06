package com.taurus.financeapi.modules.spent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpentValueQuantityDTO {
    private Integer spentId;
    private Double value;
}
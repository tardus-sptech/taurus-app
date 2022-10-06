package com.taurus.financeapi.modules.finances.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinanceSpentResponse {
    private List<String> financeIds;
}

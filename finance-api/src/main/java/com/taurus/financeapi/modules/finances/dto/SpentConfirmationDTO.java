package com.taurus.financeapi.modules.finances.dto;

import com.taurus.financeapi.modules.finances.enums.FinanceStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpentConfirmationDTO {
    private String spentiesId;
    private FinanceStatus status;
}

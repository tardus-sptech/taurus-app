package com.taurus.financeapi.modules.spent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpentValueDTO {
    private String financesId;
    private List<SpentValueQuantityDTO> spenties;
}



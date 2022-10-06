package com.taurus.financeapi.modules.spent.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taurus.financeapi.modules.category.dto.CategoryResponse;
import com.taurus.financeapi.modules.spent.model.Spent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpentFinanceResponse {
    private Integer id;
    private String name;
    private Double value;
    private CategoryResponse category;
    private List<String> finances;
    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    public static SpentFinanceResponse of(Spent spent,
                                          List<String> finances) {
        return SpentFinanceResponse
                .builder()
                .id(spent.getId())
                .name(spent.getName())
                .value(spent.getValue())
                .category(CategoryResponse.of(spent.getCategory()))
                .finances(finances)
                .createdAt(spent.getCreatedAt())
                .build();
    }
}

package com.taurus.financeapi.modules.spent.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taurus.financeapi.modules.category.dto.CategoryResponse;
import com.taurus.financeapi.modules.spent.model.Spent;
import com.taurus.financeapi.modules.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpentResponse {
    private Integer id;
    private String name;
    private Double value;
    private CategoryResponse category;
    private User user;
    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    public static SpentResponse of(Spent spent) {
        return SpentResponse
                .builder()
                .id(spent.getId())
                .name(spent.getName())
                .value(spent.getValue())
                .category(CategoryResponse.of(spent.getCategory()))
                .user(spent.getUser())
                .createdAt(spent.getCreatedAt())
                .build();
    }
    public void updateValue(Double newValue) {
        value = newValue - value;
    }
}
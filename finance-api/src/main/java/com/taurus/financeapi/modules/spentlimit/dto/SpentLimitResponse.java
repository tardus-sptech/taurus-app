package com.taurus.financeapi.modules.spentlimit.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taurus.financeapi.modules.category.model.Category;
import com.taurus.financeapi.modules.spentlimit.model.SpentLimit;
import com.taurus.financeapi.modules.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.Month;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpentLimitResponse {
    private Integer id;
    private Month month;
    private Double currentLimit;
    private Double monthSpent;
    private Double categorySpent;
    private Category category;
    private User user;
    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    public static SpentLimitResponse of(SpentLimit spentLimit) {
        return SpentLimitResponse
                .builder()
                .id(spentLimit.getId())
                .month(spentLimit.getMonth())
                .currentLimit(spentLimit.getCurrentLimit())
                .monthSpent(spentLimit.getMonthSpent())
                .categorySpent(spentLimit.getCategorySpent())
                .category(spentLimit.getCategory())
                .user(spentLimit.getUser())
                .createdAt(spentLimit.getCreatedAt())
                .build();
    }
}
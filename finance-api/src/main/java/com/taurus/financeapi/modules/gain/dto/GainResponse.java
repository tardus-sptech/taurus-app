package com.taurus.financeapi.modules.gain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.taurus.financeapi.modules.gain.model.Gain;
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
public class GainResponse {
    private Integer id;
    private String name;
    private Double value;
    private User user;
    @JsonProperty("created_at")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    public static GainResponse of(Gain gain) {
        return GainResponse
                .builder()
                .id(gain.getId())
                .name(gain.getName())
                .value(gain.getValue())
                .user(gain.getUser())
                .createdAt(gain.getCreatedAt())
                .build();
    }
}
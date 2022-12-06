package com.taurus.financeapi.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ResponseStatus(HttpStatus.OK)
public class SuccessResponse {
    private String message;

    public static SuccessResponse create(String message){
        return SuccessResponse
                .builder()
                .message(message)
                .build();
    }
}

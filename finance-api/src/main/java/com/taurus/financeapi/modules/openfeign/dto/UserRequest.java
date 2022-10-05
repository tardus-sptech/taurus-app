package com.taurus.financeapi.modules.openfeign.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserRequest {
    private UUID id;
    private String name;
    private String email;
}

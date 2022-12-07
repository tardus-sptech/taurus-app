package com.taurus.financeapi.modules.user.dto;

import lombok.Data;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Data
public class UserResetPasswordRequest {
    @Id
    private int id;
    @NotBlank
    private String password;
}

package com.taurus.financeapi.modules.user.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserLoggedRequest {
    @NotNull
    @NotBlank
    @Email
    @Size(max = 80)
    private String email;

    @NotNull
    @NotBlank
    @Size(min=6, max = 18)
    private String password;
}

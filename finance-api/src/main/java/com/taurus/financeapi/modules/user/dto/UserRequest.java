package com.taurus.financeapi.modules.user.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserRequest {
    private int id;
    private String name;
    private String cpf;
    private Date birthDate;
    private String email;
    private String password;
}

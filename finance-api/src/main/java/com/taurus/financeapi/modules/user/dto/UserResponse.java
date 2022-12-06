package com.taurus.financeapi.modules.user.dto;

import com.taurus.financeapi.modules.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class UserResponse {
    int id;
    private String name;
    private String cpf;
    private Date birthDate;
    private String email;

    public UserResponse(Integer idUsuario, Object name, Object cpf, Object birthDate, Object email, Object o, Object o1, Object o2, Object o3, Object o4, Object o5) {
    }

    public static UserResponse of(User user) {
        return UserResponse
                .builder()
                .id(user.getId())
                .name(user.getName())
                .cpf(user.getCpf())
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .build();
    }
}

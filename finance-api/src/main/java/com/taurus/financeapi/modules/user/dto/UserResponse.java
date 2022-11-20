package com.taurus.financeapi.modules.user.dto;

import com.taurus.financeapi.modules.category.dto.CategoryResponse;
import com.taurus.financeapi.modules.spent.dto.SpentResponse;
import com.taurus.financeapi.modules.spent.model.Spent;
import com.taurus.financeapi.modules.user.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserResponse {
    private int id;
    private String name;
    private String cpf;
    private Date birthDate;
    private String email;

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

package com.taurus.financeapi.modules.user.repository;

import com.taurus.financeapi.modules.user.dto.UserResetPasswordRequest;
import com.taurus.financeapi.modules.user.dto.UserResponse;
import com.taurus.financeapi.modules.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select new com.taurus.financeapi.modules.user.dto.UserResponse(u.id, u.name, u.cpf, u.birthDate, u.email) from User u where u.email = ?1 and u.password = ?2")
    Optional<UserResponse> getByEmailAndPassword(String email, String password);

    User findByPersonId(String personId);

    @Query(value = "update user u set password = ?1 where u.id = ?2", nativeQuery = true)
    void alterarSenha(UserResetPasswordRequest newPassword);
}
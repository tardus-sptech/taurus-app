package com.taurus.financeapi.modules.user.repository;

import com.taurus.financeapi.modules.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmailAndPassword(String email, String senha);
    User findByPersonId(String personId);
}
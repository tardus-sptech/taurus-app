package com.taurus.financeapi.modules.user.service;

import com.taurus.financeapi.config.exception.ValidationException;
import com.taurus.financeapi.modules.user.dto.UserResetPasswordRequest;
import com.taurus.financeapi.modules.user.dto.UserResponse;
import com.taurus.financeapi.modules.user.model.User;
import com.taurus.financeapi.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> users(){
        return userRepository.findAll();
    }

    public User register(User usuario) {
        userRepository.save(usuario);
        return usuario;
    }

    public User findById(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The user ID was not informed.");
        }
        return userRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no user for the given ID."));
    }

    public void updateValue(int id, double newValue) {
        var user = findById(id);
        user.setValueInAccount(user.getValueInAccount() - newValue);
    }

//    public User login(String email, String password) {
//        User user = userRepository.findUserByEmailAndPassword(email, password);
//        if(user == null || user.isLogged()) {
//            return null;
//        }
//        user.setLogged(true);
//        userRepository.save(user);
//        return user;
//    }

    public User logout(String personId) {
        User user = userRepository.findByPersonId(personId);
        if(user == null || !user.isLogged()) {
            return null;
        }
        user.setLogged(false);
        userRepository.save(user);
        return user;
    }

    public Optional<UserResponse> getByEmailAndPassword(String email, String senha) {
        return userRepository.getByEmailAndPassword(email, senha);
    }

    public void updatePassword(UserResetPasswordRequest newPassword) {
        userRepository.alterarSenha(newPassword);
    }
}

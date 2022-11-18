package com.taurus.financeapi.modules.user.controller;

import com.taurus.financeapi.modules.user.model.User;
import com.taurus.financeapi.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> users() {
        List<User> usuarios = userService.users();
        return (!usuarios.isEmpty()) ? ResponseEntity.status(HttpStatus.OK).body(usuarios) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(user));
    }

    @PatchMapping("/login/{email}/{senha}")
    public ResponseEntity<User> login(@PathVariable String email, @PathVariable String password) {
        User usuario = userService.login(email, password);
        return (usuario != null) ? ResponseEntity.status(HttpStatus.OK).body(usuario) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PatchMapping("/logout/{personId}")
    public ResponseEntity<User> logout(@PathVariable String personId) {
        User user = userService.logout(personId);
        return (user != null) ? ResponseEntity.status(HttpStatus.OK).body(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
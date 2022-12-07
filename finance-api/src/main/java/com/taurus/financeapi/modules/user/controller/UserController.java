package com.taurus.financeapi.modules.user.controller;

import com.taurus.financeapi.modules.user.dto.UserLoggedRequest;
import com.taurus.financeapi.modules.user.dto.UserResetPasswordRequest;
import com.taurus.financeapi.modules.user.dto.UserResponse;
import com.taurus.financeapi.modules.user.model.User;
import com.taurus.financeapi.modules.user.service.UserService;
import com.taurus.financeapi.modules.user.util.GerenciadorUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{idUser}")
    public ResponseEntity<User> getUserById(@PathVariable @Valid int idUser){
        User user = userService.findById(idUser);
        return (user != null) ? ResponseEntity.status(HttpStatus.OK).body(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<User>> users() {
        List<User> usuarios = userService.users();
        return (!usuarios.isEmpty()) ? ResponseEntity.status(HttpStatus.OK).body(usuarios) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(user));
    }

//    @PatchMapping("/login/{email}/{senha}")
//    public ResponseEntity<User> login(@PathVariable String email, @PathVariable String password) {
//        User usuario = userService.login(email, password);
//        return (usuario != null) ? ResponseEntity.status(HttpStatus.OK).body(usuario) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody @Valid UserLoggedRequest user) {
        Optional<UserResponse> usuarioPesquisado = userService.getByEmailAndPassword(user.getEmail(), user.getPassword());

        if (usuarioPesquisado.isEmpty()) {
            return status(404).build();
        }

        Optional<UserResponse> usuarioLogado = GerenciadorUsuario.buscaUsuarioLogado(usuarioPesquisado.get().getId());

        if (usuarioLogado.isPresent()) {
            return status(409).build();
        }

        GerenciadorUsuario.login(usuarioPesquisado.get());

        return status(200).body(usuarioPesquisado.get());
    }

    @PatchMapping("/logout/{personId}")
    public ResponseEntity<User> logout(@PathVariable String personId) {
        User user = userService.logout(personId);
        return (user != null) ? ResponseEntity.status(HttpStatus.OK).body(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PatchMapping("/alterar/{personId}")
    public ResponseEntity<User> alterar(@RequestBody UserResetPasswordRequest newPassword) {
        userService.updatePassword(newPassword);
        return status(200).build();
    }
}
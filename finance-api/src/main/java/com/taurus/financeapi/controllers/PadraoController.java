package com.taurus.financeapi.controllers;

import com.taurus.financeapi.models.usuarios.Padrao;
import com.taurus.financeapi.models.usuarios.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/usuarios/padroes")
@RestController
public class PadraoController {
    List<Padrao> usuariosPadroes;

    public PadraoController() {
        this.usuariosPadroes = new ArrayList<>();
    }

    @PostMapping
    public Usuario post(@RequestBody Padrao novoUsuario) {
        usuariosPadroes.add(novoUsuario);
        return novoUsuario;
    }

    @PostMapping("/autenticacao/{cpf}/{senha}")
    public Object autenticacao(@PathVariable String cpf,
                               @PathVariable String senha) {

        for (Usuario u : usuariosPadroes) {
            if (!u.isAutenticado()) {
                if (u.isAutenticado()) {
                    u.autenticar(cpf, senha);
                    return u;
                }
            }
        }
        return "Usuário não encontrado";
    }

    @GetMapping
    public List<Padrao> getUsuarios() {
        return usuariosPadroes;
    }
}

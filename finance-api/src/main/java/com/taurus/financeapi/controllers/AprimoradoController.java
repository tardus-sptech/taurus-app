package com.taurus.financeapi.controllers;

import com.taurus.financeapi.models.Gasto;
import com.taurus.financeapi.models.usuarios.Aprimorado;
import com.taurus.financeapi.models.usuarios.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/usuarios/aprimorados")
@RestController
public class AprimoradoController {
    List<Aprimorado> usuariosAprimorados;
    List<Gasto> gastos;

    public AprimoradoController() {
        this.usuariosAprimorados = new ArrayList<>();
        this.gastos = new ArrayList<>();
    }

    @PostMapping
    public Usuario post(@RequestBody Aprimorado novoUsuario) {
        usuariosAprimorados.add(novoUsuario);
        return novoUsuario;
    }

    @PostMapping("/autenticacao/{cpf}/{senha}")
    public Object autenticacao(@PathVariable String cpf,
                               @PathVariable String senha) {

        for (Usuario u : usuariosAprimorados) {
            if (u.getCpf().equals(cpf)) {
                if (!u.isAutenticado()) {
                    u.autenticar(cpf, senha);
                    return u;
                }
            }

        }
        return "Usuário não encontrado";
    }

    @GetMapping
    public List<Aprimorado> getUsuarios() {
        return usuariosAprimorados;
    }

    @PostMapping("/gasto")
    public void gasto(@RequestBody Gasto novoGasto,
                      @RequestHeader String cpf,
                      @RequestHeader String nomeGasto,
                      @RequestHeader double valorGasto) {
        for (Aprimorado usuario : usuariosAprimorados) {
            if (usuario.getCpf().equals(cpf)) {
                novoGasto.setNome(nomeGasto);
                novoGasto.setValor(valorGasto);
                novoGasto.setUsuario(usuario);
                gastos.add(novoGasto);
            }
        }
    }

    @GetMapping("/gasto")
    public List<Gasto> getGastos() {
        return gastos;
    }
}

package com.taurus.financeapi.models;

import com.taurus.financeapi.models.usuarios.Usuario;

public class Gasto {
    private String nome;
    private double valor;
    private Usuario usuario;

    public Gasto(String nome, double valor, Usuario usuario) {
        this.nome = nome;
        this.valor = valor;
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

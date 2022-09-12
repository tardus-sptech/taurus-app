package com.taurus.financeapi.models.usuarios;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public abstract class Usuario {
    private String nome;
    private String senha;
    private String email;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    private boolean autenticado;

    public Usuario(String nome, String senha, String email, String cpf, Date dataNascimento) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.autenticado = false;
    }

    public abstract boolean metasConjuntas();
    public abstract boolean openBanking();
    public abstract double metasConjuntasLimite();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public void autenticar(String usuario, String senha) {
        if (usuario.equals(getCpf()) && this.senha.equals(senha)) {
            setAutenticado(true);
        }
    }
}

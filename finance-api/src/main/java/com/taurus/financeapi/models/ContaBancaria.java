package com.taurus.financeapi.models;

public class ContaBancaria {
    private String instituicao;
    private String tipo;
    private String apelido;
    private String descricao;
    private boolean principal;

    public ContaBancaria(String instituicao, String tipo, String apelido, String descricao, boolean principal) {
        this.instituicao = instituicao;
        this.tipo = tipo;
        this.apelido = apelido;
        this.descricao = descricao;
        this.principal = principal;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "instituicao='" + instituicao + '\'' +
                ", tipo='" + tipo + '\'' +
                ", apelido='" + apelido + '\'' +
                ", descricao='" + descricao + '\'' +
                ", principal=" + principal +
                '}';
    }
}

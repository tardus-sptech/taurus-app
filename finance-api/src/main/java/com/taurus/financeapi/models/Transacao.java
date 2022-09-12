package com.taurus.financeapi.models;

import java.util.Date;

public class Transacao {
    private Date dataTransacao;
    private String categoriaTransacao;
    private double valor;

    public Transacao(Date dataTransacao, String categoriaTransacao, double valor) {
        this.dataTransacao = dataTransacao;
        this.categoriaTransacao = categoriaTransacao;
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public String getCategoriaTransacao() {
        return categoriaTransacao;
    }

    public void setCategoriaTransacao(String categoriaTransacao) {
        this.categoriaTransacao = categoriaTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

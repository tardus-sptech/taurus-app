package com.taurus.financeapi.models;

import java.util.Date;

public class Cartao {
    private int numCartao;
    private String nomeTitular;
    private Date dataValidade;
    private String cvv;

    public Cartao(int numCartao, String nomeTitular, Date dataValidade, String cvv) {
        this.numCartao = numCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
    }

    public int getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(int numCartao) {
        this.numCartao = numCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "numCartao=" + numCartao +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", dataValidade=" + dataValidade +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}

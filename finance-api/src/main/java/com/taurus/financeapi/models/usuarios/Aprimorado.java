package com.taurus.financeapi.models.usuarios;

import com.taurus.financeapi.models.Gasto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aprimorado extends Usuario {
    List<Gasto> gastos;

    public Aprimorado(String nome, String senha, String email, String cpf, Date dataNascimento) {
        super(nome, senha, email, cpf, dataNascimento);
        gastos = new ArrayList<>();
    }

    @Override
    public boolean metasConjuntas() {
        return true;
    }

    @Override
    public boolean openBanking() {
        return true;
    }

    @Override
    public double metasConjuntasLimite() {
        return 2;
    }

    public void cadastraGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public Gasto visualizaGasto() {
        for (Gasto gasto : gastos) {
            return gasto;
        }
        return null;
    }
}

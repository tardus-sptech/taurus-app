package com.taurus.financeapi.models.usuarios;

import com.taurus.financeapi.models.Gasto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Padrao extends Usuario {
    List<Gasto> gastos;

    public Padrao(String nome, String senha, String email, String cpf, Date dataNascimento) {
        super(nome, senha, email, cpf, dataNascimento);
        gastos = new ArrayList<>();
    }

    @Override
    public boolean metasConjuntas() {
        return false;
    }

    @Override
    public boolean openBanking() {
        return false;
    }

    @Override
    public double metasConjuntasLimite() {
        return 0;
    }

    public void cadastraGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public double visualizaGasto() {
        for (Gasto gasto : gastos) {
            return gasto.getValor();
        }
        return 0.0;
    }
}

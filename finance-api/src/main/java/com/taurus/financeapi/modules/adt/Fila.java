package com.taurus.financeapi.modules.adt;

import com.taurus.financeapi.modules.spent.model.Spent;

import java.util.ArrayList;
import java.util.List;

public class Fila {


    private int tamanho;
    private Spent[] fila;

    public Fila(int capacidade) {
        tamanho = 0;
        fila = (Spent[]) new Spent[capacidade];
    }

    public Boolean isEmpty() {
        return tamanho == 0;
    }

    public Boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(Spent info) {
        if (isFull()) {
            throw new IllegalStateException();
        } else {
            fila[tamanho++] = info;
        }
    }

    public Spent peek() {
        return fila[0];
    }


    public Spent poll() {
        Spent primeiro = peek(); // salva o primeiro elemento da fila

        if (!isEmpty()) { // se a fila não está vazia
            // faz a fila andar
            for (int i = 0; i < tamanho - 1; i++) {
                fila[i] = fila[i + 1];
            }
            fila[tamanho - 1] = null;    // limpa o último cara da fila
            tamanho--;                 // decrementa tamanho
        }

        return primeiro;
    }

    public List<Spent> listaBuscas() {
        List<Spent> buscas = new ArrayList<>();
        if (isEmpty()) {
            System.out.println("A fila está vazia");
            return buscas;
        } else {
            for (int i = 0; i < getTamanho(); i++) {
                buscas.set(i, fila[i]);
            }
        }
        return buscas;
    }

    // Getters (não retirar)
    public Spent[] getFila() {
        return fila;
    }

    public int getTamanho() {
        return tamanho;
    }
}

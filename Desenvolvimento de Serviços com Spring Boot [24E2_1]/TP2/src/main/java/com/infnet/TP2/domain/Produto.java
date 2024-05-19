package com.infnet.TP2.domain;

public class Produto {

    private int id;
    private String nome;
    private double valor;

    public Produto(int id, String nome, double valor){
        this.setId(id);
        this.setNome(nome);
        this.setValor(valor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}

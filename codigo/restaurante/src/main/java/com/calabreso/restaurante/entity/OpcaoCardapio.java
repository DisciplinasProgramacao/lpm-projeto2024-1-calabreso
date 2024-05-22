package com.calabreso.restaurante.entity;

public class OpcaoCardapio {
    String nome;
    double preco;
    int id;
    String tipo;

    public OpcaoCardapio(String nome, double preco, int id, String tipo) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
        this.tipo = tipo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

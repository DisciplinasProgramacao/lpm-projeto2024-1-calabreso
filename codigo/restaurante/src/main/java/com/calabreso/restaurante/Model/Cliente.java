package com.calabreso.restaurante.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = Cliente.TABLE_NAME)
public class Cliente {
    public interface CreateCliente { }
    public interface UpdateCliente { }

    public static final String TABLE_NAME = "cliente";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id", unique = true)
    private Integer clienteId;

    @Column(name = "nome", nullable = false)
    @NotNull(groups = CreateCliente.class)
    @NotEmpty(groups = CreateCliente.class)
    private String nome;

    public Cliente() {
    }

    public Cliente(Integer clienteId, String nome) {
        this.clienteId = clienteId;
        this.nome = nome;
    }

    public int getClienteId() {
        return clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteId=" + clienteId +
                ", nome='" + nome + '\'' +
                '}';
    }
}
package com.lpm.gardenbites.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restauranteId;

    @Column
    private String nome;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column
    private List<Mesa> mesas;

    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column
    private List<Requisicao> requisicoes;

    public Restaurante() {
    }

    public Integer getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Integer restauranteId) {
        this.restauranteId = restauranteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public List<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    public void setRequisicoes(List<Requisicao> requisicoes) {
        this.requisicoes = requisicoes;
    }

    public void addRequisicao(Requisicao requisicao) {
        requisicoes.add(requisicao);
    }

    public void finalizeRequisicao() {
        requisicoes.stream().filter(Requisicao::isAtendida).forEach(req -> {
            if (req.getDataHoraSaida() == null) {
                req.setDataHoraSaida(LocalDateTime.now());
                req.setFinalizada(true);
                mesas.stream().filter(mesa -> mesa.getMesaId().equals(req.getMesa().getMesaId())).findFirst().ifPresent(Mesa::liberarMesa);
            }
        });
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "restauranteId=" + restauranteId +
                '}';
    }
}

package com.calabreso.restaurante.entity;


import javax.persistence.*;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "restaurante")
public class Restaurante {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer restauranteId;

    @Column
    private String nome;

//    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
//    @Column
//    private List<Mesa> mesas;
    
//    @OneToMany(mappedBy = "restaurante", cascade = CascadeType.ALL, orphanRemoval = true)
//    @Column
//    private List<Requisicao> requisicoes;
    @Id
    private Long id;

    private Mesa[] mesas = new Mesa[]{
            new Mesa(4),
            new Mesa(4),
            new Mesa(4),
            new Mesa(4),
            new Mesa(6),
            new Mesa(6),
            new Mesa(6),
            new Mesa(6),
            new Mesa(8),
            new Mesa(8),
    };

    public Restaurante() {
    }

    public void setRestauranteId(Integer restauranteId) {
        this.id = Long.valueOf(restauranteId);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Mesa[] getMesas() {
        return mesas;
    }

    public void setMesas(Mesa[] mesas) {
        this.mesas = mesas;
    }

//    public List<Requisicao> getRequisicoes() {
//        return requisicoes;
//    }

//    public void setRequisicoes(List<Requisicao> requisicoes) {
//        this.requisicoes = requisicoes;
//    }

//    public void addRequisicao(Requisicao requisicao) {
//        requisicoes.add(requisicao);
//    }

//    public void finalizeRequisicao() {
//        requisicoes.stream().filter(Requisicao::estahEncerrada).forEach(req -> {
//            if (req.calcularTotal() == null) {
//                req.setDataHoraSaida(LocalDateTime.now());
//                req.setFinalizada(true);
//                mesas.stream().filter(mesa -> mesa.getMesaId().equals(req.getMesa().getMesaId())).findFirst().ifPresent(Mesa::liberarMesa);
//            }
//        });
//    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "restauranteId=" + id +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Requisicao processarFila() {
        return new Requisicao(1, new com.calabreso.restaurante.entity.Cliente());
    }

    public Requisicao encerrarAtendimento(int idMesa) {
        return new Requisicao(1, new com.calabreso.restaurante.entity.Cliente());
    }

    public void registrarRequisicao(Requisicao novaRequisicao) {
    }

    public String mostrarFila() {
        return "Cliente 1\nCliente 2\nCliente 3\n\nTotal: 3 pessoas aguardando na fila";
    }

    public boolean statusMesas() {
        return true;
    }

    public com.calabreso.restaurante.entity.Cliente localizarCliente(int idCli) {
        return new com.calabreso.restaurante.entity.Cliente();
    }

    public void addCliente(com.calabreso.restaurante.entity.Cliente localizado) {
    }

    public Mesa getMesaById(int idMesa) {
        return Arrays.stream(this.mesas).filter(mesa -> mesa.getIdMesa() == idMesa).findFirst().get();
    }
}

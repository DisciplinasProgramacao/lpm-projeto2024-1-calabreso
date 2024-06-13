package com.calabreso.restaurante.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.calabreso.restaurante.entity.Mesa;

/**
 * Controlador responsável por gerenciar as operações relacionadas a entidades Mesa.
 */
@Controller
@RequestMapping("/mesas")
public class MesaController {

    // Injeta a fábrica de EntityManager para gerenciar as entidades JPA
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    /**
     * Método para criar uma nova entidade Mesa.
     * 
     * @param mesa A entidade Mesa recebida no corpo da requisição.
     * @return A entidade Mesa criada.
     */
    @PostMapping("/criar")
    @ResponseBody
    public Mesa criarMesa(@RequestBody Mesa mesa) {
        // Cria um EntityManager a partir da fábrica
        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            // Inicia a transação
            em.getTransaction().begin();
            // Persiste a entidade Mesa no banco de dados
            em.persist(mesa);
            // Comita a transação
            em.getTransaction().commit();
        } finally {
            // Fecha o EntityManager se estiver aberto
            if (em.isOpen()) {
                em.close();
            }
        }

        // Retorna a entidade Mesa criada
        return mesa;
    }

    /**
     * Método para buscar uma entidade Mesa pelo seu ID.
     * 
     * @param id O ID da entidade Mesa a ser buscada.
     * @return A entidade Mesa encontrada, ou null se não for encontrada.
     */
    @GetMapping("/buscar/{id}")
    @ResponseBody
    public Mesa getMesa(@PathVariable Integer id) {
        // Cria um EntityManager a partir da fábrica
        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            // Busca a entidade Mesa pelo ID
            Mesa mesa = em.find(Mesa.class, id);
            return mesa;
        } finally {
            // Fecha o EntityManager se estiver aberto
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}

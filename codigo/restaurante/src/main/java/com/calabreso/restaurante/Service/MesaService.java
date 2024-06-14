package com.calabreso.restaurante.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;

import com.calabreso.restaurante.entity.Mesa;

@Service
public class MesaService {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public Mesa criarMesa(Mesa mesa) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mesa);
            em.getTransaction().commit();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
        return mesa;
    }

    public Mesa getMesa(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            Mesa mesa = em.find(Mesa.class, id);
            return mesa;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }
}

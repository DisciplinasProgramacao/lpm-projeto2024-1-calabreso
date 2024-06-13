package com.calabreso.restaurante.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.calabreso.restaurante.entity.Mesa;

@Controller
@RequestMapping("/mesas")
public class MesaController {

@PersistenceUnit
private EntityManagerFactory entityManagerFactory;

@PostMapping("/criar")
@ResponseBody
public Mesa criarMesa(@RequestBody Mesa mesa) {
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

@GetMapping("/buscar/{id}")
 @ResponseBody
 public Mesa getMesa(@PathVariable Integer id) {
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

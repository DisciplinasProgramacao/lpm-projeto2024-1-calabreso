package com.calabreso.restaurante.Service;

import com.calabreso.restaurante.entity.Cliente;
import com.calabreso.restaurante.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente createCliente(String nome) {
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }
}

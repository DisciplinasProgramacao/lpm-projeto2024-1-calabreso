package com.calabreso.restaurante;

import java.util.Scanner;

import com.calabreso.restaurante.entity.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.calabreso.restaurante.entity.Requisicao;
import com.calabreso.restaurante.entity.Restaurante;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository; // Injeção do repositório de clientes

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        if (cliente.getNomeCliente().length() <= 2) {
            return ResponseEntity.badRequest().body(null);
        }

        clienteRepository.save(cliente);
        return ResponseEntity.created(URI.create("/clientes/" + cliente.getIdCliente())).body(cliente);
    }

    @GetMapping
    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable int idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable int idCliente, @RequestBody Cliente clienteAtualizado) {
        Cliente clienteExistente = clienteRepository.findById(idCliente).orElse(null);
        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }

        if (clienteAtualizado.getNomeCliente().length() <= 2) {
            return ResponseEntity.badRequest().body(null);
        }

        clienteExistente.setNomeCliente(clienteAtualizado.getNomeCliente());
        clienteRepository.save(clienteExistente);
        return ResponseEntity.ok(clienteExistente);
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> deletarCliente(@PathVariable int idCliente) {
        clienteRepository.deleteById(idCliente);
        return ResponseEntity.noContent().build();
    }
}

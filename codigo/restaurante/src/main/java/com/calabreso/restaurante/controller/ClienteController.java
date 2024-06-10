package com.calabreso.restaurante;

import com.calabreso.restaurante.entity.Cliente;
import com.calabreso.restaurante.repository.ClienteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository; // Injeção do repositório de clientes

    @PostMapping
    public ResponseEntity<Cliente> criarCliente(@Valid @RequestBody Cliente cliente) {
        if (cliente.getNomeCliente().length() <= 2) {
            return ResponseEntity.badRequest().build();
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
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable int idCliente, @Valid @RequestBody Cliente clienteAtualizado) {
        Cliente clienteExistente = clienteRepository.findById(idCliente).orElse(null);
        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }

        if (clienteAtualizado.getNomeCliente().length() <= 2) {
            return ResponseEntity.badRequest().build();
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

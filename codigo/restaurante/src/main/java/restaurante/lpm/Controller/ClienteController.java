import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente addCliente(@RequestParam String nome) {
        return clienteService.addCliente(nome);
    }

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }
}

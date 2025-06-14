package co.edu.iudigital.pos.controller;

import co.edu.iudigital.pos.domain.model.Client;
import co.edu.iudigital.pos.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        System.out.println("getAll...");
        List<Client> clientList = clientService.getAll();

        clientList.forEach(client -> {
            System.out.println("Cliente:");
            System.out.println("  ID: " + client.getId());
            System.out.println("  Nombre: " + client.getName());
            System.out.println("  Email: " + client.getEmail());
            System.out.println("  Teléfono: " + client.getPhone());
            System.out.println("  Documento: " + client.getDocument());
        });


        return ResponseEntity.ok(clientList);
        // return ResponseEntity.ok(clientService.getAll());


    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) {
        return ResponseEntity.ok(clientService.save(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package co.edu.iudigital.pos.controller;

import co.edu.iudigital.pos.domain.model.Provider;
import co.edu.iudigital.pos.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// TODO: DOCUMENTAR CON ANOTACIONES SWAGGER
@RestController
@RequestMapping("/providers")
@Slf4j
public class ProviderController {

    private final ProviderService providerService;

    public ProviderController(
            final ProviderService providerService
    ) {
        this.providerService = providerService;
    }

    // TODO: Documentación Swagger, security,
    @GetMapping
    public ResponseEntity<List<Provider>> getProviders() {
        log.info("Llamando a getProviders");
        return ResponseEntity.ok(providerService.getAllProviders());
    }

    // TODO: Documentación Swagger, security,
    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviders(@PathVariable Long id) {
        return ResponseEntity.ok(providerService.getProviderById(id));
    }

    // TODO: Documentación Swagger, security, DTO
    @PostMapping
    public ResponseEntity<Provider> saveProviders(@RequestBody Provider provider) {
        log.info("Llamando a saveProviders");
        return ResponseEntity.ok(providerService.saveProvider(provider));
    }

    // TODO: Documentación Swagger, security, método en service para editar
   /* @PutMapping
    public ResponseEntity<Provider> editProviders(@RequestBody Provider provider) {
        return ResponseEntity.ok(providerService.saveProvider(provider));
    }*/

    // TODO: Documentación Swagger, security
    @DeleteMapping("/{id}")
    public void deleteProvider(@PathVariable Long id) {
        providerService.deleteProviderById(id); // TODO: COLOCAR ESTADO RESPUESTA HTTP
    }

}

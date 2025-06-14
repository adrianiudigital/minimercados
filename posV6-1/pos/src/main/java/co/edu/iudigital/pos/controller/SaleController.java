package co.edu.iudigital.pos.controller;

import co.edu.iudigital.pos.domain.model.Sale;
import co.edu.iudigital.pos.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<Sale>> getAll() {
        return ResponseEntity.ok(saleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Sale> save(@RequestBody Sale sale) {
        return ResponseEntity.ok(saleService.save(sale));
    }
}

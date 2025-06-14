package co.edu.iudigital.pos.service;

import co.edu.iudigital.pos.domain.model.Sale;

import java.util.List;

public interface SaleService {
    List<Sale> getAll();
    Sale getById(Long id);
    Sale save(Sale sale);
}

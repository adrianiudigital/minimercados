package co.edu.iudigital.pos.port;

import co.edu.iudigital.pos.domain.model.Sale;

import java.util.List;

public interface SalePort {

    List<Sale> getAll();

    Sale getById(Long id);

    Sale save(Sale sale);
}

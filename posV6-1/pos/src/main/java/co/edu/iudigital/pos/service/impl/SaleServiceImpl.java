package co.edu.iudigital.pos.service.impl;

import co.edu.iudigital.pos.domain.model.Sale;
import co.edu.iudigital.pos.port.SalePort;
import co.edu.iudigital.pos.service.SaleService;

import java.util.List;

public class SaleServiceImpl implements SaleService {

    private final SalePort port;

    public SaleServiceImpl(SalePort port) {
        this.port = port;
    }

    @Override
    public List<Sale> getAll() {
        return port.getAll();
    }

    @Override
    public Sale getById(Long id) {
        return port.getById(id);
    }

    @Override
    public Sale save(Sale sale) {
        return port.save(sale);
    }
}

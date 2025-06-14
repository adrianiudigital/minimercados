package co.edu.iudigital.pos.service.impl;

import co.edu.iudigital.pos.domain.model.Product;
import co.edu.iudigital.pos.port.ProductPort;
import co.edu.iudigital.pos.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductPort port;

    public ProductServiceImpl(ProductPort port) {
        this.port = port;
    }

    @Override
    public List<Product> getAll() {
        return port.getAll();
    }

    @Override
    public Product getById(Long id) {
        return port.getById(id);
    }

    @Override
    public Product save(Product product) {
        return port.save(product);
    }

    @Override
    public void delete(Long id) {
        port.delete(id);
    }
}

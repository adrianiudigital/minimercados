package co.edu.iudigital.pos.port;

import co.edu.iudigital.pos.domain.model.Product;

import java.util.List;

public interface ProductPort {

    List<Product> getAll();

    Product getById(Long id);

    Product save(Product product);

    void delete(Long id);
}

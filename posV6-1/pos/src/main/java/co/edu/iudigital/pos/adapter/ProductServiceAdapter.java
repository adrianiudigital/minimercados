package co.edu.iudigital.pos.adapter;

import co.edu.iudigital.pos.adapter.mapper.ProductMapper;
import co.edu.iudigital.pos.domain.model.Product;
import co.edu.iudigital.pos.infrastructure.persistence.JpaCategoryRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaProductRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaProviderRepository;
import co.edu.iudigital.pos.infrastructure.persistence.entity.CategoryEntity;
import co.edu.iudigital.pos.infrastructure.persistence.entity.ProductEntity;
import co.edu.iudigital.pos.infrastructure.persistence.entity.ProviderEntity;
import co.edu.iudigital.pos.port.ProductPort;

import java.util.List;

public class ProductServiceAdapter implements ProductPort {

    private final ProductMapper productMapper = ProductMapper.INSTANCE;
    private final JpaProductRepository productRepository;
    private final JpaCategoryRepository categoryRepository;
    private final JpaProviderRepository providerRepository;

    public ProductServiceAdapter(
            JpaProductRepository productRepository,
            JpaCategoryRepository categoryRepository,
            JpaProviderRepository providerRepository
    ) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.providerRepository = providerRepository;
    }

    @Override
    public List<Product> getAll() {
        return productMapper.toProducts(productRepository.findAll());
    }

    @Override
    public Product getById(Long id) {
        return productMapper.toProduct(productRepository.findById(id).orElseThrow());
    }

    @Override
    public Product save(Product product) {
        CategoryEntity category = categoryRepository.findById(product.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        ProviderEntity provider = providerRepository.findById(product.getProviderId())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        ProductEntity entity = productMapper.toProductEntity(product);
        entity.setCategory(category);
        entity.setProvider(provider);

        return productMapper.toProduct(productRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}

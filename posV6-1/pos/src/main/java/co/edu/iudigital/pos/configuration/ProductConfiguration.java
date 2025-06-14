package co.edu.iudigital.pos.configuration;

import co.edu.iudigital.pos.adapter.ProductServiceAdapter;
import co.edu.iudigital.pos.infrastructure.persistence.JpaCategoryRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaProductRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaProviderRepository;
import co.edu.iudigital.pos.port.ProductPort;
import co.edu.iudigital.pos.service.ProductService;
import co.edu.iudigital.pos.service.impl.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public ProductPort productPort(
            JpaProductRepository productRepository,
            JpaCategoryRepository categoryRepository,
            JpaProviderRepository providerRepository
    ) {
        return new ProductServiceAdapter(productRepository, categoryRepository, providerRepository);
    }

    @Bean
    public ProductService productService(ProductPort port) {
        return new ProductServiceImpl(port);
    }
}

package co.edu.iudigital.pos.configuration;

import co.edu.iudigital.pos.adapter.SaleServiceAdapter;
import co.edu.iudigital.pos.infrastructure.persistence.JpaClientRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaProductRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaSaleDetailRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaSaleRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaUserRepository;
import co.edu.iudigital.pos.port.SalePort;
import co.edu.iudigital.pos.service.SaleService;
import co.edu.iudigital.pos.service.impl.SaleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaleConfiguration {

    @Bean
    public SalePort salePort(
            JpaSaleRepository saleRepository,
            JpaSaleDetailRepository saleDetailRepository,
            JpaProductRepository productRepository,
            JpaClientRepository clientRepository,
            JpaUserRepository userRepository
    ) {
        return new SaleServiceAdapter(
                saleRepository,
                saleDetailRepository,
                productRepository,
                clientRepository,
                userRepository
        );
    }

    @Bean
    public SaleService saleService(SalePort port) {
        return new SaleServiceImpl(port);
    }
}

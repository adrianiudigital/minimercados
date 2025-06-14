package co.edu.iudigital.pos.configuration;

import co.edu.iudigital.pos.adapter.ProviderServiceAdapter;
import co.edu.iudigital.pos.infrastructure.persistence.JpaProviderRepository;
import co.edu.iudigital.pos.port.ProviderPort;
import co.edu.iudigital.pos.service.ProviderService;
import co.edu.iudigital.pos.service.impl.ProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProviderConfiguration {

    @Bean
    public ProviderPort providerPort(JpaProviderRepository jpaProviderRepository) {
        return new ProviderServiceAdapter(jpaProviderRepository);
    }

    @Bean
    public ProviderService providerService(ProviderPort providerPort) {
        return new ProviderServiceImpl(providerPort);
    }
}

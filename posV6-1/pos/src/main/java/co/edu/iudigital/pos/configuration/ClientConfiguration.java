package co.edu.iudigital.pos.configuration;

import co.edu.iudigital.pos.adapter.ClientServiceAdapter;
import co.edu.iudigital.pos.infrastructure.persistence.JpaClientRepository;
import co.edu.iudigital.pos.port.ClientPort;
import co.edu.iudigital.pos.service.ClientService;
import co.edu.iudigital.pos.service.impl.ClientServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public ClientPort clientPort(JpaClientRepository repository) {
        return new ClientServiceAdapter(repository);
    }

    @Bean
    public ClientService clientService(ClientPort port) {
        return new ClientServiceImpl(port);
    }
}

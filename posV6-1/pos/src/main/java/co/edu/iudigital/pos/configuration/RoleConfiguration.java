package co.edu.iudigital.pos.configuration;

import co.edu.iudigital.pos.adapter.RoleServiceAdapter;
import co.edu.iudigital.pos.infrastructure.persistence.JpaRoleRepository;
import co.edu.iudigital.pos.port.RolePort;
import co.edu.iudigital.pos.service.RoleService;
import co.edu.iudigital.pos.service.impl.RoleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleConfiguration {

    @Bean
    public RolePort rolePort(JpaRoleRepository jpaRoleRepository) {
        return new RoleServiceAdapter(jpaRoleRepository);
    }

    @Bean
    public RoleService roleService(RolePort rolePort) {
        return new RoleServiceImpl(rolePort);
    }
}

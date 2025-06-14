package co.edu.iudigital.pos.configuration;

import co.edu.iudigital.pos.adapter.UserServiceAdapter;
import co.edu.iudigital.pos.infrastructure.persistence.JpaRoleRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaUserRepository;
import co.edu.iudigital.pos.port.UserPort;
import co.edu.iudigital.pos.service.UserService;
import co.edu.iudigital.pos.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    public UserPort userPort(JpaUserRepository userRepository, JpaRoleRepository roleRepository) {
        return new UserServiceAdapter(userRepository, roleRepository);
    }

    @Bean
    public UserService userService(UserPort userPort) {
        return new UserServiceImpl(userPort);
    }
}

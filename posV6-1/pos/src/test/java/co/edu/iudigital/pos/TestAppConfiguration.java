package co.edu.iudigital.pos;

import co.edu.iudigital.pos.configuration.ClientConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ClientConfiguration.class)
public class TestAppConfiguration {
}

package co.edu.iudigital.pos;

import co.edu.iudigital.pos.infrastructure.persistence.JpaClientRepository;
import co.edu.iudigital.pos.infrastructure.persistence.entity.ClientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        classes = PosApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                // Forzamos a Hibernate a crear y luego eliminar el esquema en H2
                "spring.jpa.hibernate.ddl-auto=create-drop",
                // Deshabilitamos cualquier data.sql automática
                "spring.sql.init.mode=never"
        }
)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@ActiveProfiles("test")
public class ClientControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JpaClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        // 1. Limpia la tabla
        clientRepository.deleteAll();

        // 2. Crea y guarda un ClientEntity directamente en H2
        ClientEntity c = new ClientEntity();
        c.setDocument("1234567890");
        c.setName("Cliente Prueba");
        c.setPhone("3011234567");
        c.setEmail("cliente@correo.com");
        // Si tu entidad no tiene campos de auditoría, omítelos;
        // si los requieres, añade createdAt/updatedAt antes en la entidad.
        clientRepository.save(c);
    }

    @Test
    void testGetAllClientsRealData() {
        String url = "http://localhost:" + port + "/clients";
        String json = restTemplate.getForObject(url, String.class);
        System.out.println("\n\n\n\n\n\n---------------------------------------------------");
        System.out.println("url: " + url);
        System.out.println("json: " + json);
        System.out.println("---------------------------------------------------\n\n\n\n\n\n");

        assertThat(json)
                .as("El endpoint /clients debe devolver al menos el Cliente Prueba")
                .contains("Cliente Prueba");
    }
}

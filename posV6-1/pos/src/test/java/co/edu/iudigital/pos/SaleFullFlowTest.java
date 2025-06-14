package co.edu.iudigital.pos;

import co.edu.iudigital.pos.adapter.SaleServiceAdapter;
import co.edu.iudigital.pos.domain.model.Sale;
import co.edu.iudigital.pos.domain.model.SaleDetail;
import co.edu.iudigital.pos.infrastructure.persistence.JpaClientRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaProductRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaRoleRepository;
import co.edu.iudigital.pos.infrastructure.persistence.JpaUserRepository;
import co.edu.iudigital.pos.infrastructure.persistence.entity.ClientEntity;
import co.edu.iudigital.pos.infrastructure.persistence.entity.ProductEntity;
import co.edu.iudigital.pos.infrastructure.persistence.entity.RoleEntity;
import co.edu.iudigital.pos.infrastructure.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        properties = {
                // Hibernate crea y destruye el esquema en H2
                "spring.jpa.hibernate.ddl-auto=create-drop",
                // Deshabilita la ejecución de data.sql
                "spring.sql.init.mode=never"
        }
)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class SaleFullFlowTest {

    @Autowired
    private JpaRoleRepository roleRepository;

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    private JpaClientRepository clientRepository;

    @Autowired
    private JpaProductRepository productRepository;

    @Autowired
    private SaleServiceAdapter saleServiceAdapter;

    @Test
    public void testFullSaleFlow() {
        // 1) Sembrar rol
        RoleEntity role = new RoleEntity();
        role.setName("TEST_ROLE");
        roleRepository.save(role);

        // 2) Sembrar usuario
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("secret");
        user.setRole(role);
        userRepository.save(user);

        // 3) Sembrar cliente
        ClientEntity client = new ClientEntity();
        client.setDocument("1234567890");
        client.setName("Cliente Prueba");
        client.setPhone("3011234567");
        client.setEmail("cliente@correo.com");
        clientRepository.save(client);

        // 4) Sembrar producto
        ProductEntity product = new ProductEntity();
        product.setName("Producto Sabrosón");
        product.setPrice(5000.0);
        product.setStock(10);
        productRepository.save(product);

        // 5) Construir la venta de dominio
        Sale sale = new Sale();
        sale.setClientId(client.getId());
        sale.setUserId(user.getId());

        SaleDetail detail = new SaleDetail();
        detail.setProductId(product.getId());
        detail.setQuantity(2);
        detail.setUnitPrice(5000.0);
        // subtotal y total se calculan internamente en Sale

        sale.setDetails(Collections.singletonList(detail));

        // 6) Ejecutar el flujo de venta
        Sale result = saleServiceAdapter.save(sale);

        // 7) Verificar resultados
        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull();
        assertThat(result.getTotal()).isEqualTo(10000.0);
    }
}

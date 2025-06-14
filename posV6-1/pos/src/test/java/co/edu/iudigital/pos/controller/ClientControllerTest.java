package co.edu.iudigital.pos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import co.edu.iudigital.pos.service.ClientService;
import co.edu.iudigital.pos.domain.model.Client;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    // @Test
    public void testGetAllClients() throws Exception {
        // Datos simulados
        Client cliente = new Client();
        cliente.setId(1L);
        cliente.setName("Cliente Prueba");
        cliente.setDocument("1234567890");
        cliente.setPhone("3011234567");
        cliente.setEmail("cliente@correo.com");

        when(clientService.getAll()).thenReturn(List.of(cliente));

        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Cliente Prueba"));
    }
}

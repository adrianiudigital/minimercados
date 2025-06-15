package co.edu.iudigital.pos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

// @WebMvcTest(ProviderController.class)
public class ProviderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // @MockBean private import co.edu.iudigital.pos.port.in.ProviderService providerService;

    @Test
    public void testGetProviders() throws Exception {
        /*
        when(providerService.getAllProviders()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/providers"))
                .andExpect(status().isOk());
        //*/
    }
}

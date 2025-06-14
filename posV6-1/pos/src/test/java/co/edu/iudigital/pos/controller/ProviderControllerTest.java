package co.edu.iudigital.pos.controller;

import co.edu.iudigital.pos.domain.model.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

package com.example.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@Import(TestSecurityConfig.class)
@ActiveProfiles("test")
class GatewaySecurityTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void securedEndpointWorks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/github/test")
                        .header("Authorization", "Bearer test-token"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

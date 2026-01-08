package com.example.codeauditengineclient;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@Import(TestSecurityConfig.class)
@ActiveProfiles("test")
class CodeAuditEngineClientApplicationTests {

    @MockBean
    ClientRegistrationRepository clientRegistrationRepository;

    @Test
    void contextLoads() {
    }

}

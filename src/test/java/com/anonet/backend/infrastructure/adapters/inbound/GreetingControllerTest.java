package com.anonet.backend.infrastructure.adapters.inbound;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest;

@WebFluxTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldReturnGreetingMessageWithStandardStructure() {
        webTestClient.get()
                .uri("/api/v1/greeting")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.type").isEqualTo("success")
                .jsonPath("$.messages[0]").isEqualTo("Petición procesada exitosamente")
                .jsonPath("$.data").isEqualTo("¡Hola Luis! Bienvenido a Anonet. El motor reactivo está listo.")
                .jsonPath("$.meta.version").isEqualTo("v1")
                .jsonPath("$.meta.durationMs").isNumber();
    }
}
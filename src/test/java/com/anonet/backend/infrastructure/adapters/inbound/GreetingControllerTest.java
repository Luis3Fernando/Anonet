package com.anonet.backend.infrastructure.adapters.inbound;

import com.anonet.backend.infrastructure.config.I18nConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest;
import org.junit.jupiter.api.BeforeEach;
import java.util.Locale;

@WebFluxTest(GreetingController.class)
@Import(I18nConfig.class)
class GreetingControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        Locale.setDefault(Locale.ENGLISH);
    }

    @Test
    void shouldReturnGreetingInSpanishWhenHeaderIsEs() {
        webTestClient.get()
                .uri("/api/v1/greeting")
                .header("Accept-Language", "es")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.type").isEqualTo("success")
                .jsonPath("$.messages[0]").isEqualTo("Petición procesada exitosamente.")
                .jsonPath("$.data").isEqualTo("¡Hola Luis! Bienvenido a Anonet. El motor reactivo está listo.");
    }

    @Test
    void shouldReturnGreetingInEnglishWhenHeaderIsEnOrMissing() {
        webTestClient.get()
                .uri("/api/v1/greeting")
                .header("Accept-Language", "en")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.type").isEqualTo("success")
                .jsonPath("$.messages[0]").isEqualTo("Request processed successfully.")
                .jsonPath("$.data").isEqualTo("Hello Luis! Welcome to Anonet. The reactive engine is ready.");
    }
}
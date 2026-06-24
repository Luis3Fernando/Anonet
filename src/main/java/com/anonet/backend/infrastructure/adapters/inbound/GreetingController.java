package com.anonet.backend.infrastructure.adapters.inbound;

import com.anonet.backend.infrastructure.adapters.inbound.dtos.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

    @GetMapping("/greeting")
    public Mono<ApiResponse<String>> getGreeting() {
        long startTime = System.currentTimeMillis();

        String mensajeGreeting = "¡Hola Luis! Bienvenido a Anonet. El motor reactivo está listo.";

        ApiResponse<String> response = ApiResponse.success(
                mensajeGreeting,
                List.of("Petición procesada exitosamente"),
                startTime
        );

        return Mono.just(response);
    }
}
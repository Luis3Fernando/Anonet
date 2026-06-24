package com.anonet.backend.infrastructure.adapters.inbound;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

    @GetMapping("/greeting")
    public Mono<String> getGreeting() {
        return Mono.just("¡Hola Luis! Bienvenido a Anonet. El motor reactivo está listo.");
    }
}
package com.anonet.backend.infrastructure.adapters.inbound;

import com.anonet.backend.infrastructure.adapters.inbound.dtos.ApiResponse;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

    private final MessageSource messageSource;

    public GreetingController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(value = "/greeting", produces = "application/json;charset=UTF-8")
    public Mono<ApiResponse<String>> getGreeting(Locale locale) {
        long startTime = System.currentTimeMillis();

        String welcomeMessage = messageSource.getMessage("greeting.welcome", null, locale);
        String successLog = messageSource.getMessage("greeting.success", null, locale);

        ApiResponse<String> response = ApiResponse.success(
                welcomeMessage,
                List.of(successLog),
                startTime
        );

        return Mono.just(response);
    }
}
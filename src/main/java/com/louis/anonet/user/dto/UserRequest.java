package com.louis.anonet.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest (
        @NotBlank
        @Size(max = 20)
        String alias
) {}

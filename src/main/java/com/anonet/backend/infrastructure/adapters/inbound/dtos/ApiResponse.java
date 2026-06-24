package com.anonet.backend.infrastructure.adapters.inbound.dtos;

import java.util.List;

public record ApiResponse<T>(
        String type,
        List<String> messages,
        T data,
        Meta meta
) {
    public static <T> ApiResponse<T> success(T data, List<String> messages, long startTime) {
        return new ApiResponse<>(
                "success",
                messages,
                data,
                new Meta(
                        null,
                        System.currentTimeMillis() - startTime,
                        "v1"
                )
        );
    }

    public static <T> ApiResponse<T> error(List<String> messages, long startTime) {
        return new ApiResponse<>(
                "error",
                messages,
                null,
                new Meta(
                        null,
                        System.currentTimeMillis() - startTime,
                        "v1"
                )
        );
    }

    public record Meta(
            Pagination pagination,
            long durationMs,
            String version
    ) {}

    public record Pagination(
            int page,
            int size,
            long totalElements,
            int totalPages
    ) {}
}
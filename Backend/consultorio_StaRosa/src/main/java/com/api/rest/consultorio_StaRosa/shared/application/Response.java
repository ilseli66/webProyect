package com.api.rest.consultorio_StaRosa.shared.application;

import java.util.List;

public record Response<T>(
    boolean succeeded,
    T data,
    String message,
    List<String> errors,
    ResponseType status
) {
    public static <T> Response<T> success(T data, String message) {
        return new Response<>(true, data, message, List.of(), ResponseType.SUCCESS);
    }

    public static <T> Response<T> created(T data, String message) {
        return new Response<>(true, data, message, List.of(), ResponseType.CREATED);
    }

    public static <T> Response<T> failure(String error, ResponseType status) {
        return new Response<>(false, null, null, List.of(error), status);
    }

    public static <T> Response<T> notFound(String message) {
        return new Response<>(false, null, null, List.of(message), ResponseType.NOT_FOUND);
    }
}

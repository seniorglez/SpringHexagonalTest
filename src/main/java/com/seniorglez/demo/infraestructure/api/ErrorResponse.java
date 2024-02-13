package com.seniorglez.demo.infraestructure.api;

public class ErrorResponse {

    private final String message;
    private final Integer code;

    public ErrorResponse(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}

package com.isaquesoares.financeapp.model.dto;

public class LoginResponseDTO {
    private String message;
    private String userId;

    public LoginResponseDTO(String message, String userId) {
        this.message = message;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public String getUserId() {
        return userId;
    }
}

package com.skilllink.backend.dto;

public class ResetPasswordMessage {
    private String email;
    private String token;

    // Constructor vacío necesario para serialización
    public ResetPasswordMessage() {}

    public ResetPasswordMessage(String email, String token) {
        this.email = email;
        this.token = token;
    }

    // Getters y setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}

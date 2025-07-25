package com.fitnessapp.fitnessapp.dto;

public class UserResponse {
    private String email;
    private String role;
    private String message;



    public UserResponse(String message) {
        this.message = message;
    }

    public UserResponse(String email, String role, String message) {
        this.email = email;
        this.role = role;
        this.message = message;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

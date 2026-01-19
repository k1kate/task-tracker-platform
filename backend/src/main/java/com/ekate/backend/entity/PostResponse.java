package com.ekate.backend.entity;
import lombok.Data;

@Data
public class PostResponse {
    private boolean success;
    private String  message;

    public PostResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}

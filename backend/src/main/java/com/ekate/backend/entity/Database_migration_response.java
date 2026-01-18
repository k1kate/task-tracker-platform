package com.ekate.backend.entity;
import lombok.Data;

@Data
public class Database_migration_response {
    private boolean success;
    private String  message;

    public Database_migration_response(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}

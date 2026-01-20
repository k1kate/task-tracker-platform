package com.ekate.backend.entity;
import lombok.Data;

@Data
public class DatabaseMigration {
    private String url;
    private String user;
    private String password;
}

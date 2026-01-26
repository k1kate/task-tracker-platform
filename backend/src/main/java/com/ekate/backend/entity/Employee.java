package com.ekate.backend.entity;

import lombok.Data;

@Data
public class Employee {
    private String uuid;
    private String name;
    private String secondName;
    private String patronymic;
    private String employeeSpringTimeCapacity;
    private String avatar;
    private String email;
    private String unitName;
    private String password;
    private boolean isAdmin;
}

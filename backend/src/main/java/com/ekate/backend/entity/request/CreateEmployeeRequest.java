package com.ekate.backend.entity.request;

import lombok.Data;

@Data
public class CreateEmployeeRequest {
    private String unitName;
    private String name;
    private String secondName;
    private String patronymic;
    private String email;
}

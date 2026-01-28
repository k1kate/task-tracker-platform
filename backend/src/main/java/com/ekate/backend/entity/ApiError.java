package com.ekate.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiError {
    private boolean error;
    private String message;

}

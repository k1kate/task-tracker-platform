package com.ekate.backend.error;

public class BadRequestException extends  Exception{
    public BadRequestException(String message){
        super(message);
    }
}

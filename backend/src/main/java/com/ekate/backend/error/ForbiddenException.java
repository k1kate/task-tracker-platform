package com.ekate.backend.error;

public class ForbiddenException extends Exception{
    public ForbiddenException(String message){
        super(message);
    }
}

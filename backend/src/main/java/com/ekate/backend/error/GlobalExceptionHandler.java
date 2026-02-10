package com.ekate.backend.error;

import com.ekate.backend.entity.ApiError;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.sql.SQLException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ApiError> handleSqlException(SQLException sqlEx){
        log.error(sqlEx.getMessage());

        ApiError error = setApiError("Ошибка запроса,попробуйте снова") ;

        if(sqlEx.getMessage().contains("already exists")) error = setApiError("Запись с похожими данными уже существует");

        if(sqlEx.getMessage().contains("null value in column")) error = setApiError("Поле не должно быть пустым");

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ApiError>handleForbiddenException(){
        ApiError error = setApiError("Вы не являетесь админом");
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException brEx){
        ApiError error = setApiError(brEx.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ApiError> handleExpiredJwtException(){
        ApiError error = setApiError("Срок жизни токена исотек");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(error);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleJSONNotReadableException(){
        ApiError error =  setApiError("Не верный тип данных");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }


    public ApiError  setApiError(String message){
        ApiError error = new ApiError();
        error.setError(true);
        error.setMessage(message);
        return  error;
    }
}

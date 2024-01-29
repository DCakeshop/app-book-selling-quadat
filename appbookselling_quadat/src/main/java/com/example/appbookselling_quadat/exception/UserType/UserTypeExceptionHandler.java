package com.example.appbookselling_quadat.exception.UserType;

import com.example.appbookselling_quadat.exception.ErrorResponse;
import com.example.appbookselling_quadat.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

public class UserTypeExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlerNotFoundException(NotFoundException exception, WebRequest request){
        return new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}

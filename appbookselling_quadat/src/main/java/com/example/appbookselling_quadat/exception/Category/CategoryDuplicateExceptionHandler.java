package com.example.appbookselling_quadat.exception.Category;

import com.example.appbookselling_quadat.exception.DuplicateException;
import com.example.appbookselling_quadat.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

public class CategoryDuplicateExceptionHandler {
    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handlerDuplicateException(DuplicateException exception, WebRequest request){
        return new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }
}

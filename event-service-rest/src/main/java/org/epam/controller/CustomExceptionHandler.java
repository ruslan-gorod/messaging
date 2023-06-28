package org.epam.controller;

import org.epam.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            IllegalArgumentException.class,
            ServletRequestBindingException.class,
            HttpMessageNotReadableException.class})
    public ErrorDto badRequest(Exception ex) {
        return ErrorDto.builder()
                .code("BAD_REQUEST")
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RuntimeException.class)
    public ErrorDto notFound(Exception ex) {
        return ErrorDto.builder()
                .code("NOT_FOUND")
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorDto internalServerError(Exception ex) {
        return ErrorDto.builder()
                .code("INTERNAL_SERVER_ERROR")
                .message(ex.getMessage())
                .build();
    }

}

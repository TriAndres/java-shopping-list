package ru.practicum.shopping.controller;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.practicum.shopping.exception.DoesNotExistException;
import ru.practicum.shopping.model.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ValidationException.class, MethodArgumentNotValidException.class})
    public ErrorResponse handleValidationException(final ValidationException e) {
        log.error(e.getMessage());

        return new ErrorResponse("Ошибка валидации");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ErrorResponse handleFilmNotFond(final DoesNotExistException e) {
        log.error(e.getMessage());
        return new ErrorResponse("Не найдено");
    }
}
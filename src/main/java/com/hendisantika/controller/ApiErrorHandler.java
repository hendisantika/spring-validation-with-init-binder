package com.hendisantika.controller;

import com.hendisantika.dto.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-validation-with-init-binder
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 06/04/22
 * Time: 16.49
 */
@ControllerAdvice
public class ApiErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        ApiError apiError = new ApiError();
        apiError.setCount(ex.getBindingResult().getErrorCount());
        apiError.setStatus(HttpStatus.BAD_REQUEST);
        apiError.setError("Validation failed");
        List<String> errors = new ArrayList<>();
        BindingResult bindingResult = ex.getBindingResult();
        bindingResult.getAllErrors().forEach(error -> errors.add(error.getCode()));
        apiError.setErrors(errors);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }
}

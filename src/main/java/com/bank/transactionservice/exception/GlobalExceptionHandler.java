package com.bank.transactionservice.exception;

import com.bank.transactionservice.model.dto.response.OperationResponse;
import com.bank.transactionservice.util.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {WebExchangeBindException.class})
    public Mono<ResponseEntity<Map<String, Object>>> handleMethodArgumentNotValidException(WebExchangeBindException e) {
        Map<String, String> errors = new LinkedHashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
            log.error("Field {}: {}", fieldName, errorMessage);
        });
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.getReasonPhrase());
        response.put("code", HttpStatus.BAD_REQUEST.value());
        response.put("message", Message.ARGUMENT_NOT_VALID.getText());
        response.put("timestamp", LocalDateTime.now());
        response.put("errors", errors);
        return Mono.just(new ResponseEntity<>(response, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(Exception.class)
    public Mono<OperationResponse> handleException(Exception e) {
        log.error("Exception caught: {}", e.getMessage());
        return Mono.just(new OperationResponse(Message.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR));
    }
}

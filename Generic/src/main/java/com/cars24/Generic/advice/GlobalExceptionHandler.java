package com.cars24.Generic.advice;

import com.cars24.Generic.data.responses.ApiResponse;
import com.cars24.Generic.exceptions.PromptNotFoundException;
import com.cars24.Generic.exceptions.ResponseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PromptNotFoundException.class)
    public ResponseEntity<ApiResponse> handlePromptNotFoundException(PromptNotFoundException ex) {
        ApiResponse apiResponse = new ApiResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "GENERIC_CHATBOT-" + HttpStatus.BAD_REQUEST.value(),
                false,
                null
        );
        return ResponseEntity.badRequest().body(apiResponse);
    }

    // For ResponseNotFoundException
    @ExceptionHandler(ResponseNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResponseNotFoundException(ResponseNotFoundException ex) {
        ApiResponse apiResponse = new ApiResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                "GENERIC_CHATBOT-" + HttpStatus.BAD_REQUEST.value(),
                false,
                null
        );
        return ResponseEntity.badRequest().body(apiResponse);
    }

    // General exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGlobalException(Exception ex) {
        ApiResponse apiResponse = new ApiResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred.",
                "GENERIC_CHATBOT-" + HttpStatus.INTERNAL_SERVER_ERROR.value(),
                false,
                null
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }
}


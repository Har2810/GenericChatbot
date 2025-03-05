package com.cars24.Generic.advice;

import com.cars24.Generic.exceptions.PromptNotFoundException;
import com.cars24.Generic.exceptions.ResponseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Custom Exception Handler for Not Found (like Prompt Not Found)
    @ExceptionHandler(PromptNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePromptNotFoundException(PromptNotFoundException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, Object>> handleResponseNotFoundException(ResponseNotFoundException ex, WebRequest request){
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
    // Catch-All for any other unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGlobalException(Exception ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred.");
    }


    // Helper method to build consistent error responses
    private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String message) {
        Map<String, Object> errorBody = new HashMap<>();
        errorBody.put("statusCode", status.value());
        errorBody.put("message", message);
        errorBody.put("errorCode", "APPUSR-" + status.value());
        errorBody.put("success", false);
        errorBody.put("data", new HashMap<>());

        return ResponseEntity.status(status).body(errorBody);
    }
}


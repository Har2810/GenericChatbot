package com.cars24.Generic.data.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private int statusCode;
    private String message;
    private String service;
    private boolean success;
    private Object data;
}
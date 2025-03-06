package com.cars24.Generic.data.responses;

public class ApiResponse<T> {
    private boolean success;
    private int statusCode;
    private String message;
    private String errorCode;  // Optional - can be null for success
    private T data;

    public ApiResponse(boolean success, int statusCode, String message, String errorCode, T data) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.errorCode = errorCode;
        this.data = data;
    }

    // Static helper methods for cleaner service code
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>(true, 200, message, null, data);
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, 200, "Request successful", null, data);
    }

    // Getters
    public boolean isSuccess() { return success; }
    public int getStatusCode() { return statusCode; }
    public String getMessage() { return message; }
    public String getErrorCode() { return errorCode; }
    public T getData() { return data; }
}

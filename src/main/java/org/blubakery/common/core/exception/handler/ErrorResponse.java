package org.blubakery.common.core.exception.handler;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    private String code;
    private String message;
    private LocalDateTime timestamp;
    private String path;
    private Map<String, String> validationErrors;
    private Map<String, Object> details;

    public ErrorResponse() {
    }

    public ErrorResponse(String code, String message, LocalDateTime timestamp, String path) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
    }

    public ErrorResponse(String code, String message, LocalDateTime timestamp, String path, Map<String, String> validationErrors) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
        this.validationErrors = validationErrors;
    }

    public ErrorResponse(String code, String message, LocalDateTime timestamp, String path, Map<String, String> validationErrors, Map<String, Object> details) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
        this.validationErrors = validationErrors;
        this.details = details;
    }

    // Getters and Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public Map<String, String> getValidationErrors() { return validationErrors; }
    public void setValidationErrors(Map<String, String> validationErrors) { this.validationErrors = validationErrors; }

    public Map<String, Object> getDetails() { return details; }
    public void setDetails(Map<String, Object> details) { this.details = details; }
}

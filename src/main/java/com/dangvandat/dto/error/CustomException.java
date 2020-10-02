package com.dangvandat.dto.error;

import java.util.Map;

public class CustomException extends RuntimeException {

    private String error;

    public CustomException(String errorMessage) {
        super(errorMessage);
        this.error = errorMessage;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

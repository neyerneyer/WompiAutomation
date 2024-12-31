package com.wompi.exceptions;

public class GeneralError extends AssertionError{
    public GeneralError(String message, Throwable cause) {
        super(message,cause);
    }
}

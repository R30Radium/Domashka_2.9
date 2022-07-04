package com.example.domashka_2_7.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeIncorrectDataException extends RuntimeException{

    public EmployeeIncorrectDataException(String message) {
        super(message);
    }

    public EmployeeIncorrectDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeIncorrectDataException(Throwable cause) {
        super(cause);
    }

    public EmployeeIncorrectDataException(String message,
                                          Throwable cause,
                                          boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public EmployeeIncorrectDataException(){

    }
}

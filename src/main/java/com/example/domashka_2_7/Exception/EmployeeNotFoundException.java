package com.example.domashka_2_7.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class  EmployeeNotFoundException extends RuntimeException{
}

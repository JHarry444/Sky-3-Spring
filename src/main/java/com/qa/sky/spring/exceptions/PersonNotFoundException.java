package com.qa.sky.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "no person found with that data")
public class PersonNotFoundException extends RuntimeException{
}

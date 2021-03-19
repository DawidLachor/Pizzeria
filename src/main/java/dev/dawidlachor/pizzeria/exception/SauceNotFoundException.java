package dev.dawidlachor.pizzeria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Don't found sauce")
public class SauceNotFoundException extends RuntimeException{
}

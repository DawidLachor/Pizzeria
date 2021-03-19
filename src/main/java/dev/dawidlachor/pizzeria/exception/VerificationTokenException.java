package dev.dawidlachor.pizzeria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.PersistenceContext;

@ResponseStatus(reason = "Nie znaleziono takiegop tokena",value = HttpStatus.NOT_FOUND)
public class VerificationTokenException extends RuntimeException{
}

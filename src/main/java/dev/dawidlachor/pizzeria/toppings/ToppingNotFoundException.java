package dev.dawidlachor.pizzeria.toppings;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Don't found topping")
public class ToppingNotFoundException extends RuntimeException{
}

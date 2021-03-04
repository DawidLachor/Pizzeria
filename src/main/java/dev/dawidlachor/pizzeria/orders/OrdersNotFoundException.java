package dev.dawidlachor.pizzeria.orders;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Don't found order")
public class OrdersNotFoundException extends RuntimeException{
}

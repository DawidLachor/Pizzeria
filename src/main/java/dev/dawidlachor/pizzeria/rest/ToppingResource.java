package dev.dawidlachor.pizzeria.rest;

import dev.dawidlachor.pizzeria.dto.ToppingDto;
import dev.dawidlachor.pizzeria.service.ToppingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizza/topping")
public class ToppingResource {
    private final ToppingService toppingService;

    public ToppingResource(ToppingService toppingService) {
        this.toppingService = toppingService;
    }

    @GetMapping
    public List<ToppingDto> findAll(){
        return toppingService.findAll();
    }
}

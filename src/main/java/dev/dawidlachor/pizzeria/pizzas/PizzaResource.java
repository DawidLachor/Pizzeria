package dev.dawidlachor.pizzeria.pizzas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaResource {

    private PizzaService pizzaService;

    public PizzaResource(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<MenuDto> findAll(){
        return pizzaService.findAll();
    }
}

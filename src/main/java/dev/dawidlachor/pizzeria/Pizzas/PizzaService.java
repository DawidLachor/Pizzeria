package dev.dawidlachor.pizzeria.Pizzas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    private PizzaRepository pizzaRepository;
    private MappingMenuPizza mappingMenuPizza;

    public PizzaService(PizzaRepository pizzaRepository, MappingMenuPizza mappingMenuPizza) {
        this.pizzaRepository = pizzaRepository;
        this.mappingMenuPizza = mappingMenuPizza;
    }

    public List<MenuDto> findAll() {
       return pizzaRepository.findAll()
                .stream()
                .map(mappingMenuPizza::toDto)
                .collect(Collectors.toList());

    }
}

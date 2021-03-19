package dev.dawidlachor.pizzeria.service;

import dev.dawidlachor.pizzeria.dto.MenuDto;
import dev.dawidlachor.pizzeria.mapping.MenuPizzaMapping;
import dev.dawidlachor.pizzeria.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PizzaService {

    private PizzaRepository pizzaRepository;
    private MenuPizzaMapping menuPizzaMapping;

    public PizzaService(PizzaRepository pizzaRepository, MenuPizzaMapping menuPizzaMapping) {
        this.pizzaRepository = pizzaRepository;
        this.menuPizzaMapping = menuPizzaMapping;
    }

    public List<MenuDto> findAll() {
       return pizzaRepository.findAll()
                .stream()
                .map(menuPizzaMapping::toDto)
                .collect(Collectors.toList());

    }
}

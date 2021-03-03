package dev.dawidlachor.pizzeria.toppings;

import dev.dawidlachor.pizzeria.Pizzas.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConnectionFromPizzaRepository extends JpaRepository<ConnectionFromPizza, Long> {

}

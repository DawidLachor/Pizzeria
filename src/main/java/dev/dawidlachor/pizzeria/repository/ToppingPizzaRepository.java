package dev.dawidlachor.pizzeria.repository;

import dev.dawidlachor.pizzeria.model.Pizza;
import dev.dawidlachor.pizzeria.model.ToppingPizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToppingPizzaRepository extends JpaRepository<ToppingPizza, Long> {
    List<ToppingPizza> findAllByPizza(Pizza pizza);
}

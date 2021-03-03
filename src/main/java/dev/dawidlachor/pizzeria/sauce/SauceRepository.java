package dev.dawidlachor.pizzeria.sauce;

import dev.dawidlachor.pizzeria.Pizzas.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SauceRepository extends JpaRepository<Sauce, Long> {

    List<Sauce> findAllByPizzas(Pizza pizza);
}

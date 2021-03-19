package dev.dawidlachor.pizzeria.repository;

import dev.dawidlachor.pizzeria.model.Pizza;
import dev.dawidlachor.pizzeria.model.Sauce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SauceRepository extends JpaRepository<Sauce, Long> {

    List<Sauce> findAllByPizzas(Pizza pizza);
}

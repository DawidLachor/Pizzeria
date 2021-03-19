package dev.dawidlachor.pizzeria.repository;

import dev.dawidlachor.pizzeria.model.Orders;
import dev.dawidlachor.pizzeria.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByOrders(Orders orders);
}

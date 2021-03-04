package dev.dawidlachor.pizzeria.Pizzas;

import dev.dawidlachor.pizzeria.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
    List<Pizza> findAllByOrders(Orders orders);
}

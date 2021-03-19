package dev.dawidlachor.pizzeria.repository;

import dev.dawidlachor.pizzeria.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}

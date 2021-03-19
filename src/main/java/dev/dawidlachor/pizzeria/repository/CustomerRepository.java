package dev.dawidlachor.pizzeria.repository;

import dev.dawidlachor.pizzeria.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

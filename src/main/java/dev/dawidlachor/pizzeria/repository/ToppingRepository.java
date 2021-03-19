package dev.dawidlachor.pizzeria.repository;

import dev.dawidlachor.pizzeria.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToppingRepository extends JpaRepository<Topping, Long> {

}

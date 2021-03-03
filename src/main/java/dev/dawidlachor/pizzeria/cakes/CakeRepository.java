package dev.dawidlachor.pizzeria.cakes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CakeRepository extends JpaRepository<Cake, Long> {
    Optional<Cake> findByName(String name);
}

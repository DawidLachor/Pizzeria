package dev.dawidlachor.pizzeria.repository;

import dev.dawidlachor.pizzeria.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

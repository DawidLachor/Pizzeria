package dev.dawidlachor.pizzeria.cakes;

import dev.dawidlachor.pizzeria.Pizzas.Pizza;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Cake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @OneToMany(mappedBy = "cake")
    private List<Pizza> pizzas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Pizza> getPizza() {
        return pizzas;
    }

    public void setPizza(List<Pizza> pizza) {
        this.pizzas = pizza;
    }
}

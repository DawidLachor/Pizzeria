package dev.dawidlachor.pizzeria.sauce;

import dev.dawidlachor.pizzeria.pizzas.Pizza;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Sauce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @ManyToMany
    @JoinTable(
            name = "pizza_sauce",
            joinColumns = @JoinColumn(name = "sauce_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id")
    )
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
}

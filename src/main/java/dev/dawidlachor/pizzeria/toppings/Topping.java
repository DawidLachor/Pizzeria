package dev.dawidlachor.pizzeria.toppings;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @OneToMany(mappedBy = "topping")
    private List<ToppingPizza> toppingPizzas;

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

    public List<ToppingPizza> getConnectionFromPizzas() {
        return toppingPizzas;
    }

    public void setConnectionFromPizzas(List<ToppingPizza> toppingPizzas) {
        this.toppingPizzas = toppingPizzas;
    }
}

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
    private List<ConnectionFromPizza> connectionFromPizzas;

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

    public List<ConnectionFromPizza> getConnectionFromPizzas() {
        return connectionFromPizzas;
    }

    public void setConnectionFromPizzas(List<ConnectionFromPizza> connectionFromPizzas) {
        this.connectionFromPizzas = connectionFromPizzas;
    }
}

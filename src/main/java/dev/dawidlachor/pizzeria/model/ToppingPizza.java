package dev.dawidlachor.pizzeria.model;

import javax.persistence.*;

@Entity
public class ToppingPizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Pizza pizza;
    @ManyToOne
    private Topping topping;
    private Boolean dual;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Boolean getDual() {
        return dual;
    }

    public void setDual(Boolean dual) {
        this.dual = dual;
    }
}

package dev.dawidlachor.pizzeria.orders;

import dev.dawidlachor.pizzeria.Pizzas.Pizza;
import dev.dawidlachor.pizzeria.customers.Customer;
import dev.dawidlachor.pizzeria.employers.Waiter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "pizza_order",
            inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"),
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id")
    )
    private List<Pizza> pizzas;
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
    @ManyToOne(targetEntity = Waiter.class)
    private Waiter waiter;
    private LocalDateTime date;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

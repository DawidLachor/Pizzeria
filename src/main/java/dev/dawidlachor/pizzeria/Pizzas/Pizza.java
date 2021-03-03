package dev.dawidlachor.pizzeria.Pizzas;

import dev.dawidlachor.pizzeria.cakes.Cake;
import dev.dawidlachor.pizzeria.orders.Orders;
import dev.dawidlachor.pizzeria.sauce.Sauce;
import dev.dawidlachor.pizzeria.sizes.Size;
import dev.dawidlachor.pizzeria.toppings.ConnectionFromPizza;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private String description;
    private Boolean standard;
    @ManyToMany
    @JoinTable(
            name = "pizza_sauce",
            joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sauce_id", referencedColumnName = "id")
    )
    private List<Sauce> sauces;
    @OneToMany(mappedBy = "pizza")
    private List<ConnectionFromPizza> connectionFromPizzas;
    @ManyToOne
    private Size size;
    @ManyToOne
    private Cake cake;
    @ManyToOne
    private Orders orders;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStandard() {
        return standard;
    }

    public void setStandard(Boolean standard) {
        this.standard = standard;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(List<Sauce> sauces) {
        this.sauces = sauces;
    }

    public List<ConnectionFromPizza> getConnectionFromPizzas() {
        return connectionFromPizzas;
    }

    public void setConnectionFromPizzas(List<ConnectionFromPizza> connectionFromPizzas) {
        this.connectionFromPizzas = connectionFromPizzas;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(id, pizza.id) && Objects.equals(name, pizza.name) && Objects.equals(description, pizza.description) && Objects.equals(standard, pizza.standard) && Objects.equals(sauces, pizza.sauces) && Objects.equals(connectionFromPizzas, pizza.connectionFromPizzas) && Objects.equals(size, pizza.size) && Objects.equals(cake, pizza.cake) && Objects.equals(orders, pizza.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, standard, sauces, connectionFromPizzas, size, cake, orders);
    }
}

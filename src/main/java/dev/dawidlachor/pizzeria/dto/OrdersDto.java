package dev.dawidlachor.pizzeria.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrdersDto {
    private List<PizzaDto> Pizzas;
    private LocalDateTime dateOrder;
    private BigDecimal price;

    public List<PizzaDto> getPizzas() {
        return Pizzas;
    }

    public void setPizzas(List<PizzaDto> pizzas) {
        Pizzas = pizzas;
    }

    public LocalDateTime getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDateTime dateOrder) {
        this.dateOrder = dateOrder;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

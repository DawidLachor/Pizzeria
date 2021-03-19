package dev.dawidlachor.pizzeria.dto;

import java.util.List;

public class MenuDto {
    private Long id;
    private String name;
    private String description;
    private String cakes;
    private List<String> sauces;
    private List<String> topping;

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

    public String getCakes() {
        return cakes;
    }

    public void setCakes(String cakes) {
        this.cakes = cakes;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public void setSauces(List<String> sauces) {
        this.sauces = sauces;
    }

    public List<String> getTopping() {
        return topping;
    }

    public void setTopping(List<String> topping) {
        this.topping = topping;
    }
}

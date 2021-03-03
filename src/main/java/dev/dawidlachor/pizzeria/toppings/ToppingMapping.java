package dev.dawidlachor.pizzeria.toppings;

public class ToppingMapping {

    public static ToppingDto toDto(Topping topping){
        ToppingDto toppingDto = new ToppingDto();
        toppingDto.setName(topping.getName());
        toppingDto.setPrice(topping.getPrice());
        return toppingDto;
    }
}

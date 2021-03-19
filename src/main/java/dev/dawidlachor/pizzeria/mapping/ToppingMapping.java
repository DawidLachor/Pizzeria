package dev.dawidlachor.pizzeria.mapping;

import dev.dawidlachor.pizzeria.dto.ToppingDto;
import dev.dawidlachor.pizzeria.model.Topping;

public class ToppingMapping {

    public static ToppingDto toDto(Topping topping){
        ToppingDto toppingDto = new ToppingDto();
        toppingDto.setName(topping.getName());
        toppingDto.setPrice(topping.getPrice());
        return toppingDto;
    }
}

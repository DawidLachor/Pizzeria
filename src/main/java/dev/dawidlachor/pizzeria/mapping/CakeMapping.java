package dev.dawidlachor.pizzeria.mapping;

import dev.dawidlachor.pizzeria.model.Cake;
import dev.dawidlachor.pizzeria.dto.CakeDto;

public class CakeMapping {

    public static CakeDto toDto(Cake cake){
        CakeDto cakeDto = new CakeDto();
        cakeDto.setName(cake.getName());
        cakeDto.setPrice(cake.getPrice());
        return cakeDto;
    }
}

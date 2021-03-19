package dev.dawidlachor.pizzeria.mapping;

import dev.dawidlachor.pizzeria.dto.SauceDto;
import dev.dawidlachor.pizzeria.model.Sauce;

public class SauceMapping {

    public static SauceDto toDto(Sauce sauce){
        SauceDto sauceDto = new SauceDto();
        sauceDto.setName(sauce.getName());
        sauceDto.setPrice(sauce.getPrice());
        return sauceDto;
    }
}

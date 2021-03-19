package dev.dawidlachor.pizzeria.mapping;


import dev.dawidlachor.pizzeria.dto.SizeDto;
import dev.dawidlachor.pizzeria.model.Size;

public class SizeMapping {
    public static SizeDto toDto(Size size){
        SizeDto sizeDto = new SizeDto();
        sizeDto.setName(size.getName());
        return sizeDto;
    }
}

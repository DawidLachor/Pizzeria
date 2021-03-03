package dev.dawidlachor.pizzeria.sizes;


public class SizeMapping {
    public static SizeDto toDto(Size size){
        SizeDto sizeDto = new SizeDto();
        sizeDto.setName(size.getName());
        return sizeDto;
    }
}

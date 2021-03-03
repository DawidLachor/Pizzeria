package dev.dawidlachor.pizzeria.cakes;

public class MappingCake {

    public static CakeDto toDto(Cake cake){
        CakeDto cakeDto = new CakeDto();
        cakeDto.setName(cake.getName());
        cakeDto.setPrice(cake.getPrice());
        return cakeDto;
    }
}

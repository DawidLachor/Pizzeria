package dev.dawidlachor.pizzeria.sauce;

public class SauceMapping {

    public static SauceDto toDto(Sauce sauce){
        SauceDto sauceDto = new SauceDto();
        sauceDto.setName(sauce.getName());
        sauceDto.setPrice(sauce.getPrice());
        return sauceDto;
    }
}

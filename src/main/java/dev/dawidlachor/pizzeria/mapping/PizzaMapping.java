package dev.dawidlachor.pizzeria.mapping;

import dev.dawidlachor.pizzeria.dto.PizzaDto;
import dev.dawidlachor.pizzeria.model.Pizza;
import dev.dawidlachor.pizzeria.model.Sauce;
import dev.dawidlachor.pizzeria.repository.SauceRepository;
import dev.dawidlachor.pizzeria.model.ToppingPizza;
import dev.dawidlachor.pizzeria.repository.ToppingPizzaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PizzaMapping {

    private final SauceRepository sauceRepository;
    private final ToppingPizzaRepository connection;

    public PizzaMapping(SauceRepository sauceRepository, ToppingPizzaRepository connection) {
        this.sauceRepository = sauceRepository;
        this.connection = connection;
    }

    public PizzaDto toDto(Pizza pizza){
        PizzaDto pizzaDto = new PizzaDto();
        pizzaDto.setName(pizza.getName());
        pizzaDto.setPrice(sumPrice(pizza));
        return pizzaDto;
    }

    private BigDecimal sumPrice(Pizza pizza){
        return sumSaucePrice(pizza).add(sumToppingPrice(pizza));
    }

    private BigDecimal sumToppingPrice(Pizza pizza) {
        BigDecimal sumPrice = BigDecimal.ZERO;
        List<ToppingPizza> allByPizza = connection.findAllByPizza(pizza);
        for (ToppingPizza connection: allByPizza){
            sumPrice = sumPrice.add(connection.getTopping().getPrice());
        }
        return sumPrice;
    }

    private BigDecimal sumSaucePrice(Pizza pizza) {
        BigDecimal sumPrice = BigDecimal.ZERO;
        List<Sauce> allByPizzas = sauceRepository.findAllByPizzas(pizza);
        for (Sauce sauce: allByPizzas) {
            sumPrice = sumPrice.add(sauce.getPrice());
        }
        return sumPrice;
    }


}

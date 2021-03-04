package dev.dawidlachor.pizzeria.Pizzas;

import dev.dawidlachor.pizzeria.sauce.Sauce;
import dev.dawidlachor.pizzeria.sauce.SauceRepository;
import dev.dawidlachor.pizzeria.toppings.ToppingPizza;
import dev.dawidlachor.pizzeria.toppings.ToppingPizzaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MappingPizza {

    private final SauceRepository sauceRepository;
    private final ToppingPizzaRepository connection;

    public MappingPizza(SauceRepository sauceRepository, ToppingPizzaRepository connection) {
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

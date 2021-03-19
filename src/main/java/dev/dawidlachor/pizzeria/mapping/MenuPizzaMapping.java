package dev.dawidlachor.pizzeria.mapping;

import dev.dawidlachor.pizzeria.dto.MenuDto;
import dev.dawidlachor.pizzeria.exception.ToppingNotFoundException;
import dev.dawidlachor.pizzeria.model.Pizza;
import dev.dawidlachor.pizzeria.model.ToppingPizza;
import dev.dawidlachor.pizzeria.repository.ToppingPizzaRepository;
import dev.dawidlachor.pizzeria.repository.ToppingRepository;
import dev.dawidlachor.pizzeria.model.Sauce;
import dev.dawidlachor.pizzeria.exception.SauceNotFoundException;
import dev.dawidlachor.pizzeria.repository.SauceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuPizzaMapping {

    private final SauceRepository sauceRepository;
    private final ToppingPizzaRepository connection;
    private final ToppingRepository toppingRepository;

    public MenuPizzaMapping(SauceRepository sauceRepository, ToppingPizzaRepository connection, ToppingRepository toppingRepository) {
        this.sauceRepository = sauceRepository;
        this.connection = connection;
        this.toppingRepository = toppingRepository;
    }

    public MenuDto toDto(Pizza pizza){
        MenuDto menuDto = new MenuDto();
        menuDto.setId(pizza.getId());
        menuDto.setName(pizza.getName());
        menuDto.setDescription(pizza.getDescription());
        menuDto.setCakes(pizza.getCake().getName());

        List<String> toppingsName = findToppings(pizza);

        menuDto.setTopping(toppingsName);

        List<String> saucesName = findSauces(pizza);

        menuDto.setSauces(saucesName);

        return menuDto;
    }

    private List<String> findToppings(Pizza pizza){
        List<ToppingPizza> toppingPizzas = connection.findAll()
                .stream()
                .filter(connectionFromPizza -> connectionFromPizza.getPizza().equals(pizza))
                .collect(Collectors.toList());
        if (toppingPizzas.size() == 0)
            throw new ToppingNotFoundException();
        List<String> toppingsName = new ArrayList<>();
        for (ToppingPizza toppingPizza : toppingPizzas) {
            toppingsName.add(toppingPizza.getTopping().getName());
        }
        return toppingsName;
    }

    private List<String> findSauces(Pizza pizza){
        List<Sauce> sauces = sauceRepository.findAllByPizzas(pizza);
        List<String> saucesName = new ArrayList<>();
        if (sauces.size() == 0){
            throw new SauceNotFoundException();
        }
        for (Sauce sauce: sauces) {
            saucesName.add(sauce.getName());
        }
        return saucesName;
    }
}

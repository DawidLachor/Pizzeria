package dev.dawidlachor.pizzeria.Pizzas;

import dev.dawidlachor.pizzeria.sauce.Sauce;
import dev.dawidlachor.pizzeria.sauce.SauceNotFoundException;
import dev.dawidlachor.pizzeria.sauce.SauceRepository;
import dev.dawidlachor.pizzeria.toppings.*;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MappingMenuPizza {

    private SauceRepository sauceRepository;
    private ConnectionFromPizzaRepository connection;
    private ToppingRepository toppingRepository;

    public MappingMenuPizza(SauceRepository sauceRepository, ConnectionFromPizzaRepository connection, ToppingRepository toppingRepository) {
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
        List<ConnectionFromPizza> connectionFromPizzas = connection.findAll()
                .stream()
                .filter(connectionFromPizza -> connectionFromPizza.getPizza().equals(pizza))
                .collect(Collectors.toList());
        if (connectionFromPizzas.size() == 0)
            throw new ToppingNotFoundException();
        List<String> toppingsName = new ArrayList<>();
        for (ConnectionFromPizza connectionFromPizza: connectionFromPizzas) {
            toppingsName.add(connectionFromPizza.getTopping().getName());
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

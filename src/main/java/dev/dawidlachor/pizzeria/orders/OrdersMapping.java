package dev.dawidlachor.pizzeria.orders;

import dev.dawidlachor.pizzeria.Pizzas.MappingPizza;
import dev.dawidlachor.pizzeria.Pizzas.Pizza;
import dev.dawidlachor.pizzeria.Pizzas.PizzaDto;
import dev.dawidlachor.pizzeria.Pizzas.PizzaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersMapping {

    private final PizzaRepository pizzaRepository;
    private final MappingPizza mappingPizza;

    public OrdersMapping(PizzaRepository pizzaRepository, MappingPizza mappingPizza) {
        this.pizzaRepository = pizzaRepository;
        this.mappingPizza = mappingPizza;
    }

    public OrdersDto toDto(Orders orders){
        OrdersDto ordersDto = new OrdersDto();
        List<PizzaDto> pizzas = findPizza(orders);
        ordersDto.setPizzas(pizzas);
        ordersDto.setPrice(sumPricePizza(pizzas));
        ordersDto.setDateOrder(LocalDateTime.now());
        return ordersDto;
    }

    private List<PizzaDto> findPizza(Orders orders){
         return pizzaRepository.findAllByOrders(orders)
                 .stream()
                 .map(mappingPizza::toDto)
                 .collect(Collectors.toList());
    }

    private BigDecimal sumPricePizza(List<PizzaDto> pizzaDtos){
        BigDecimal sum = BigDecimal.ZERO;
        for (PizzaDto pizzaDto: pizzaDtos) {
            sum = sum.add(pizzaDto.getPrice());
        }
        return sum;
    }
}

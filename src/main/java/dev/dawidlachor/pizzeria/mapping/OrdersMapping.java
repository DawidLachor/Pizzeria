package dev.dawidlachor.pizzeria.mapping;

import dev.dawidlachor.pizzeria.dto.OrdersDto;
import dev.dawidlachor.pizzeria.dto.PizzaDto;
import dev.dawidlachor.pizzeria.model.Orders;
import dev.dawidlachor.pizzeria.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersMapping {

    private final PizzaRepository pizzaRepository;
    private final PizzaMapping pizzaMapping;

    public OrdersMapping(PizzaRepository pizzaRepository, PizzaMapping pizzaMapping) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapping = pizzaMapping;
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
                 .map(pizzaMapping::toDto)
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

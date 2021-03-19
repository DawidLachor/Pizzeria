package dev.dawidlachor.pizzeria.rest;

import dev.dawidlachor.pizzeria.dto.OrdersDto;
import dev.dawidlachor.pizzeria.service.OrdersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pizza/orders")
public class OrdersResource {

    private final OrdersService ordersService;

    public OrdersResource(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping()
    public OrdersDto findById(@RequestParam Long id){
        return ordersService.findById(id);
    }

}

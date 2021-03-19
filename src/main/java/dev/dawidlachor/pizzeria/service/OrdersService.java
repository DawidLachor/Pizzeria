package dev.dawidlachor.pizzeria.service;

import dev.dawidlachor.pizzeria.dto.OrdersDto;
import dev.dawidlachor.pizzeria.model.Orders;
import dev.dawidlachor.pizzeria.mapping.OrdersMapping;
import dev.dawidlachor.pizzeria.exception.OrdersNotFoundException;
import dev.dawidlachor.pizzeria.repository.OrdersRepository;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final OrdersMapping ordersMapping;

    public OrdersService(OrdersRepository ordersRepository, OrdersMapping ordersMapping) {
        this.ordersRepository = ordersRepository;
        this.ordersMapping = ordersMapping;
    }

    public OrdersDto findById(Long id){
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(OrdersNotFoundException::new);
        return ordersMapping.toDto(orders);
    }
}

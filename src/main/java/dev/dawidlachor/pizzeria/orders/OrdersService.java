package dev.dawidlachor.pizzeria.orders;

import org.springframework.stereotype.Service;

import java.util.List;

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

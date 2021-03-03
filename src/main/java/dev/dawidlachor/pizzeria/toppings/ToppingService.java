package dev.dawidlachor.pizzeria.toppings;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToppingService {
    private ToppingRepository toppingRepository;

    public ToppingService(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }

    public List<ToppingDto> findAll(){
        return toppingRepository.findAll()
                .stream()
                .map(ToppingMapping::toDto)
                .collect(Collectors.toList());
    }
}

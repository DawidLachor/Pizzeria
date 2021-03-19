package dev.dawidlachor.pizzeria.service;

import dev.dawidlachor.pizzeria.dto.ToppingDto;
import dev.dawidlachor.pizzeria.mapping.ToppingMapping;
import dev.dawidlachor.pizzeria.repository.ToppingRepository;
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

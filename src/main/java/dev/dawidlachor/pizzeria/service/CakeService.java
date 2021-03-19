package dev.dawidlachor.pizzeria.service;

import dev.dawidlachor.pizzeria.repository.CakeRepository;
import dev.dawidlachor.pizzeria.mapping.CakeMapping;
import dev.dawidlachor.pizzeria.dto.CakeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CakeService {
    private CakeRepository cakeRepository;

    public CakeService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public List<CakeDto> findAll() {
       return cakeRepository.findAll()
                .stream()
                .map(CakeMapping::toDto)
                .collect(Collectors.toList());

    }
}

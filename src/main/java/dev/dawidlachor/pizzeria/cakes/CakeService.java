package dev.dawidlachor.pizzeria.cakes;

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
                .map(MappingCake::toDto)
                .collect(Collectors.toList());

    }
}

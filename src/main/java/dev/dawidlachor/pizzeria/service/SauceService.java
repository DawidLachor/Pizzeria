package dev.dawidlachor.pizzeria.service;

import dev.dawidlachor.pizzeria.dto.SauceDto;
import dev.dawidlachor.pizzeria.mapping.SauceMapping;
import dev.dawidlachor.pizzeria.repository.SauceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SauceService {

    private SauceRepository sauceRepository;

    public SauceService(SauceRepository sauceRepository) {
        this.sauceRepository = sauceRepository;
    }

    public List<SauceDto> findAll(){
        return sauceRepository.findAll()
                .stream()
                .map(SauceMapping::toDto)
                .collect(Collectors.toList());
    }
}

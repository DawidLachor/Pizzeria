package dev.dawidlachor.pizzeria.service;

import dev.dawidlachor.pizzeria.dto.SizeDto;
import dev.dawidlachor.pizzeria.mapping.SizeMapping;
import dev.dawidlachor.pizzeria.repository.SizeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SizeService {
    private SizeRepository sizeRepository;

    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    public List<SizeDto> findAll(){
        return sizeRepository.findAll()
                .stream()
                .map(SizeMapping::toDto)
                .collect(Collectors.toList());
    }
}

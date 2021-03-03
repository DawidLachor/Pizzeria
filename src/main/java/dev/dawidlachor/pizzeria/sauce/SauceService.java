package dev.dawidlachor.pizzeria.sauce;

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

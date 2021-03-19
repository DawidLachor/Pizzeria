package dev.dawidlachor.pizzeria.rest;

import dev.dawidlachor.pizzeria.dto.SizeDto;
import dev.dawidlachor.pizzeria.service.SizeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizza/size")
public class SizeResource {
    private final SizeService sizeService;

    public SizeResource(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @GetMapping
    public List<SizeDto> findAll(){
        return sizeService.findAll();
    }
}

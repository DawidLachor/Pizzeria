package dev.dawidlachor.pizzeria.cakes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizza/cake")
public class CakeResource {
    private final CakeService cakeService;


    public CakeResource(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping
    public List<CakeDto> findAll(){
       return cakeService.findAll();
    }
}

package dev.dawidlachor.pizzeria.sauce;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pizza/sauce")
public class SauceResource {
    private final SauceService sauceService;

    public SauceResource(SauceService sauceService) {
        this.sauceService = sauceService;
    }

    @GetMapping()
    public List<SauceDto> findAll(){
        return sauceService.findAll();
    }
}

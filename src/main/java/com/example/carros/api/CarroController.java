package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
    private CarroService carroService;

    @Autowired
    private CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping()
    public List<Carro> get() {
        return carroService.getCarros();
    }


}

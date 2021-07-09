package com.example.carros.service;

import com.example.carros.domain.Carro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {
    @Override
    public List<Carro> getCarros() {
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L, "Brasília"));
        carros.add(new Carro(3L, "Chevette"));

        return carros;
    }
}

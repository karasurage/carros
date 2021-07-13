package com.example.carros.service;

import com.example.carros.domain.Carro;

import java.util.List;
import java.util.Optional;

public interface CarroService {
    Iterable<Carro> getCarros();

    Optional<Carro> getCarroById(Long id);

    Iterable<Carro> getCarrosByTipo(String tipo);

    List<Carro> getCarrosFake();

    Carro insert(Carro carro);

    Carro update(Carro carro, Long id);

    void delete(Long id);
}
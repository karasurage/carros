package com.example.carros.service;

import com.example.carros.domain.Carro;
import com.example.carros.domain.dto.CarroDTO;

import java.util.List;
import java.util.Optional;

public interface CarroService {
    List<CarroDTO> getCarros();

    CarroDTO getCarroById(Long id);

    List<CarroDTO> getCarrosByTipo(String tipo);

    CarroDTO insert(Carro carro);

    CarroDTO update(Carro carro, Long id);

    void delete(Long id);
}
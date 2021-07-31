package com.example.carros.service.carro;

import com.example.carros.domain.Carro;
import com.example.carros.domain.dto.CarroDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarroService {
    List<CarroDTO> getCarros(Pageable pageable);

    CarroDTO getCarroById(Long id);

    List<CarroDTO> getCarrosByTipo(String tipo, Pageable pageable);

    CarroDTO insert(Carro carro);

    CarroDTO update(Carro carro, Long id);

    void delete(Long id);
}
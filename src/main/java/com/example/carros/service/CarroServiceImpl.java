package com.example.carros.service;

import com.example.carros.domain.Carro;
import com.example.carros.domain.dto.CarroDTO;
import com.example.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroServiceImpl implements CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<CarroDTO> getCarros() {
        List<CarroDTO> list = carroRepository.findAll()
                .stream()
                .map(CarroDTO::create)
                .collect(Collectors.toList());
        return list;
    }

    public Optional<CarroDTO> getCarroById(Long id) {
        return carroRepository.findById(id).map(CarroDTO::create);
    }

    public List<CarroDTO> getCarrosByTipo(String tipo) {
        return carroRepository.findByTipo(tipo)
                .stream()
                .map(CarroDTO::create)
                .collect(Collectors.toList());
    }

    public CarroDTO insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
        return CarroDTO.create(carroRepository.save(carro));
    }

    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Carro> optional = carroRepository.findById(id);
        if (optional.isPresent()) {
            Carro db = optional.get();
            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            carroRepository.save(db);

            return CarroDTO.create(db);
        } else {
            return null;
//            throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public boolean delete(Long id) {
        if (getCarroById(id).isPresent()) {
            carroRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
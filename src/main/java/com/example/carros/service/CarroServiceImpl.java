package com.example.carros.service;

import com.example.carros.domain.Carro;
import com.example.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroServiceImpl implements CarroService {
    @Autowired
    private CarroRepository carroRepository;

    @Override
    public Iterable<Carro> getCarros() {
        return carroRepository.findAll();
    }

    @Override
    public Optional<Carro> getCarroById(Long id) {
        return carroRepository.findById(id);
    }

    @Override
    public Iterable<Carro> getCarrosByTipo(String tipo) {
        return carroRepository.findByTipo(tipo);
    }

    @Override
    public List<Carro> getCarrosFake() {
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca", ""));
        carros.add(new Carro(2L, "Brasília", ""));
        carros.add(new Carro(3L, "Chevette", ""));

        return carros;
    }

    @Override
    public Carro insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possível inserir o registro");
        return carroRepository.save(carro);
    }

    @Override
    public Carro update(Carro carro, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Carro> optionalCarro = getCarroById(id);
        if (optionalCarro.isPresent()) {
            Carro db = optionalCarro.get();
            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            return carroRepository.save(db);
        } else {
            throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Carro> carro = getCarroById(id);
        if (carro.isPresent()) {
            carroRepository.deleteById(id);
        }
    }

}
package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {
    private CarroService carroService;

    @Autowired
    private CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping()
    public ResponseEntity<Iterable<Carro>> get() {
        return new ResponseEntity<>(carroService.getCarros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Carro> getById(@PathVariable("id") Long id) {
        return carroService.getCarroById(id);
    }

    @GetMapping("/tipo/{tipo}")
    public Iterable<Carro> getByTipo(@PathVariable("tipo") String tipo) {
        return carroService.getCarrosByTipo(tipo);
    }

    @PostMapping
    public String post(@RequestBody Carro carro) {
        Carro salvarCarro = carroService.insert(carro);
        return "Carro salvo com sucesso: " + salvarCarro.getId();
    }

    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Carro carro) {
        Carro atualizarCarro = carroService.update(carro, id);
        return "Carro atualizado com sucesso: " + atualizarCarro.getId();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        carroService.delete(id);
        return "Carro deletado com sucesso";
    }

}
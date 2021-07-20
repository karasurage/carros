package com.example.carros.api;

import com.example.carros.domain.Carro;
import com.example.carros.domain.dto.CarroDTO;
import com.example.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
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
    public ResponseEntity<List<CarroDTO>> get() {
        return ResponseEntity.ok(carroService.getCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) {
        Optional<CarroDTO> carro = carroService.getCarroById(id);

        return carro.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity getCarrosByTipo(@PathVariable("tipo") String tipo) {
        List<CarroDTO> carros = carroService.getCarrosByTipo(tipo);

        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Carro carro) {
        try {
            CarroDTO salvarCarro = carroService.insert(carro);
            URI location = getUri(carro.getId());
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Carro carro) {
        carro.setId(id);
        CarroDTO atualizarCarro = carroService.update(carro, id);
        return atualizarCarro != null ?
                ResponseEntity.ok(atualizarCarro) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        boolean ok = carroService.delete(id);

        return ok ?
                ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }

}
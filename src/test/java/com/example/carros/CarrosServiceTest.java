package com.example.carros;

import com.example.carros.config.exception.ObjectNotFoundException;
import com.example.carros.domain.Carro;
import com.example.carros.domain.dto.CarroDTO;
import com.example.carros.service.carro.CarroService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarrosServiceTest {

    @Autowired
    private CarroService carroService;

    @Autowired
    private Pageable pageable;

    @Test
    public void testSave() {

        Carro carro = new Carro();
        carro.setNome("Porshe");
        carro.setTipo("esportivos");

        CarroDTO c = carroService.insert(carro);

        assertNotNull(c);

        Long id = c.getId();
        assertNotNull(id);

        // Buscar o objeto
        c = carroService.getCarroById(id);
        assertNotNull(c);

        assertEquals("Porshe", c.getNome());
        assertEquals("esportivos", c.getTipo());

        // Deletar o objeto
        carroService.delete(id);

        // Verificar se deletou
        try {
            carroService.getCarroById(id);
            fail("O carro não foi excluído");
        } catch (ObjectNotFoundException e) {
            // OK
        }
    }

    @Test
    public void testLista() {

        List<CarroDTO> carros = carroService.getCarros(pageable);

        assertEquals(30, carros.size());
    }

    @Test
    public void testListaPorTipo() {

        assertEquals(10, carroService.getCarrosByTipo("classicos", pageable).size());
        assertEquals(10, carroService.getCarrosByTipo("esportivos", pageable).size());
        assertEquals(10, carroService.getCarrosByTipo("luxo", pageable).size());
        assertEquals(0, carroService.getCarrosByTipo("x", pageable).size());
    }

    @Test
    public void testGet() {

        CarroDTO c = carroService.getCarroById(11L);

        assertNotNull(c);

        assertEquals("Ferrari FF", c.getNome());
    }
}
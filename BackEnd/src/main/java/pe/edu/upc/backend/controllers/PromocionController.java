package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.PromocionDTO;
import pe.edu.upc.backend.entities.Promocion;
import pe.edu.upc.backend.serviceinterfaces.IPromocionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/promocion")
public class PromocionController {
    @Autowired
    private IPromocionService pS;
    @PostMapping
    public void insertar(@RequestBody PromocionDTO promocionDTO) {
        ModelMapper m = new ModelMapper();
        Promocion promocion = m.map(promocionDTO, Promocion.class);
        pS.insert(promocion);
    }
    @PutMapping
    public void actualizar(PromocionDTO promocionDTO) {
        ModelMapper m = new ModelMapper();
        Promocion promocion = m.map(promocionDTO, Promocion.class);
        pS.update(promocion);
    }
    @GetMapping
    public List<PromocionDTO> listar() {
        return pS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        pS.delete(id);
    }
}

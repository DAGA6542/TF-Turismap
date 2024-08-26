package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.PaisDTO;
import pe.edu.upc.backend.entities.Pais;
import pe.edu.upc.backend.serviceinterfaces.IPaisService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    IPaisService pS;
    @PostMapping
    public void insertar(@RequestBody PaisDTO paisDTO) {
        ModelMapper m = new ModelMapper();
        Pais pais = m.map(paisDTO, Pais.class);
        pS.insert(pais);
    }
    @PutMapping
    public void modificar(@RequestBody PaisDTO paisDTO) {
        ModelMapper m = new ModelMapper();
        Pais pais = m.map(paisDTO, Pais.class);
        pS.update(pais);
    }
    @GetMapping
    public List<PaisDTO> listar() {
        return pS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PaisDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        pS.delete(id);
    }
}
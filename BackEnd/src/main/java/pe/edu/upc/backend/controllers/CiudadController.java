package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.CiudadDTO;
import pe.edu.upc.backend.entities.Ciudad;
import pe.edu.upc.backend.serviceinterfaces.ICiudadService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/ciudades")
public class CiudadController {
    @Autowired
    private ICiudadService cS;
    @PostMapping
    public void registrar(@RequestBody CiudadDTO ciudadDTO) {
        ModelMapper m = new ModelMapper();
        Ciudad ciudad = m.map(ciudadDTO, Ciudad.class);
        cS.insert(ciudad);
    }
    @PutMapping
    public void modificar(@RequestBody CiudadDTO ciudadDTO) {
        ModelMapper m = new ModelMapper();
        Ciudad ciudad = m.map(ciudadDTO, Ciudad.class);
        cS.update(ciudad);
    }
    @GetMapping
    public List<CiudadDTO> listar() {
        return cS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, CiudadDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }
}

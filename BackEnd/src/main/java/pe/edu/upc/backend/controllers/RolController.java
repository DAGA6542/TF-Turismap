package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.RolDTO;
import pe.edu.upc.backend.entities.Rol;
import pe.edu.upc.backend.serviceinterfaces.IRolService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rS;
    @PostMapping
    public void agregar(@RequestBody RolDTO rolDTO) {
        ModelMapper m = new ModelMapper();
        Rol ciudad = m.map(rolDTO, Rol.class);
        rS.insert(ciudad);
    }
    @PutMapping
    public void modificar(@RequestBody RolDTO rolDTO) {
        ModelMapper m = new ModelMapper();
        Rol ciudad = m.map(rolDTO, Rol.class);
        rS.insert(ciudad);
    }
    @GetMapping
    public List<RolDTO> listar() {
        return rS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,RolDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        rS.delete(id);
    }
}

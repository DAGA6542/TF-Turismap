package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.FestividadDTO;
import pe.edu.upc.backend.dtos.LugarTuristicoDTO;
import pe.edu.upc.backend.entities.LugarTuristico;
import pe.edu.upc.backend.serviceinterfaces.ILugarTuristicoService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/lugarturistico")
public class LugarTuristicoController {
    @Autowired
    private ILugarTuristicoService lS;
    @PostMapping
    public void agregar(@RequestBody LugarTuristicoDTO lugarTuristicoDTO) {
        ModelMapper m = new ModelMapper();
        LugarTuristico lugarTuristico = m.map(lugarTuristicoDTO, LugarTuristico.class);
        lS.insert(lugarTuristico);
    }
    @PutMapping
    public void modificar(@RequestBody FestividadDTO festividadDTO) {
        ModelMapper m = new ModelMapper();
        LugarTuristico lugarTuristico = m.map(festividadDTO, LugarTuristico.class);
        lS.update(lugarTuristico);
    }
    @GetMapping
    public List<LugarTuristicoDTO> listar() {
        return lS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        lS.delete(id);
    }
    @GetMapping("/{id}")
    public LugarTuristicoDTO listPorId(@PathVariable("id") int id) {
        ModelMapper m = new ModelMapper();
        LugarTuristicoDTO list = m.map(lS.listById(id), LugarTuristicoDTO.class);
        return list;
    }
    @GetMapping("/listarPorNumero")
    public List<LugarTuristicoDTO> listarPorNumero(@RequestParam String nombreLugarTuristico) {
        return lS.listarPorNumero(nombreLugarTuristico).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listarlugarturisticoporciudad")
    public List<LugarTuristicoDTO> listarlugarturisticoporciudad(@RequestParam String nombreCiudad) {
        return lS.listarlugarturisticoporciudad(nombreCiudad).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }
}

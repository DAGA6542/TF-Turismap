package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.FestividadDTO;
import pe.edu.upc.backend.dtos.FestividadPorLugarTuristicoDTO;
import pe.edu.upc.backend.dtos.LugarTuristicoDTO;
import pe.edu.upc.backend.dtos.LugarTuristicoPorCiudadDTO;
import pe.edu.upc.backend.entities.Festividad;
import pe.edu.upc.backend.serviceinterfaces.IFestividadService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/festividad")
public class FestividadController {
    @Autowired
    private IFestividadService fS;
    @PostMapping
    public void agregar(@RequestBody FestividadDTO festividadDTO) {
        ModelMapper m = new ModelMapper();
        Festividad festividad = m.map(festividadDTO, Festividad.class);
        fS.insert(festividad);
    }
    @PutMapping
    public void modificar(@RequestBody FestividadDTO festividadDTO) {
        ModelMapper m = new ModelMapper();
        Festividad festividad = m.map(festividadDTO, Festividad.class);
        fS.update(festividad);
    }
    @GetMapping
    public List<FestividadDTO> listar() {
        return fS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,FestividadDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public FestividadDTO listPorId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        return m.map(fS.listById(id), FestividadDTO.class);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        fS.delete(id);
    }
    @GetMapping("/festividadporlugarturistico")
    public List<FestividadDTO> obtenerPorLugarTuristico(@RequestParam Long idLugar) {
        return fS.obtenerPorLugarTuristico(idLugar).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,FestividadDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidadfestividadesporlugarturistico")
    public long contarPorLugarTuristico(@RequestParam Long idLugar) {
        return fS.contarPorLugarTuristico(idLugar);
    }

    @GetMapping("/listarfestividadporlugarturistico")
    public List<FestividadPorLugarTuristicoDTO> listarfestividadporlugarturistico(@RequestParam String nombreLugar) { // By Diego
        return fS.listarfestividadporlugarturistico(nombreLugar).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, FestividadPorLugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }
}
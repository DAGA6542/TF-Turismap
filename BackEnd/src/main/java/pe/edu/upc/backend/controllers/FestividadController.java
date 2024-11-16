package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.FestividadDTO;
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
    @GetMapping("/cantidadlugaresturisticosporciudad")
    public long contarPorLugarTuristico(@RequestParam Long idLugar) {
        return fS.contarPorLugarTuristico(idLugar);
    }
}
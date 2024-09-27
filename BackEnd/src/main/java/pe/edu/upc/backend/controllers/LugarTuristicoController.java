package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.FestividadDTO;
import pe.edu.upc.backend.dtos.LugarTuristicoDTO;
import pe.edu.upc.backend.dtos.NegocioDTO;
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
    @GetMapping("/lugarturisticoporciudad")
    public List<LugarTuristicoDTO> obtenerPorCiudadL(@RequestParam int idCiudad) {
        return lS.obtenerPorCiudadL(idCiudad).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidadlugaresturisticosporciudad")
    public long contarPorCiudadL(@RequestParam int idCiudad) {
        return lS.contarPorCiudadL(idCiudad);
    }
}

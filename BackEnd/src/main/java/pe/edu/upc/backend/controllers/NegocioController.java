package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.NegocioDTO;
import pe.edu.upc.backend.entities.Negocio;
import pe.edu.upc.backend.serviceinterfaces.INegocioService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/negocio")
@PreAuthorize("hasAuthority('JEFE') or hasAuthority('ADMIN')")
public class NegocioController {
    @Autowired
    private INegocioService nS;
    @PostMapping
    public void agregar(@RequestBody NegocioDTO negocioDTO) {
        ModelMapper m = new ModelMapper();
        Negocio negocio = m.map(negocioDTO, Negocio.class);
        nS.insert(negocio);
    }
    @PutMapping
    public void modificar(@RequestBody NegocioDTO negocioDTO) {
        ModelMapper m = new ModelMapper();
        Negocio negocio = m.map(negocioDTO, Negocio.class);
        nS.update(negocio);
    }
    @GetMapping
    public List<NegocioDTO> listar() {
        return nS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) { nS.delete(id); }
    @GetMapping("/obtenerporciudad")
    public List<NegocioDTO> obtenerPorCiudad(@RequestParam int idCiudad) {
        return nS.obtenerPorCiudad(idCiudad).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/contarporciudad")
    public long contarPorCiudad(@RequestParam int idCiudad) {
        return nS.contarPorCiudad(idCiudad);
    }
    @GetMapping("/obtenerporcalificacion")
    public List<NegocioDTO> obtenerPorCalificacion(@RequestParam int calificacion) {
        return nS.obtenerPorCalificacion(calificacion).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarpornombre")
    public List<NegocioDTO> buscarPorNombre(@RequestParam String nombre) {
        return nS.buscarPorNombre(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporhorario")
    public List<NegocioDTO> obtenerPorHorario(@RequestParam String horario) {
        return nS.obtenerPorHorario(horario).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenermayorcalificados")
    public List<NegocioDTO> obtenerMayorCalificados(@RequestParam int calificacionNegocio) {
        return nS.obtenerMayorCalificados(calificacionNegocio).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerportelefono")
    public List<NegocioDTO> obtenerPorTelefono(@RequestParam int telefono) {
        return nS.obtenerPorTelefono(telefono).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporcalificacionrango")
    public List<NegocioDTO> obtenerPorCalificacionRango(@RequestParam int min, @RequestParam int max) {
        return nS.obtenerPorCalificacionRango(min, max).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporordenporcalificacion")
    public List<NegocioDTO> obtenerPorOrdenPorCalificacion() {
        return nS.obtenerPorOrdenPorCalificacion().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
}
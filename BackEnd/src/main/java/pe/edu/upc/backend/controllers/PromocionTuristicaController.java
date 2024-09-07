package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.PromocionTuristicaDTO;
import pe.edu.upc.backend.entities.PromocionTuristica;
import pe.edu.upc.backend.serviceinterfaces.IPromocionTuristicaService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/promocionesturisticas")
public class PromocionTuristicaController {
    @Autowired
    private IPromocionTuristicaService pS;
    @PostMapping
    public void agregar(@RequestBody PromocionTuristicaDTO promocionTuristicaDTO) {
        ModelMapper m = new ModelMapper();
        PromocionTuristica promocion = m.map(promocionTuristicaDTO, PromocionTuristica.class);
        pS.insert(promocion);
    }
    @PutMapping
    public void modificar(@RequestBody PromocionTuristicaDTO promocionTuristicaDTO) {
        ModelMapper m = new ModelMapper();
        PromocionTuristica promocion = m.map(promocionTuristicaDTO, PromocionTuristica.class);
        pS.update(promocion);
    }
    @GetMapping
    public List<PromocionTuristicaDTO> listar() {
        return pS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristicaDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        pS.delete(id);
    }
    @GetMapping("/listardescuentomayor")
    public List<PromocionTuristicaDTO> listarPorDescuentoMayor(@RequestParam double descuento) {
        return pS.listarPorDescuentoMayor(descuento).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristicaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listarfechainicio")
    public List<PromocionTuristicaDTO> listarPorFechaInicio(@RequestParam LocalDate fechaInicio) {
        return pS.listarPorFechaInicio(fechaInicio).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristicaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listarpornombre")
    public List<PromocionTuristicaDTO> listarPorNombre(@RequestParam String nombre) {
        return pS.listarPorNombre(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristicaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporpreciomenor")
    public List<PromocionTuristicaDTO> obtenerPorPrecioMenor(@RequestParam double precio) {
        return pS.obtenerPorPrecioMenor(precio).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristicaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenertodaspromosactives")
    public List<PromocionTuristicaDTO> obtenerTodasLasPromocionesActivas() {
        return pS.obtenerTodasLasPromocionesActivas().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristicaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerfechafin")
    public List<PromocionTuristicaDTO> obtenerPorFechaFin(@RequestParam LocalDate fechaFin) {
        return pS.obtenerPorFechaFin(fechaFin).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristicaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerrangoprecio")
    public List<PromocionTuristicaDTO> obtenerPorRangoPrecio(@RequestParam double min, @RequestParam double max) {
        return pS.obtenerPorRangoPrecio(min, max).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristicaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerpordescripcion")
    public List<PromocionTuristicaDTO> obtenerPorDescripcion(@RequestParam String descripcion) {
        return pS.obtenerPorDescripcion(descripcion).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristicaDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/contaractivosporfecha")
    public long contarActivosPorFecha(@RequestParam LocalDate fecha) {
        return pS.contarActivosPorFecha(fecha);
    }
}

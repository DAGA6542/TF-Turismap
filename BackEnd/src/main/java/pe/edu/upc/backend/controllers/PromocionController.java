package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.PromocionDTO;
import pe.edu.upc.backend.entities.Promocion;
import pe.edu.upc.backend.serviceinterfaces.IPromocionService;
import java.time.LocalDate;
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
    @GetMapping("/listarpordescuentomayor")
    public List<PromocionDTO> listarPorDescuentoMayor(@RequestParam double descuento) {
        return pS.listarPorDescuentoMayor(descuento).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listarporfechainicio")
    public List<PromocionDTO> listarPorFechaInicio(@RequestParam LocalDate fechaInicio) {
        return pS.listarPorFechaInicio(fechaInicio).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listrpornombre")
    public List<PromocionDTO> listarPorNombre(@RequestParam String nombre) {
        return pS.listarPorNombre(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporpreciomenor")
    public List<PromocionDTO> obtenerPorPrecioMenor(@RequestParam double precio) {
        return pS.obtenerPorPrecioMenor(precio).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenertodaslaspromocionesactivas")
    public List<PromocionDTO> obtenerTodasLasPromocionesActivas() {
        return pS.obtenerTodasLasPromocionesActivas().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporfechafin")
    public List<PromocionDTO> obtenerPorFechaFin(@RequestParam LocalDate fechaFin) {
        return pS.obtenerPorFechaFin(fechaFin).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporrangoprecio")
    public List<PromocionDTO> obtenerPorRangoPrecio(@RequestParam double min, @RequestParam double max) {
        return pS.obtenerPorRangoPrecio(min, max).stream().map( y->{
                ModelMapper m = new ModelMapper();
                return m.map(y,PromocionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerpordescripcion")
    public List<PromocionDTO> obtenerPorDescripcion(@RequestParam String descripcion) {
        return pS.obtenerPorDescripcion(descripcion).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/contaractivosporfecha")
    public long contarActivosPorFecha(@RequestParam LocalDate fecha) {
        return pS.contarActivosPorFecha(fecha);
    }
}

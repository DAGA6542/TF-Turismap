package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.FavoritosDTO;
import pe.edu.upc.backend.entities.Favoritos;
import pe.edu.upc.backend.serviceinterfaces.IFavoritosService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/favoritos")
public class FavoritosController {
    @Autowired
    private IFavoritosService fS;
    @PostMapping
    public void agregar(@RequestBody FavoritosDTO favoritosDTO) {
        ModelMapper m = new ModelMapper();
        Favoritos favoritos = m.map(favoritosDTO, Favoritos.class);
        fS.insert(favoritos);
    }
    @PutMapping
    public void actualizar(@RequestBody FavoritosDTO favoritosDTO) {
        ModelMapper m = new ModelMapper();
        Favoritos favoritos = m.map(favoritosDTO, Favoritos.class);
        fS.update(favoritos);
    }
    @GetMapping
    public List<FavoritosDTO> listar() {
        return fS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,FavoritosDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        fS.delete(id);
    }
    @GetMapping("/obtenerfavoriusuar")
    public List<FavoritosDTO> obtenerFavPorUsuario(int idUsuario) {
        return fS.obtenerFavPorUsuario(idUsuario).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,FavoritosDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerfavorporfechaagre")
    public List<FavoritosDTO> obtenerFavPorFechaAgregado(LocalDate fecha) {
        return fS.obtenerFavPorFechaAgregado(fecha).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,FavoritosDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidadfavordeusuar")
    public long cantidadFavoritosDeUsuario(int idUsuario) {
        return fS.cantidadFavoritosDeUsuario(idUsuario);
    }
    @GetMapping("/obtenerfavorrelacanegocio")
    public List<FavoritosDTO> obtenerFavoRelacionANegocio(int idNegocio) {
        return fS.obtenerFavoRelacionANegocio(idNegocio).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,FavoritosDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerfavorporfechamodifi")
    public List<FavoritosDTO> obtenerFavoritosPorFechaModificacion(LocalDate fecha) {
        return fS.obtenerFavoritosPorFechaModificacion(fecha).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,FavoritosDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("obtenerfavordeturismo")
    public List<FavoritosDTO> ObtenerFavoDeTurismo(int idTurismo) {
        return fS.ObtenerFavoDeTurismo(idTurismo).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,FavoritosDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/usuario/{idusuario}/favoritos")
    public void eliminarFavoDeUsuario(@PathVariable int idUsuario) {
        fS.eliminarFavoDeUsuario(idUsuario);
    }

}

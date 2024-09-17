package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.FavoritoDTO;
import pe.edu.upc.backend.entities.Favorito;
import pe.edu.upc.backend.serviceinterfaces.IFavoritoService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("favorito")
public class FavoritoController {
    @Autowired
    private IFavoritoService fS;
    @PostMapping
    public void insertar(@RequestBody FavoritoDTO favoritoDTO) {
        ModelMapper m = new ModelMapper();
        Favorito f = m.map(favoritoDTO, Favorito.class);
        fS.insert(f);
    }
    @GetMapping
    public List<FavoritoDTO> list() {
        return fS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,FavoritoDTO.class);
        }).collect(Collectors.toList());

    }
    @PutMapping
    public void update(@RequestBody Favorito favorito) {
        ModelMapper m = new ModelMapper();
        Favorito f = m.map(favorito, Favorito.class);
        fS.update(f);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int idFavorito) {
        fS.delete(idFavorito);
    }
    @GetMapping("/obtenerfavporusuario")
    public List<Favorito> obtenerFavPorUsuario(@RequestParam int idUsuario) {
        return fS.obtenerFavPorUsuario(idUsuario).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,Favorito.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerfavporfechaagregado")
    public List<Favorito> obtenerFavPorFechaAgregado(@RequestParam LocalDate fecha) {
        return fS.obtenerFavPorFechaAgregado(fecha).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,Favorito.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidadfavoritosdeusuario")
    public long cantidadFavoritosDeUsuario(@RequestParam int idUsuario) {
        return fS.cantidadFavoritosDeUsuario(idUsuario);
    }
    @GetMapping("/obtenerfavorrelacionanegocio")
    public List<Favorito> obtenerFavoRelacionANegocio(@RequestParam int idNegocio) {
        return fS.obtenerFavoRelacionANegocio(idNegocio).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,Favorito.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerfavoritosporfechamodificacion")
    public List<Favorito> obtenerFavoritosPorFechaModificacion(@RequestParam LocalDate fecha) {
        return fS.obtenerFavoritosPorFechaModificacion(fecha).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,Favorito.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerfavodeturismo")
    public List<Favorito> obtenerFavoDeTurismo(@RequestParam int idTuristico) {
        return fS.obtenerFavoDeTurismo(idTuristico).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,Favorito.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/elimfavusuario{id}")
    public void eliminarFavoDeUsuario(@PathVariable("id") int idUsuario) {
        fS.eliminarFavoDeUsuario(idUsuario);
    }
}

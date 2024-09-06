package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.FavoritosDTO;
import pe.edu.upc.backend.entities.Favoritos;
import pe.edu.upc.backend.serviceinterfaces.IFavoritosService;
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
}

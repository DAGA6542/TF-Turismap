package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.ComentarioDTO;
import pe.edu.upc.backend.entities.Comentario;
import pe.edu.upc.backend.serviceinterfaces.IComentarioService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private IComentarioService cS;
    @PostMapping
    public void agregar(@RequestBody ComentarioDTO comentarioDTO) {
        ModelMapper m = new ModelMapper();
        Comentario comentario = m.map(comentarioDTO, Comentario.class);
        cS.insert(comentario);
    }
    @PutMapping
    public void modificar(@RequestBody ComentarioDTO comentarioDTO) {
        ModelMapper m = new ModelMapper();
        Comentario comentario = m.map(comentarioDTO, Comentario.class);
        cS.update(comentario);
    }
    @GetMapping
    public List<ComentarioDTO> listar() {
        return cS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            m.map(y,ComentarioDTO.class);
            return m.map(y,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        cS.delete(id);
    }
    @GetMapping("/obtenercomentariosusuario")
    public List<ComentarioDTO> obtenerComentariosPorUsuario(@RequestParam int idUsuario) {
        return cS.obtenerComentariosPorUsuario(idUsuario).stream().map(y->{
            ModelMapper m = new ModelMapper();
            m.map(y,ComentarioDTO.class);
            return m.map(y,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarcomentariosnegocio")
    public List<ComentarioDTO> buscarComentariosPorNegocio(@RequestParam int idNegocio) {
        return cS.buscarComentariosPorNegocio(idNegocio).stream().map(y->{
            ModelMapper m = new ModelMapper();
            m.map(y,ComentarioDTO.class);
            return m.map(y,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarcomentariosturismo")
    public List<ComentarioDTO> buscarComentariosPorTurismo(@RequestParam int idTurismo) {
        return cS.buscarComentariosPorTurismo(idTurismo).stream().map(y->{
            ModelMapper m = new ModelMapper();
            m.map(y,ComentarioDTO.class);
            return m.map(y,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenercomentariofecha")
    public List<ComentarioDTO> obtenerComentariosHastaFecha(@RequestParam LocalDate fecha) {
        return cS.obtenerComentariosHastaFecha(fecha).stream().map(y->{
            ModelMapper m = new ModelMapper();
            m.map(y,ComentarioDTO.class);
            return m.map(y,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarcomentarios")
    public List<ComentarioDTO> buscarComentario(@RequestParam String texto) {
        return cS.buscarComentario(texto).stream().map(y->{
            ModelMapper m = new ModelMapper();
            m.map(y,ComentarioDTO.class);
            return m.map(y,ComentarioDTO.class);
        }).collect(Collectors.toList());
    }
}
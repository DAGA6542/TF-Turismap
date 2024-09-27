package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.UsuarioDTO;
import pe.edu.upc.backend.entities.Usuario;
import pe.edu.upc.backend.serviceinterfaces.IUsuarioService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/usuarios")
@PreAuthorize("hasAuthority('ADMIN')")
public class UsuarioController {
    @Autowired
    private IUsuarioService uS;
    @PostMapping
    public void agregar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(usuarioDTO, Usuario.class);
        uS.insert(usuario);
    }
    @PutMapping
    public void modificar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper m = new ModelMapper();
        Usuario usuario = m.map(usuarioDTO, Usuario.class);
        uS.update(usuario);
    }
    @GetMapping
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        uS.delete(id);
    }
    @GetMapping("/buscarpornombre")
    public List<UsuarioDTO> buscarPorNombre(@RequestParam String partialName) {
        return uS.buscarPorNombre(partialName).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarporemail")
    public UsuarioDTO buscarPorEmail(@RequestParam String emailUsuario) {
        return uS.buscarPorEmail(emailUsuario).getEmailUsuario().transform(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioDTO.class);
        });
    }
    @GetMapping("/buscarporrol")
    public List<UsuarioDTO> buscarPorRol(@RequestParam int idRol) {
        return uS.buscarPorRol(idRol).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/telefonousuario")
    public UsuarioDTO buscarPorTelefono(@RequestParam int telefonoUsuario) {
        Usuario usuario = uS.buscarPorTelefono(telefonoUsuario);
        ModelMapper m = new ModelMapper();
        return m.map(usuario, UsuarioDTO.class);
    }
    @GetMapping("/listarpornombreascendente")
    public List<UsuarioDTO> listarPorNombreAscendente() {
        return uS.listarPorNombreAscendente().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/findonebyusername")
    public UsuarioDTO findOneByUsername(@RequestParam String username) {
        return uS.findOneByUsername(username).getUsername().transform(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioDTO.class);
        });
    }
     @GetMapping("/obtenerComentario")
    public List<UsuarioDTO> obtenerComentario(@RequestParam String nombreNegocio) {
        return uS.obtenerComentario(nombreNegocio).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,UsuarioDTO.class);
        }).collect(Collectors.toList());

    }
}

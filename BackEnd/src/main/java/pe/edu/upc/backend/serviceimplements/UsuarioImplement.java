package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Usuario;
import pe.edu.upc.backend.repositories.IUsuarioRepository;
import pe.edu.upc.backend.serviceinterfaces.IUsuarioService;
import java.util.List;
@Service
public class UsuarioImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository uR;
    @Override
    public void insert(Usuario usuario) { uR.save(usuario); }
    @Override
    public List<Usuario> list() { return uR.findAll(); }
    @Override
    public void update(Usuario usuario) { uR.save(usuario); }
    @Override
    public void delete(int idUsuario) { uR.deleteById(idUsuario); }
    @Override
    public Usuario listById(int idUsuario) { return uR.findById(idUsuario).orElse(new Usuario()); }
    @Override
    public List<Usuario> buscarPorNombre(String partialName) { return uR.buscarPorNombre(partialName); }
    @Override
    public Usuario buscarPorEmail(String emailUsuario) { return uR.buscarPorEmail(emailUsuario); }
    @Override
    public List<Usuario> buscarPorRol(int idRol) { return uR.buscarPorRol(idRol); }
    @Override
    public Usuario buscarPorTelefono(int telefonoUsuario) { return uR.buscarPorTelefono(telefonoUsuario); }
    @Override
    public List<Usuario> listarPorNombreAscendente() { return uR.listarPorNombreAscendente(); }
    @Override
    public Usuario findOneByUsername(String username) { return uR.findOneByUsername(username); }
    @Override
    public List<Usuario> obtenerComentario(String nombreNegocio) {
        return uR.obtenerComentario(nombreNegocio);
    }
}

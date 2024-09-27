package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Usuario;
import java.util.List;
public interface IUsuarioService {
    public void insert(Usuario usuario);
    public List<Usuario> list();
    public void update(Usuario usuario);
    public void delete(int idUsuario);
    public List<Usuario> buscarPorNombre(String partialName);
    public Usuario buscarPorEmail(String emailUsuario);
    public List<Usuario> buscarPorRol(int idRol);
    public Usuario buscarPorTelefono(int telefonoUsuario);
    public List<Usuario> listarPorNombreAscendente();
    public Usuario findOneByUsername(String username);
    public List<Usuario> obtenerComentario(String asd);
    public void registrarRolUsuario(String nombreRol, Long id_usuario);
}

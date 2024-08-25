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
    public void delete(int idUsuario) { uR.deleteById(idUsuario); }
}
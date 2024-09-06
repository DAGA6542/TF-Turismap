package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Comentario;
import pe.edu.upc.backend.repositories.IComentarioRepository;
import pe.edu.upc.backend.serviceinterfaces.IComentarioService;
import java.util.List;
@Service
public class ComentarioImplement implements IComentarioService {
    @Autowired
    private IComentarioRepository cR;
    @Override
    public void insert(Comentario comentario) { cR.save(comentario); }
    @Override
    public List<Comentario> list() { return cR.findAll(); }
    @Override
    public void update(Comentario comentario) { cR.save(comentario); }
    @Override
    public void delete(int idComentario) { cR.deleteById(idComentario); }
}

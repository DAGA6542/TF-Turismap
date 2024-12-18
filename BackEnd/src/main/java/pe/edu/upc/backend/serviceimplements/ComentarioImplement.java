package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Comentario;
import pe.edu.upc.backend.repositories.IComentarioRepository;
import pe.edu.upc.backend.serviceinterfaces.IComentarioService;
import java.time.LocalDate;
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
    public void delete(Long idComentario) { cR.deleteById(idComentario); }
    @Override
    public Comentario listId(Long idComentario) { return cR.findById(idComentario).orElse(new Comentario()); }
    @Override
    public List<Comentario> obtenerComentariosPorUsuario(Long idUsuario) { return cR.obtenerComentariosPorUsuario(idUsuario); }
    @Override
    public List<Comentario> buscarComentariosPorNegocio(Long idNegocio) { return cR.buscarComentariosPorNegocio(idNegocio); }
    @Override
    public List<Comentario> buscarComentariosPorTurismo(Long idLugar) { return cR.buscarComentariosPorTurismo(idLugar); }
    @Override
    public List<Comentario> obtenerComentariosHastaFecha(LocalDate fecha) { return cR.obtenerComentariosHastaFecha(fecha); }
    @Override
    public List<Comentario> buscarComentario(String texto) { return cR.buscarComentario(texto); }
}

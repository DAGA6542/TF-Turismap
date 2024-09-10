package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Comentario;
import java.util.List;
public interface IComentarioService {
    public void insert(Comentario comentario);
    public List<Comentario> list();
    public void update(Comentario comentario);
    public void delete(int idComentario);
}

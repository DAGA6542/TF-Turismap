package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Comentario;
import java.time.LocalDate;
import java.util.List;
public interface IComentarioService {
    public void insert(Comentario comentario);
    public List<Comentario> list();
    public void update(Comentario comentario);
    public void delete(Long idComentario);
    public Comentario listId(Long idComentario);
    public List<Comentario> obtenerComentariosPorUsuario(Long idUsuario);
    public List<Comentario> buscarComentariosPorNegocio(Long idNegocio);
    public List<Comentario> buscarComentariosPorTurismo(Long idLugar);
    public List<Comentario> obtenerComentariosHastaFecha(LocalDate fecha);
    public List<Comentario> buscarComentario(String texto);
}
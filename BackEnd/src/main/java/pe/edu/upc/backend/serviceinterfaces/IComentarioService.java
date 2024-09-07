package pe.edu.upc.backend.serviceinterfaces;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.backend.entities.Comentario;

import java.time.LocalDate;
import java.util.List;
public interface IComentarioService {
    public void insert(Comentario comentario);
    public List<Comentario> list();
    public void update(Comentario comentario);
    public void delete(int idComentario);
    public List<Comentario> obtenerComentariosPorUsuario(int idUsuario);
    public List<Comentario> buscarComentariosPorNegocio(int idNegocio);
    public List<Comentario> buscarComentariosPorTurismo(int idTurismo);
    public List<Comentario> obtenerComentariosHastaFecha(LocalDate fecha);
    public List<Comentario> buscarComentario(String texto);
}

package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Comentario;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {
    @Query("SELECT c FROM Comentario c WHERE c.idUsuario.idUsuario = :idUsuario")
    List<Comentario> obtenerComentariosPorUsuario(@Param("idUsuario") int idUsuario); // Buscar todos los comentarios por usuario
    @Query("SELECT c FROM Comentario c WHERE c.idNegocio.idNegocio = :idNegocio")
    List<Comentario> buscarComentariosPorNegocio(@Param("idNegocio") int idNegocio); // Buscar todos los comentarios por negocio
    @Query("SELECT c FROM Comentario c WHERE c.idTurismo.idTurismo = :idTurismo")
    List<Comentario> buscarComentariosPorTurismo(@Param("idTurismo") int idTurismo); // Buscar comentarios por sitio turistico
    @Query("SELECT c FROM Comentario c WHERE c.fechaComentario <= :fecha")
    List<Comentario> obtenerComentariosHastaFecha(@Param("fecha") LocalDate fecha); // comentarios recientes hasta una fecha especifica
    @Query("SELECT c FROM Comentario c WHERE LOWER(c.textoComentario) LIKE LOWER(CONCAT('%', :texto, '%'))")
    List<Comentario> buscarComentario(@Param("texto") String texto); // Buscar comentario de tesxto
}
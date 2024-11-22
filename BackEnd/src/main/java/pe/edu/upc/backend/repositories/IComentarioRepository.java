package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Comentario;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Long> {
    // Buscar todos los comentarios por usuario
    @Query("Select c from Comentario c where c.idUsuario.idUsuario = :idUsuario")
    public List<Comentario> obtenerComentariosPorUsuario(@Param("idUsuario") Long idUsuario);
    // Buscar todos los comentarios por negocio
    @Query("Select c from Comentario c where c.idNegocio.idNegocio = :idNegocio")
    public List<Comentario> buscarComentariosPorNegocio(@Param("idNegocio") Long idNegocio);
    // Buscar comentarios por sitio turistico
<<<<<<< .merge_file_PWpiKR
    @Query("Select c from Comentario c where c.idLugarTuristico.idLugar = :idTurismo")
    public List<Comentario> buscarComentariosPorTurismo(@Param("idTurismo") Long idTurismo);
=======
    @Query("Select c from Comentario c where c.idLugar.idLugar = :idLugar")
    public List<Comentario> buscarComentariosPorTurismo(@Param("idLugar") Long idLugar);
>>>>>>> .merge_file_SjWcLN
    // comentarios recientes hasta una fecha especifica
    @Query("Select c from Comentario c where c.fechaComentario <= :fecha")
    public List<Comentario> obtenerComentariosHastaFecha(@Param("fecha") LocalDate fecha);
    // Buscar comentario de tesxto
    @Query("Select c from Comentario c where LOWER(c.textoComentario) like lower(concat('%', :texto, '%'))")
    public List<Comentario> buscarComentario(@Param("texto") String texto);
}

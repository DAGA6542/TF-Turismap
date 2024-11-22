package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Ciudad;
import java.util.List;
@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {
    // buscar ciudad por nombre
    @Query("Select c from Ciudad c where c.nombreCiudad like %:nombre%")
    public List<Ciudad> buscarNombreCiudad(@Param("nombre") String nombreCiudad);
    // latitud mayor a lo especificado

    @Query("SELECT c FROM Ciudad c WHERE c.poblacionCiudad >= :poblacion")
    public List<Ciudad> poblacionMayor(@Param("poblacion") Long poblacion);
    // cantidad de turismo
    @Query(value = " SELECT c.nombre_ciudad, COUNT(tu.id_lugar) AS cantidad_turismo \n" +
        " FROM ciudad c \n" +
        " INNER JOIN lugar_turistico tu ON c.id_ciudad = tu.id_ciudad \n" +
        " GROUP BY c.nombre_ciudad \n" +
        " ORDER BY cantidad_turismo DESC ", nativeQuery = true)
    public List<String[]> calcularCantidadTurismoPorCiudad();
    // Cantidad de comentario por ciudad
    @Query(value = " SELECT \n" +
            " ci.nombre_ciudad AS ciudad, \n" +
            " COUNT(co.id_comentario) AS totalComentarios \n" +
        " FROM \n" +
            " ciudad ci \n" +
        " LEFT JOIN \n" +
            " lugar_turistico lt ON ci.id_ciudad = lt.id_ciudad \n" +
        " LEFT JOIN \n" +
            " comentario co ON lt.id_lugar = co.id_lugar \n" +
        " GROUP BY \n" +
            " ci.nombre_ciudad \n" +
        " UNION ALL \n" +
        " SELECT \n" +
            " ci.nombre_ciudad AS ciudad, \n" +
            " COUNT(co.id_comentario) AS totalComentarios \n" +
        " FROM \n" +
            " ciudad ci \n" +
        " LEFT JOIN \n" +
            " negocio n ON ci.id_ciudad = n.id_ciudad \n" +
        " LEFT JOIN \n" +
            " comentario co ON n.id_negocio = co.id_negocio \n" +
        " GROUP BY \n" +
            " ci.nombre_ciudad \n" +
        " ORDER BY \n" +
            " totalComentarios DESC ", nativeQuery = true)
    public List<String[]> cantidadComentarioPorCiudad();
}
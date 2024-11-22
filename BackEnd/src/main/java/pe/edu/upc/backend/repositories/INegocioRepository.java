package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Negocio;
import java.util.List;
@Repository
public interface INegocioRepository extends JpaRepository<Negocio, Long> {
    // Obtener todos los negocios en una ciudad específica
    @Query("Select n from Negocio n where n.idCiudad.idCiudad = :idCiudad")
    public List<Negocio> obtenerPorCiudad(@Param("idCiudad") Long idCiudad);
    // Contar cuántos negocios hay en una ciudad específica
    @Query("Select count(n) from Negocio n where n.idCiudad.idCiudad = :idCiudad")
    public long contarPorCiudad(@Param("idCiudad") Long idCiudad);
    // Obtener negocios con una calificación mayor o igual a un valor específico
    @Query("Select n from Negocio n where n.calificacionNegocio >= :calificacion")
    public List<Negocio> obtenerPorCalificacion(@Param("calificacion") int calificacion);
    // Buscar negocios por nombre
    @Query("Select n from Negocio n where n.nombreNegocio like %:nombre%")
    public List<Negocio> buscarPorNombre(@Param("nombre") String nombre);
    // Obtener negocios que abren dentro de un horario específico
    @Query("Select n from Negocio n where n.horarioNegocio = :horario")
    public List<Negocio> obtenerPorHorario(@Param("horario") String horario);
    // Obtener el negocio con la mayor calificación
    @Query("Select n from Negocio n order by n.calificacionNegocio desc")
    public List<Negocio> obtenerMayorCalificados(@Param("calificacionNegocio") int calificacionNegocio);
    // Obtener negocios por número de teléfono
    @Query("Select n from Negocio n where n.numeroTelefonoNegocio = :telefono")
    public List<Negocio> obtenerPorTelefono(@Param("telefono") int telefono);
    // Obtener negocios con calificación entre un rango específico
    @Query("Select n from Negocio n where n.calificacionNegocio between :min and :max")
    public List<Negocio> obtenerPorCalificacionRango(@Param("min") int min, @Param("max") int max);
    // Obtener todos los negocios ordenados por calificación en orden descendente
    @Query("Select n from Negocio n order by n.calificacionNegocio desc")
    public List<Negocio> obtenerPorOrdenPorCalificacion();
    @Query("SELECT n FROM Negocio n WHERE n.latitudNegocio >= :latitud")
    public List<Negocio> latitudMayor(@Param("latitud") double latitud);
    // longitud menor a lo especificado
    @Query("SELECT n FROM Negocio n WHERE n.longitudNegocio <= :longitud")
    public List<Negocio> longitudMenor(@Param("longitud") double longitud);
    // Negocios más populares por calificación
    @Query(value = " SELECT \n" +
            " n.nombre_negocio AS negocio, \n" +
            " c.nombre_ciudad AS ciudad, \n" +
            " n.calificacion_negocio AS calificacion, \n" +
            " COUNT(com.id_comentario) AS totalComentarios \n" +
        " FROM \n" +
            " negocio n \n" +
        " JOIN \n" +
            " ciudad c ON n.id_ciudad = c.id_ciudad \n" +
        " LEFT JOIN \n" +
            " comentario com ON n.id_negocio = com.id_negocio \n" +
        " GROUP BY \n" +
            " n.id_negocio, c.nombre_ciudad \n" +
        " ORDER BY \n" +
            " n.calificacion_negocio DESC, totalComentarios DESC ", nativeQuery = true)
    public List<String[]> negocioMasPopularPorCalificacion();
    // Calificación promedio de negocios por ciudad
    @Query(value = " SELECT \n" +
            " ci.nombre_ciudad AS ciudad, \n" +
            " ROUND(AVG(n.calificacion_negocio), 2) AS calificacionPromedio \n" +
        " FROM \n" +
            " ciudad ci \n" +
        " JOIN \n" +
            " negocio n ON ci.id_ciudad = n.id_ciudad \n" +
        " GROUP BY \n" +
            " ci.nombre_ciudad \n" +
        " ORDER BY \n" +
            " calificacionPromedio DESC ", nativeQuery = true)
    public List<String[]> calificacionPromedioNegocioPorCiudad();
}
package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.LugarTuristico;
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
}
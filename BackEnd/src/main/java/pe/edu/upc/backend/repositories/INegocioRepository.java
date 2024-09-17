package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.upc.backend.entities.Negocio;
import java.util.List;
@Repository
public interface INegocioRepository extends JpaRepository<Negocio, Integer> {
    // Obtener todos los negocios en una ciudad específica
    @Query("Select n from Negocio n where n.idCiudad.idCiudad = :idCiudad")
    public List<Negocio> obtenerPorCiudad(@RequestParam("idCiudad") int idCiudad);
    // Contar cuántos negocios hay en una ciudad específica
    @Query("Select count(n) from Negocio n where n.idCiudad.idCiudad = :idCiudad")
    public long contarPorCiudad(@RequestParam("idCiudad") int idCiudad);
    // Obtener negocios con una calificación mayor o igual a un valor específico
    @Query("Select n from Negocio n where n.calificacionNegocio >= :calificacion")
    public List<Negocio> obtenerPorCalificacion(@RequestParam("calificacion") int calificacion);
    // Buscar negocios por nombre
    @Query("Select n from Negocio n where n.nombreNegocio like %:nombre%")
    public List<Negocio> buscarPorNombre(@RequestParam("nombre") String nombre);
    // Obtener negocios que abren dentro de un horario específico
    @Query("Select n from Negocio n where n.horarioNegocio = :horario")
    public List<Negocio> obtenerPorHorario(@RequestParam("horario") String horario);
    // Obtener el negocio con la mayor calificación
    @Query("Select n from Negocio n order by n.calificacionNegocio desc")
    public List<Negocio> obtenerMayorCalificados(int calificacionNegocio);
    // Obtener negocios por número de teléfono
    @Query("Select n from Negocio n where n.numeroTelefonoNegocio = :telefono")
    public List<Negocio> obtenerPorTelefono(@RequestParam("telefono") int telefono);
    // Obtener negocios con calificación entre un rango específico
    @Query("Select n from Negocio n where n.calificacionNegocio between :min and :max")
    public List<Negocio> obtenerPorCalificacionRango(@RequestParam("min") int min, @RequestParam("max") int max);
    // Obtener todos los negocios ordenados por calificación en orden descendente
    @Query("Select n from Negocio n order by n.calificacionNegocio desc")
    public List<Negocio> obtenerPorOrdenPorCalificacion();
}
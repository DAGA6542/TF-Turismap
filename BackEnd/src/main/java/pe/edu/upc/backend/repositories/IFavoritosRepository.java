package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Favoritos;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface IFavoritosRepository extends JpaRepository<Favoritos, Integer> {
    // Obtener todos los favoritos de un usuario específico
    @Query("Select f from Favoritos f where f.idUsuario.idUsuario = :idUsuario")
    public List<Favoritos> obtenerFavPorUsuario(@Param("idUsuario") int idUsuario);
    // Obtener todos los favoritos agregados en una fecha específica
    @Query("Select f from Favoritos f where f.fechaAgregadoFavorito = :fecha")
    public List<Favoritos> obtenerFavPorFechaAgregado(@Param("fecha") LocalDate fecha);
    // Contar cuántos favoritos tiene un usuario
    @Query("Select count(f) from Favoritos f where f.idUsuario.idUsuario = :idUsuario")
    public long cantidadFavoritosDeUsuario(@Param("idUsuario") int idUsuario);
    // Obtener los favoritos relacionados con un negocio específico
    @Query("Select f from Favoritos f where f.idNegocio.idNegocio = :idNegocio")
    public List<Favoritos> obtenerFavoRelacionANegocio(@Param("idNegocio") int idNegocio);
    // Obtener los favoritos que han sido modificados después de una fecha específica
    @Query("Select f from Favoritos f where f.fechaModificacionFavorito > :fecha")
    public List<Favoritos> obtenerFavoritosPorFechaModificacion(@Param("fecha") LocalDate fecha);
    // Obtener los favoritos relacionados con un destino turístico específico
    @Query("Select f from Favoritos f where f.idTurismo.idTurismo = :idTurismo")
    public List<Favoritos> ObtenerFavoDeTurismo(@Param("idTurismo") int idTurismo);
    // Eliminar todos los favoritos de un usuario específico
    @Modifying
    @Query("Delete from Favoritos f where f.idUsuario.idRol = :idUsuario")
    public void eliminarFavoDeUsuario(@Param("idUsuario") int idUsuario);
}

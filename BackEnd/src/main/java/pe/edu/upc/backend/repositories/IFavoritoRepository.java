package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Favorito;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface IFavoritoRepository extends JpaRepository<Favorito, Long> {
    // Obtener todos los favoritos de un usuario específico
    @Query("Select f from Favorito f where f.idUsuario = :idUsuario")
    public List<Favorito> obtenerFavPorUsuario(@Param("idUsuario") Long idUsuario);
    // Obtener todos los favoritos agregados en una fecha específica
    @Query("Select f from Favorito f where f.fechaAgregadoFavorito = :fecha")
    public List<Favorito> obtenerFavPorFechaAgregado(@Param("fecha") LocalDate fecha);
    // Contar cuántos favoritos tiene un usuario
    @Query("Select count(f) from Favorito f where f.idUsuario = :idUsuario")
    public long cantidadFavoritosDeUsuario(@Param("idUsuario") Long idUsuario);
    // Obtener los favoritos relacionados con un negocio específico
    @Query("Select f from Favorito f where f.idNegocio = :idNegocio")
    public List<Favorito> obtenerFavoRelacionANegocio(@Param("idNegocio") Long idNegocio);
    // Obtener los favoritos que han sido modificados después de una fecha específica
    @Query("Select f from Favorito f where f.fechaModificacionFavorito > :fecha")
    public List<Favorito> obtenerFavoritosPorFechaModificacion(@Param("fecha") LocalDate fecha);
    // Obtener los favoritos relacionados con un destino turístico específico
    @Query("Select f from Favorito f where f.idLugar = :idLugar")
    public List<Favorito> obtenerFavoDeTurismo(@Param("idLugar") Long idLugar);
    // Eliminar todos los favoritos de un usuario específico
    @Modifying
    @Query("Delete from Favorito f where f.idUsuario = :idUsuario")
    public void eliminarFavoDeUsuario(@Param("idUsuario") Long idUsuario);
}

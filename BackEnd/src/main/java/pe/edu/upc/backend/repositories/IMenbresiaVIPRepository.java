package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.MenbresiaVIP;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface IMenbresiaVIPRepository extends JpaRepository<MenbresiaVIP, Integer> {
    // Obtener todas las membresías activas
    @Query("Select m from MenbresiaVIP m where m.estadoMenbresiaVIP = true")
    public List<MenbresiaVIP> obtenerMenbresActiv();
    // Obtener todas las membresías de un usuario específico
    @Query("Select m from MenbresiaVIP m where m.idUsuario.idUsuario = :idUsuario")
    public List<MenbresiaVIP> obtenerMenbresDeUsuar(@Param("idUsuario") int idUsuario);
    // Obtener membresías cuyo tipo sea igual a un valor específico
    @Query("Select m from MenbresiaVIP m where m.tipoMenbresiaVIP = :tipo")
    public List<MenbresiaVIP> obtenerMenbresiasTipoMayorEspecifico(@Param("tipo") String tipo);
    // Contar cuántas membresías VIP están activas
    @Query("Select count(m) from MenbresiaVIP m where m.estadoMenbresiaVIP = true")
    public long cantidadMenbresActivas();
    // Obtener las membresías que expiran antes de una fecha específica
    @Query("Select m from MenbresiaVIP m where m.fechaFinMenbresiaVIP < :fecha")
    public List<MenbresiaVIP> obtenerMenbresExpiranEnFechaEspecifi(@Param("fecha") LocalDate fecha);
    // Obtener las membresías activas de un usuario específico
    @Query("Select m from MenbresiaVIP m where m.idUsuario.idUsuario = :idUsuario and m.estadoMenbresiaVIP = true")
    public List<MenbresiaVIP> obtenerMenbresDeUsuario(@Param("idUsuario") int idUsuario);
    // Eliminar todas las membresías inactivas
    @Modifying
    @Query("Delete from MenbresiaVIP m where m.estadoMenbresiaVIP = false")
    public void eliminarTodaMenbresInactiva();
}
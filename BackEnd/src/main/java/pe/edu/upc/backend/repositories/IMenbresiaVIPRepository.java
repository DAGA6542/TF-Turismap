package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.MenbresiaVIP;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface IMenbresiaVIPRepository extends JpaRepository<MenbresiaVIP, Long> {
    // Obtener todas las membresías activas
    @Query("Select m from MenbresiaVIP m where m.estadoMenbresiaVIP = true")
    public List<MenbresiaVIP> obtenerMenbresActiv();
    // Obtener todas las membresías de un usuario específico
    @Query("Select m from MenbresiaVIP m where m.idUsuario.idUsuario = :idUsuario")
    public List<MenbresiaVIP> obtenerMenbresDeUsuar(@Param("idUsuario") Long idUsuario);
    // Obtener membresías cuyo tipo sea igual a un valor específico
    @Query("Select m from MenbresiaVIP m where m.tipoMenbresiaVIP = :tipo")
    public List<MenbresiaVIP> obtenerMenbresiasTipoMayorEspecifico(@Param("tipo") String tipo);
    // Contar cuántas membresías VIP están activas
    @Query("Select count(m) from MenbresiaVIP m where m.estadoMenbresiaVIP = true")
    public int cantidadMenbresActivas();
    // Obtener las membresías que expiran antes de una fecha específica
    @Query("Select m from MenbresiaVIP m where m.fechaFinMenbresiaVIP < :fecha")
    public List<MenbresiaVIP> obtenerMenbresExpiranEnFechaEspecifi(@Param("fecha") LocalDate fecha);
    // Obtener las membresías activas de un usuario específico
    @Query("Select m from MenbresiaVIP m where m.idUsuario.idUsuario = :idUsuario and m.estadoMenbresiaVIP = true")
    public List<MenbresiaVIP> obtenerMenbresDeUsuario(@Param("idUsuario") Long idUsuario);
    //Obtener el nombre del usuario y su tipo de membresía
    @Query(value = "SELECT mv.* \n" +
            " FROM menbresiavip mv \n" +
            " JOIN usuario u ON mv.id_usuario = u.id_usuario \n" +
            " WHERE mv.tipo_menbresiavip = :tipoMenbresiaVIP", nativeQuery = true)
    public List<MenbresiaVIP> obtenerNombreUsuarioYTipoMembresia(@Param("tipoMenbresiaVIP") String tipo);
    // Usuarios con más membresías activas
    @Query(value = " SELECT \n" +
            " u.nombre_usuario AS usuario, \n" +
            " m.tipo_menbresiavip AS tipoMembresia, \n" +
            " m.beneficio_menbresiavip AS beneficios, \n" +
            " m.fecha_inicio_menbresiavip AS inicio, \n" +
            " m.fecha_fin_menbresiavip AS fin \n" +
        " FROM \n" +
            " menbresiavip m \n" +
        " JOIN \n" +
            " usuario u ON m.id_usuario = u.id_usuario \n" +
        " WHERE \n" +
            " m.estado_menbresiavip = TRUE \n" +
        " ORDER BY \n" +
            " m.fecha_fin_menbresiavip DESC ", nativeQuery = true)
    public List<String[]> usuariosConMasMenbresiasActivas();
}
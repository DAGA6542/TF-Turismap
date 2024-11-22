package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.LugarTuristico;
import java.util.List;
@Repository
public interface ILugarTuristicoRepository extends JpaRepository<LugarTuristico, Long> {
    // Obtener todos los lugares turisticos por id en una ciudad
    @Query("Select l from LugarTuristico l where l.idCiudad.idCiudad = :idCiudad")
    public List<LugarTuristico> obtenerPorCiudadL(@Param("idCiudad") Long idCiudad);
    // Contar cuántos lugares turisticos hay por id en una ciudad
    @Query("Select count(l) from LugarTuristico l where l.idCiudad.idCiudad = :idCiudad")
    public long contarPorCiudadL(@Param("idCiudad") Long idCiudad);

    @Query("Select lt from LugarTuristico lt where lt.nombreLugar = :nombreLugar")
    public List<LugarTuristico> listarPorNumero(@Param("nombreLugar") String nombreLugar);
    //Buscar lugar turistico por ciudad
    @Query(value = " SELECT LT.*\n" +
            " FROM lugar_turistico LT\n" +
            " JOIN ciudad C ON LT.id_ciudad = C.id_ciudad\n" +
            " WHERE C.nombre_ciudad = :nombreCiudad", nativeQuery = true)
    public List<LugarTuristico> listarlugarturisticoporciudad(@Param("nombreCiudad") String nombreCiudad);
    @Query("SELECT lt FROM LugarTuristico lt WHERE lt.latitudLugar >= :latitud")
    public List<LugarTuristico> latitudMayor(@Param("latitud") double latitud);
    // longitud menor a lo especificado
    @Query("SELECT lt FROM LugarTuristico lt WHERE lt.longitudLugar <= :longitud")
    public List<LugarTuristico> longitudMenor(@Param("longitud") double longitud);
    @Query("SELECT lt FROM LugarTuristico lt WHERE lt.latitudLugar >= :latitud AND lt.longitudLugar <= :longitud")
    public List<LugarTuristico> findByLatitudAndLongitud(@Param("latitud") double latitud, @Param("longitud") double longitud);
    // Lugares turísticos más comentados
    @Query(value = " SELECT \n" +
            " l.nombre_lugar AS lugarTuristico, \n" +
            " ci.nombre_ciudad AS ciudad, \n" +
            " COUNT(co.id_comentario) AS totalComentarios, \n" +
            " MAX(co.fecha_comentario) AS ultimaFechaComentario \n" +
        " FROM \n " +
            " lugar_turistico l \n" +
        " JOIN \n" +
            " ciudad ci ON l.id_ciudad = ci.id_ciudad \n" +
        " LEFT JOIN " +
            " comentario co ON l.id_lugar = co.id_lugar \n" +
        " GROUP BY \n" +
            " l.id_lugar, ci.nombre_ciudad \n" +
        " ORDER BY \n" +
            " totalComentarios DESC, ultimaFechaComentario DESC ", nativeQuery = true)
    public List<String[]> lugaresTuristicosMasComentarios();
}
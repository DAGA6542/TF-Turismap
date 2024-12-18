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
    //Buscar numero por id
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

    @Query(value="select c.nombre_lugar,  c.latitud_lugar, c.longitud_lugar  \n" +
            "             from lugar_turistico c ", nativeQuery = true)
    public List<String[]>coordenadas();

}

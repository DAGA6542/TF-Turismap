package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.LugarTuristico;

import java.util.List;

@Repository
public interface ILugarTuristicoRepository extends JpaRepository<LugarTuristico, Integer> {
    //Buscar numero por id
    @Query("Select lt from LugarTuristico lt where lt.nombreLugarTuristico = :nombreLugarTuristico")
    public List<LugarTuristico> listarPorNumero(@Param("nombreLugarTuristico") String nombreLugarTuristico);


    //Buscar lugar turistico por ciudad
    @Query(value = " SELECT LT.*\n" +
            " FROM lugar_turistico LT\n" +
            " JOIN ciudad C ON LT.id_ciudad = C.id_ciudad\n" +
            " WHERE C.nombre_ciudad = :nombreCiudad", nativeQuery = true)
    public List<LugarTuristico> listarlugarturisticoporciudad(@Param("nombreCiudad") String nombreCiudad);
}

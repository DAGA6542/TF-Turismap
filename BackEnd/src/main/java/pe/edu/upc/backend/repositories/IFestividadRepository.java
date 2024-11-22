package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Festividad;
import pe.edu.upc.backend.entities.LugarTuristico;

import java.util.List;

@Repository
public interface IFestividadRepository extends JpaRepository<Festividad, Long> {
    // Obtener todos las festividades por id en un lugar turistico
    @Query("Select f from Festividad f where f.idLugar.idLugar = :idLugar")
    public List<Festividad> obtenerPorLugarTuristico(@Param("idLugar") Long idLugarTuristico);
    // Contar cuántas festividades hay por id en un  lugar turistico
    @Query("Select count(f) from Festividad f where f.idLugar.idLugar = :idLugar")
    public long contarPorLugarTuristico(@Param("idLugar") Long idLugar);
    @Query(value = " SELECT f.*\n" +
            " FROM festividad f\n" +
            " JOIN lugar_turistico LT ON f.id_lugar_turistico = LT.id_lugar_turistico\n" +
            " WHERE LT.nombre_lugar = :nombreLugar", nativeQuery = true)
    public List<Festividad> listarfestividadporlugarturistico(@Param("nombreLugar") String nombreLugar);
}

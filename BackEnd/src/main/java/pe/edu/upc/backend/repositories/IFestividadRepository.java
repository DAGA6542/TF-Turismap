package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Festividad;
import java.util.List;

@Repository
public interface IFestividadRepository extends JpaRepository<Festividad, Long> {
    // Obtener todos las festividades por id en un lugar turistico
<<<<<<< .merge_file_QnOeqw
    @Query("Select f from Festividad f where f.idLugarTuristico.idLugar = :idLugarTuristico")
    public List<Festividad> obtenerPorLugarTuristico(@Param("idLugarTuristico") Long idLugarTuristico);
    // Contar cuántas festividades hay por id en un  lugar turistico
    @Query("Select count(f) from Festividad f where f.idLugarTuristico.idLugar = :idLugarTuristico")
    public long contarPorLugarTuristico(@Param("idLugarTuristico") Long idLugarTuristico);
=======
    @Query("Select f from Festividad f where f.idLugar.idLugar = :idLugar")
    public List<Festividad> obtenerPorLugarTuristico(@Param("idLugar") Long idLugar);
    // Contar cuántas festividades hay por id en un  lugar turistico
    @Query("Select count(f) from Festividad f where f.idLugar.idLugar = :idLugar")
    public long contarPorLugarTuristico(@Param("idLugar") Long idLugar);
>>>>>>> .merge_file_SIb6W9
}

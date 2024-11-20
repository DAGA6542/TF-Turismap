package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Ciudad;
import java.util.List;
@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {
    // buscar ciudad por nombre
    @Query("Select c from Ciudad c where c.nombreCiudad like %:nombre%")
    public List<Ciudad> buscarNombreCiudad(@Param("nombre") String nombreCiudad);
    // latitud mayor a lo especificado

    @Query("SELECT c FROM Ciudad c WHERE c.poblacionCiudad >= :poblacion")
    public List<Ciudad> poblacionMayor(@Param("poblacion") Long poblacion);
    // cantidad de turismo

    @Query(value = " select c.nombre_ciudad, count(*)\n" +
            " from ciudad c inner join lugar_turistico tu\n" +
            " on c.id_ciudad=tu.id_ciudad\n" +
            " group by c.nombre_ciudad",nativeQuery = true)
    public List<String[]>cantidadTurismo();
}
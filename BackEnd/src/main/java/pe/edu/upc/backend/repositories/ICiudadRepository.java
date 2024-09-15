package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Ciudad;
import java.util.List;
@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {
    @Query("Select c from Ciudad c where c.nombreCiudad like %:nombre%")
    public List<Ciudad> buscarNombreCiudad(@Param("nombre") String nombreCiudad);
    @Query("SELECT c FROM Ciudad c WHERE c.latitudCiudad >= :latitud")
    public List<Ciudad> latitudMayor(@Param("latitud") double latitud); // latitud mayor a lo especificado
    @Query("SELECT c FROM Ciudad c WHERE c.longitudCiudad <= :longitud")
    public List<Ciudad> longitudMenor(@Param("longitud") double longitud); // longitud menor a lo especificado
    @Query("SELECT c FROM Ciudad c WHERE c.poblacionCiudad >= :poblacion")
    public List<Ciudad> poblacionMayor(@Param("poblacion") Long poblacion); // poblacion mayor igual a lo especificado
    @Query(value = " select c.nombre_ciudad, count(*)\n" +
            "         from ciudad c inner join turismo tu\n" +
            "         on c.id_ciudad=tu.id_ciudad\n" +
            "        group by c.nombre_ciudad",nativeQuery = true)
    public List<String[]>cantidadTurismo();
}
package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Comentario;
import pe.edu.upc.backend.entities.Negocio;
import pe.edu.upc.backend.entities.PromocionTuristica;
import pe.edu.upc.backend.entities.Turismo;

import java.util.List;

@Repository
public interface ITurismoRepository extends JpaRepository<Turismo, Integer> {
    // Buscar numero por id
    @Query("Select t from Turismo t where t.idTurismo =:idTurismo")
    public List<Turismo> listarPorNumero(@Param("idTurismo") int idTurismo);

    // Buscar lugar turistico por ciudad
    @Query(value = "SELECT LT.nombre_turismo\n" +
            " FROM Turismo LT\n" +
            " JOIN ciudad C ON LT.id_ciudad = C.id_ciudad\n" +
            " WHERE C.nombre_ciudad = 'nombreCiudad'", nativeQuery = true)
    public List<Turismo> listarlugarturisticoporciudad1(@Param("nombreCiudad") String nombreCiudad);

}

package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Rol;
import java.util.List;
@Repository
public interface IRolRepository extends JpaRepository<Rol, Long> {
    @Query(value = " SELECT r.rol, COUNT(*) AS cantidad \n" +
        " FROM rol r \n" +
        " INNER JOIN usuario u ON r.user_id = u.id_usuario \n" +
        " GROUP BY r.rol \n" +
        " ORDER BY cantidad DESC ", nativeQuery = true)
    List<String[]> contarRoles();
}
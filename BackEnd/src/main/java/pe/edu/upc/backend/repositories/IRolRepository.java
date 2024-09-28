package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Rol;
import java.util.List;
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    @Query(value = "select c.rol, count(*)\n" +
            " from rol c inner join usuario us\n" +
            " on c.user_id= us.id_usuario\n" +
            " group by c.rol", nativeQuery = true)
    public List<String[]> contarRol();
}
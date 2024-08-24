package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Rol;
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
}
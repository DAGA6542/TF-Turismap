package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.PromocionTuristica;
@Repository
public interface IPromocionTuristicaRepository extends JpaRepository<PromocionTuristica, Integer> {
}
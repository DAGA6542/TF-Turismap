package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.PromocionTuristica;
import java.util.List;
public interface IPromocionTuristicaService {
    public void insert(PromocionTuristica promocionTuristica);
    public List<PromocionTuristica> list();
    public void update(PromocionTuristica promocionTuristica);
    public void delete(int idPromocionTuristica);
}

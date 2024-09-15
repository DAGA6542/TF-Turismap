package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Promocion;
import java.util.List;
public interface IPromocionService {
    public void insert(Promocion promocion);
    public List<Promocion> list();
    public void update(Promocion promocion);
    public void delete(int idPromocion);
}

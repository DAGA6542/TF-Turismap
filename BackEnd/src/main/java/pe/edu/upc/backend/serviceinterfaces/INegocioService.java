package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Negocio;
import java.util.List;
public interface INegocioService {
    public void insert(Negocio negocio);
    public List<Negocio> list();
    public void update(Negocio negocio);
    public void delete(int idNegocio);
}

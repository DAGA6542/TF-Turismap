package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Ciudad;
import java.util.List;
public interface ICiudadService {
    public void insert(Ciudad ciudad);
    public List<Ciudad> list();
    public void delete(int idCiudad);
}

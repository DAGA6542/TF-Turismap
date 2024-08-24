package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Pais;
import java.util.List;
public interface IPaisService {
    public void insert(Pais pais);
    public List<Pais> list();
    public void delete(int idPais);
}
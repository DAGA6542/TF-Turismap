package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Rol;
import java.util.List;
public interface IRolService {
    public void insert(Rol rol);
    public List<Rol> list();
    public void update(Rol rol);
    public void delete(int idRol);
    public List<String[]>contarRol();
}

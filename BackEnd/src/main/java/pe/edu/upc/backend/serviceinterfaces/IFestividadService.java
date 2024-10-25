package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Festividad;
import java.util.List;
public interface IFestividadService {
    public void insert(Festividad festividad);
    public List<Festividad> list();
    public void update(Festividad festividad);
    public void delete(int idFestividadId);
    public List<Festividad> obtenerPorLugarTuristico(int idLugarTuristico);
    public long contarPorLugarTuristico(int idLugarTuristico);
}

package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Departamento;
import java.util.List;
public interface IDepartamentoService {
    public void insert(Departamento departamento);
    public List<Departamento> list();
    public void delete(int idDepartamento);
}
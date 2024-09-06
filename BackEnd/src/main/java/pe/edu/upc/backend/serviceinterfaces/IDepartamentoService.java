package pe.edu.upc.backend.serviceinterfaces;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.backend.entities.Departamento;
import java.util.List;
public interface IDepartamentoService {
    public void insert(Departamento departamento);
    public List<Departamento> list();
    public void update(Departamento departamento);
    public void delete(int idDepartamento);
    public List<Departamento> listarPorPais(int idPais);
    public List<Departamento> buscarPorNombre(String nombre);
    public List<Departamento> obtenerDepartamentPoblac(Long poblacion);
    public List<Departamento> buscarDepartamentoConSuperficie(int minSuperficie, int maxSuperficie);
    public List<Departamento> obtenerPorPoblacionDesc();
    public List<Departamento> buscarPorCapital(String capital);
}
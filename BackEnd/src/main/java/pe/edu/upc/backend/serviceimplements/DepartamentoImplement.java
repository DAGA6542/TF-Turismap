package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Departamento;
import pe.edu.upc.backend.repositories.IDepartamentoRepository;
import pe.edu.upc.backend.serviceinterfaces.IDepartamentoService;
import java.util.List;
@Service
public class DepartamentoImplement implements IDepartamentoService {
    @Autowired
    private IDepartamentoRepository dR;
    @Override
    public void insert(Departamento departamento) { dR.save(departamento); }
    @Override
    public List<Departamento> list() { return dR.findAll(); }
    @Override
    public void update(Departamento departamento) { dR.save(departamento); }
    @Override
    public void delete(int idDepartamento) { dR.deleteById(idDepartamento); }
    @Override
    public List<Departamento> buscarPorNombre(String nombre) { return dR.buscarPorNombre(nombre); }
    @Override
    public List<Departamento> listarPorPais(int idPais) { return dR.listarPorPais(idPais); }
    @Override
    public List<Departamento> obtenerDepartamentPoblac(Long poblacion) { return dR.obtenerDepartamentPoblac(poblacion); }
    @Override
    public List<Departamento> buscarDepartamentoConSuperficie(int minSuperficie, int maxSuperficie) { return dR.buscarDepartamentoConSuperficie(minSuperficie, maxSuperficie); }
    @Override
    public List<Departamento> obtenerPorPoblacionDesc() { return dR.obtenerPorPoblacionDesc(); }
    @Override
    public List<Departamento> buscarPorCapital(String capital) { return dR.buscarPorCapital(capital); }
}
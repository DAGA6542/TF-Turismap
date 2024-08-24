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
    public void delete(int idDepartamento) { dR.deleteById(idDepartamento); }
}
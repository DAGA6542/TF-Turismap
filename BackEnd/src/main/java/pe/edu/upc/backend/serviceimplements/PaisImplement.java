package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Pais;
import pe.edu.upc.backend.repositories.IPaisRepository;
import pe.edu.upc.backend.serviceinterfaces.IPaisService;
import java.util.List;
@Service
public class PaisImplement implements IPaisService {
    @Autowired
    private IPaisRepository pR;
    @Override
    public void insert(Pais pais) { pR.save(pais); }
    @Override
    public void update(Pais pais) { pR.save(pais); }
    @Override
    public List<Pais> list() { return pR.findAll(); }
    @Override
    public void delete(int idPais) { pR.deleteById(idPais); }
}

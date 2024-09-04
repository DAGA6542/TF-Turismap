package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Negocio;
import pe.edu.upc.backend.repositories.INegocioRepository;
import pe.edu.upc.backend.serviceinterfaces.INegocioService;
import java.util.List;
@Service
public class NegocioImplement implements INegocioService {
    @Autowired
    private INegocioRepository nR;
    @Override
    public void insert(Negocio negocio) { nR.save(negocio); }
    @Override
    public List<Negocio> list() { return nR.findAll(); }
    @Override
    public void update(Negocio negocio) { nR.save(negocio); }
    @Override
    public void delete(int idNegocio) { nR.deleteById(idNegocio); }
}

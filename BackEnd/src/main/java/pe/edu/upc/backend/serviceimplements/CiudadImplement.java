package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Ciudad;
import pe.edu.upc.backend.repositories.ICiudadRepository;
import pe.edu.upc.backend.serviceinterfaces.ICiudadService;
import java.util.List;
@Service
public class CiudadImplement implements ICiudadService {
    @Autowired
    private ICiudadRepository cR;
    @Override
    public void insert(Ciudad ciudad) { cR.save(ciudad); }
    @Override
    public List<Ciudad> list() { return cR.findAll(); }
    @Override
    public void delete(int idCiudad) { cR.deleteById(idCiudad); }
}
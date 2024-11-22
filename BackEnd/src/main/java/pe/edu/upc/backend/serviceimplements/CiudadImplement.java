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
    public void update(Ciudad ciudad) { cR.save(ciudad); }
    @Override
    public void delete(Long idCiudad) { cR.deleteById(idCiudad); }
    @Override
    public Ciudad listId(Long idCiudad) { return cR.findById(idCiudad).orElse(new Ciudad()); }
    @Override
    public List<Ciudad> buscarNombreCiudad(String nombreCiudad) { return cR.buscarNombreCiudad(nombreCiudad); }
    @Override
    public List<Ciudad> poblacionMayor(Long poblacion) { return cR.poblacionMayor(poblacion); }
    @Override
    public List<String[]> cantidadTurismo() {return cR.cantidadTurismo();}
}
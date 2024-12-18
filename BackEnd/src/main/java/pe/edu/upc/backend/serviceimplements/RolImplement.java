package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Rol;
import pe.edu.upc.backend.repositories.IRolRepository;
import pe.edu.upc.backend.serviceinterfaces.IRolService;
import java.util.List;
@Service
public class RolImplement implements IRolService {
    @Autowired
    private IRolRepository rR;
    @Override
    public void insert(Rol rol) { rR.save(rol); }
    @Override
    public List<Rol> list() { return rR.findAll(); }
    @Override
    public void update(Rol rol) { rR.save(rol); }
    @Override
    public void delete(Long idRol) { rR.deleteById(idRol); }
    @Override
    public Rol listById(Long idRol) { return rR.findById(idRol).orElse(new Rol()); }
    @Override
    public List<String[]> contarRol() { return rR.contarRol(); }
}
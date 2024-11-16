package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Festividad;
import pe.edu.upc.backend.repositories.IFestividadRepository;
import pe.edu.upc.backend.serviceinterfaces.IFestividadService;
import java.util.List;
@Service
public class FestividadImplement implements IFestividadService {
    @Autowired
    private IFestividadRepository fR;
    @Override
    public void insert(Festividad festividad) { fR.save(festividad); }
    @Override
    public List<Festividad> list() { return fR.findAll(); }
    @Override
    public void update(Festividad festividad) { fR.save(festividad); }
    @Override
    public void delete(Long idFestividadId) { fR.deleteById(idFestividadId); }
    @Override
    public Festividad listById(Long idFestividad) { return fR.findById(idFestividad).orElse(new Festividad()); }
    @Override
    public List<Festividad> obtenerPorLugarTuristico(Long idLugarTuristico) { return fR.obtenerPorLugarTuristico(idLugarTuristico); }
    @Override
    public long contarPorLugarTuristico(Long idLugarTuristico) { return fR.contarPorLugarTuristico(idLugarTuristico); }
}

package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.LugarTuristico;
import pe.edu.upc.backend.repositories.ILugarTuristicoRepository;
import pe.edu.upc.backend.serviceinterfaces.ILugarTuristicoService;
import java.util.List;
@Service
public class LugarTuristicoImplement implements ILugarTuristicoService {
    @Autowired
    private ILugarTuristicoRepository lR;
    @Override
    public void insert(LugarTuristico lugarTuristico) { lR.save(lugarTuristico); }
    @Override
    public List<LugarTuristico> list() { return lR.findAll(); }
    @Override
    public void update(LugarTuristico lugarTuristico) { lR.save(lugarTuristico); }
    @Override
    public void delete(int idLugarTuristico) { lR.deleteById(idLugarTuristico); }
    @Override
    public LugarTuristico listById(int idLugarTuristico) { return lR.findById(idLugarTuristico).orElse(new LugarTuristico()); }
    @Override
    public List<LugarTuristico> listarPorNumero(String nombreLugarTuristico) { return lR.listarPorNumero(nombreLugarTuristico); }
    @Override
    public List<LugarTuristico> listarlugarturisticoporciudad(String nombreCiudad) { return lR.listarlugarturisticoporciudad(nombreCiudad); }
}

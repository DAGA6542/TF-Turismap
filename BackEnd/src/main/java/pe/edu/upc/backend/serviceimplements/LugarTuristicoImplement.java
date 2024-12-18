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
    public void delete(Long idLugarTuristico) { lR.deleteById(idLugarTuristico); }
    @Override
    public LugarTuristico listById(Long listById) { return lR.findById(listById).orElse(new LugarTuristico()); }
    @Override
    public List<LugarTuristico> obtenerPorCiudadL(Long idCiudad) { return lR.obtenerPorCiudadL(idCiudad); }
    @Override
    public long contarPorCiudadL(Long idCiudad) { return lR.contarPorCiudadL(idCiudad); }
    @Override
    public List<LugarTuristico> listarPorNumero(String nombreLugar) { return lR.listarPorNumero(nombreLugar); }

    @Override
    public List<LugarTuristico> latitudMayor(double latitud) {
        return lR.latitudMayor(latitud);
    }

    @Override
    public List<LugarTuristico> longitudMenor(double longitud) {
        return lR.longitudMenor(longitud);
    }

    @Override
    public List<LugarTuristico> listarlugarturisticoporciudad(String nombreCiudad) { return lR.listarlugarturisticoporciudad(nombreCiudad); }

    @Override
    public List<String[]> coordenadas() {
        return lR.coordenadas();
    }


}

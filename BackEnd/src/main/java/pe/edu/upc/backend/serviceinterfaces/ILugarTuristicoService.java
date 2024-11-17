package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Ciudad;
import pe.edu.upc.backend.entities.LugarTuristico;
import java.util.List;
public interface ILugarTuristicoService {
    public void insert(LugarTuristico lugarTuristico);
    public List<LugarTuristico> list();
    public void update(LugarTuristico lugarTuristico);
    public void delete(Long idLugarTuristico);
    public LugarTuristico listById(Long listById);
    public List<LugarTuristico> obtenerPorCiudadL(Long idCiudad);
    public long contarPorCiudadL(Long idCiudad);
    public List<LugarTuristico> listarPorNumero(String nombreLugar);
    public List<LugarTuristico> latitudMayor(double latitud);
    public List<LugarTuristico> longitudMenor(double longitud);
    public List<LugarTuristico> listarlugarturisticoporciudad(String nombreCiudad);
    public List<LugarTuristico> findByLatitudAndLongitud(double latitud,double longitud);

}
package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.LugarTuristico;
import java.util.List;
public interface ILugarTuristicoService {
    public void insert(LugarTuristico lugarTuristico);
    public List<LugarTuristico> list();
    public void update(LugarTuristico lugarTuristico);
    public void delete(int idLugarTuristico);
    public LugarTuristico listById(int idLugarTuristico);
    public List<LugarTuristico> listarPorNumero(String nombreLugarTuristico);
    public List<LugarTuristico> listarlugarturisticoporciudad(String nombreCiudad);
}
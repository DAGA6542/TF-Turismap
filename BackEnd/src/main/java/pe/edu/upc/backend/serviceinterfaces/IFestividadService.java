package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Festividad;
import pe.edu.upc.backend.entities.LugarTuristico;

import java.util.List;
public interface IFestividadService {
    public void insert(Festividad festividad);
    public List<Festividad> list();
    public void update(Festividad festividad);
    public void delete(Long idFestividadId);
    public List<Festividad> obtenerPorLugarTuristico(Long idLugar);
    public long contarPorLugarTuristico(Long idLugar);
    public Festividad listById(Long idFestividad);
    public List<Festividad> listarfestividadporlugarturistico(String nombreLugar);
}
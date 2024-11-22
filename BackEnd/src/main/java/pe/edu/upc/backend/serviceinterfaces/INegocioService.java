package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.LugarTuristico;
import pe.edu.upc.backend.entities.Negocio;
import java.util.List;
public interface INegocioService {
    public void insert(Negocio negocio);
    public List<Negocio> list();
    public void update(Negocio negocio);
    public void delete(Long idNegocio);
    public List<Negocio> obtenerPorCiudad(Long idCiudad);
    public Negocio listById(Long idNegocio);
    public long contarPorCiudad(Long idCiudad);
    public List<Negocio> obtenerPorCalificacion(int calificacion);
    public List<Negocio> buscarPorNombre(String nombre);
    public List<Negocio> obtenerPorHorario(String horario);
    public List<Negocio> obtenerMayorCalificados(int calificacionNegocio);
    public List<Negocio> latitudMayor(double latitud);
    public List<Negocio> longitudMenor(double longitud);
    public List<Negocio> obtenerPorTelefono(int telefono);
    public List<Negocio> obtenerPorCalificacionRango(int min, int max);
    public List<Negocio> obtenerPorOrdenPorCalificacion();
    public List<String[]> negocioMasPopularPorCalificacion();
    public List<String[]> calificacionPromedioNegocioPorCiudad();
}

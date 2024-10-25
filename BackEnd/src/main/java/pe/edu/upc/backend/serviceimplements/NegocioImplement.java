package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Negocio;
import pe.edu.upc.backend.repositories.INegocioRepository;
import pe.edu.upc.backend.serviceinterfaces.INegocioService;
import java.util.List;
@Service
public class NegocioImplement implements INegocioService {
    @Autowired
    private INegocioRepository nR;
    @Override
    public void insert(Negocio negocio) { nR.save(negocio); }
    @Override
    public List<Negocio> list() { return nR.findAll(); }
    @Override
    public void update(Negocio negocio) { nR.save(negocio); }
    @Override
    public void delete(int idNegocio) { nR.deleteById(idNegocio); }
    @Override
    public List<Negocio> obtenerPorCiudad(int idCiudad) { return nR.obtenerPorCiudad(idCiudad); }
    @Override
    public Negocio listById(int idNegocio) { return nR.findById(idNegocio).orElse(new Negocio()); }
    @Override
    public long contarPorCiudad(int idCiudad) { return nR.contarPorCiudad(idCiudad); }
    @Override
    public List<Negocio> obtenerPorCalificacion(int calificacion) { return nR.obtenerPorCalificacion(calificacion); }
    @Override
    public List<Negocio> buscarPorNombre(String nombre) { return nR.buscarPorNombre(nombre); }
    @Override
    public List<Negocio> obtenerPorHorario(String horario) { return nR.obtenerPorHorario(horario); }
    @Override
    public List<Negocio> obtenerMayorCalificados(int calificacionNegocio) { return nR.obtenerMayorCalificados(calificacionNegocio); }
    @Override
    public List<Negocio> obtenerPorTelefono(int telefono) { return nR.obtenerPorTelefono(telefono); }
    @Override
    public List<Negocio> obtenerPorCalificacionRango(int min, int max) { return nR.obtenerPorCalificacionRango(min, max); }
    @Override
    public List<Negocio> obtenerPorOrdenPorCalificacion() { return nR.obtenerPorOrdenPorCalificacion(); }
}

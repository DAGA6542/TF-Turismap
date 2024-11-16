package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Promocion;
import pe.edu.upc.backend.repositories.IPromocionRepository;
import pe.edu.upc.backend.serviceinterfaces.IPromocionService;
import java.time.LocalDate;
import java.util.List;
@Service
public class PromocionImplement implements IPromocionService {
    @Autowired
    private IPromocionRepository pR;
    @Override
    public void insert(Promocion promocion) { pR.save(promocion); }
    @Override
    public List<Promocion> list() { return pR.findAll(); }
    @Override
    public void update(Promocion promocion) { pR.save(promocion); }
    @Override
    public void delete(Long idPromocion) { pR.deleteById(idPromocion); }
    @Override
    public Promocion listById(Long idPromocion) { return pR.findById(idPromocion).orElse(new Promocion()); }
    @Override
    public List<Promocion> listarPorDescuentoMayor(double descuento) { return pR.listarPorDescuentoMayor(descuento); }
    @Override
    public List<Promocion> listarPorFechaInicio(LocalDate fechaInicio) { return pR.listarPorFechaInicio(fechaInicio); }
    @Override
    public List<Promocion> listarPorNombre(String nombre) { return pR.listarPorNombre(nombre); }
    @Override
    public List<Promocion> obtenerPorPrecioMenor(double precio) { return pR.obtenerPorPrecioMenor(precio); }
    @Override
    public List<Promocion> obtenerTodasLasPromocionesActivas() { return pR.obtenerTodasLasPromocionesActivas(); }
    @Override
    public List<Promocion> obtenerPorFechaFin(LocalDate fechaFin) { return pR.obtenerPorFechaFin(fechaFin); }
    @Override
    public List<Promocion> obtenerPorRangoPrecio(double min, double max) { return pR.obtenerPorRangoPrecio(min, max); }
    @Override
    public List<Promocion> obtenerPorDescripcion(String descripcion) { return pR.obtenerPorDescripcion(descripcion); }
    @Override
    public long contarActivosPorFecha(LocalDate fecha) { return pR.contarActivosPorFecha(fecha); }
}

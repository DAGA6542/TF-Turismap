package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.PromocionTuristica;
import java.time.LocalDate;
import java.util.List;
public interface IPromocionTuristicaService {
    public void insert(PromocionTuristica promocionTuristica);
    public List<PromocionTuristica> list();
    public void update(PromocionTuristica promocionTuristica);
    public void delete(int idPromocionTuristica);
    public List<PromocionTuristica> listarPorDescuentoMayor(double descuento);
    public List<PromocionTuristica> listarPorFechaInicio(LocalDate fechaInicio);
    public List<PromocionTuristica> listarPorNombre(String nombre);
    public List<PromocionTuristica> obtenerPorPrecioMenor(double precio);
    public List<PromocionTuristica> obtenerTodasLasPromocionesActivas();
    public List<PromocionTuristica> obtenerPorFechaFin(LocalDate fechaFin);
    public List<PromocionTuristica> obtenerPorRangoPrecio(double min, double max);
    public List<PromocionTuristica> obtenerPorDescripcion(String descripcion);
    public long contarActivosPorFecha(LocalDate fecha);
}

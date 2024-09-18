package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Promocion;
import java.time.LocalDate;
import java.util.List;
public interface IPromocionService {
    public void insert(Promocion promocion);
    public List<Promocion> list();
    public void update(Promocion promocion);
    public void delete(int idPromocion);
    public List<Promocion> listarPorDescuentoMayor(double descuento);
    public List<Promocion> listarPorFechaInicio(LocalDate fechaInicio);
    public List<Promocion> listarPorNombre(String nombre);
    public List<Promocion> obtenerPorPrecioMenor(double precio);
    public List<Promocion> obtenerTodasLasPromocionesActivas();
    public List<Promocion> obtenerPorFechaFin(LocalDate fechaFin);
    public List<Promocion> obtenerPorRangoPrecio(double min, double max);
    public List<Promocion> obtenerPorDescripcion(String descripcion);
    public long contarActivosPorFecha(LocalDate fecha);
}

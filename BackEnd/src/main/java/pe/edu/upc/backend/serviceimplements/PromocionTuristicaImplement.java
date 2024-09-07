package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.PromocionTuristica;
import pe.edu.upc.backend.repositories.IPromocionTuristicaRepository;
import pe.edu.upc.backend.serviceinterfaces.IPromocionTuristicaService;

import java.time.LocalDate;
import java.util.List;
@Service
public class PromocionTuristicaImplement implements IPromocionTuristicaService {
    @Autowired
    private IPromocionTuristicaRepository pR;
    @Override
    public void insert(PromocionTuristica promocionTuristica) { pR.save(promocionTuristica); }
    @Override
    public List<PromocionTuristica> list() { return pR.findAll(); }
    @Override
    public void update(PromocionTuristica promocionTuristica) { pR.save(promocionTuristica); }
    @Override
    public void delete(int idPromocionTuristica) { pR.deleteById(idPromocionTuristica); }
    @Override
    public List<PromocionTuristica> listarPorDescuentoMayor(double descuento) { return pR.listarPorDescuentoMayor(descuento); }
    @Override
    public List<PromocionTuristica> listarPorFechaInicio(LocalDate fechaInicio) { return pR.listarPorFechaInicio(fechaInicio); }
    @Override
    public List<PromocionTuristica> listarPorNombre(String nombre) { return pR.listarPorNombre(nombre); }
    @Override
    public List<PromocionTuristica> obtenerPorPrecioMenor(double precio) { return pR.obtenerPorPrecioMenor(precio); }
    @Override
    public List<PromocionTuristica> obtenerTodasLasPromocionesActivas() { return pR.obtenerTodasLasPromocionesActivas(); }
    @Override
    public List<PromocionTuristica> obtenerPorFechaFin(LocalDate fechaFin) { return pR.obtenerPorFechaFin(fechaFin); }
    @Override
    public List<PromocionTuristica> obtenerPorRangoPrecio(double min, double max) { return pR.obtenerPorRangoPrecio(min, max); }
    @Override
    public List<PromocionTuristica> obtenerPorDescripcion(String descripcion) { return pR.obtenerPorDescripcion(descripcion); }
    @Override
    public long contarActivosPorFecha(LocalDate fecha) { return pR.contarActivosPorFecha(fecha); }
}
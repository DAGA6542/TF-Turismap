package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.PromocionTuristica;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface IPromocionTuristicaRepository extends JpaRepository<PromocionTuristica, Integer> {
    // Obtener promociones que tienen un descuento mayor a un valor específico
    @Query("Select p from PromocionTuristica p where p.descuentoPromocion > :descuento")
    public List<PromocionTuristica> listarPorDescuentoMayor(@Param("descuento") double descuento);
    // Obtener promociones que comienzan en una fecha específica
    @Query("Select p from PromocionTuristica p where p.fechaInicioPromocion = :fechaInicio")
    public List<PromocionTuristica> listarPorFechaInicio(@Param("fechaInicio") LocalDate fechaInicio);
    // Obtener promociones cuyo nombre contiene una palabra específica
    @Query("Select p from PromocionTuristica p where p.nombrePromocion LIKE %:nombre%")
    public List<PromocionTuristica> listarPorNombre(@Param("nombre") String nombre);
    // Obtener promociones con un precio menor a un valor específico
    @Query("Select p from PromocionTuristica p where p.precioPromocion < :precio")
    public List<PromocionTuristica> obtenerPorPrecioMenor(@Param("precio") double precio);
    // Obtener todas las promociones activas
    @Query("Select p from PromocionTuristica p where current_date between p.fechaInicioPromocion and p.fechaFinPromocion")
    public List<PromocionTuristica> obtenerTodasLasPromocionesActivas();
    // Obtener promociones que terminan antes de una fecha específica
    @Query("Select p from PromocionTuristica p where p.fechaFinPromocion < :fechaFin")
    public List<PromocionTuristica> obtenerPorFechaFin(@Param("fechaFin") LocalDate fechaFin);
    // Obtener promociones que tienen un rango de precios entre dos valores
    @Query("Select p from PromocionTuristica p where p.precioPromocion between :min and :max")
    public List<PromocionTuristica> obtenerPorRangoPrecio(@Param("min") double min, @Param("max") double max);
    // Obtener promociones con una descripción que contiene una palabra específica
    @Query("Select p from PromocionTuristica p where p.descripcionPromocion like %:descripcion%")
    public List<PromocionTuristica> obtenerPorDescripcion(@Param("descripcion") String descripcion);
    // Contar cuántas promociones están activas en una fecha específica
    @Query("Select count(p) from PromocionTuristica p where :fecha between p.fechaInicioPromocion and p.fechaFinPromocion")
    public long contarActivosPorFecha(@Param("fecha") LocalDate fecha);
}
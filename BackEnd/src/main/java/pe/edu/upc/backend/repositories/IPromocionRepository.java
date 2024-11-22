package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Promocion;
import java.time.LocalDate;
import java.util.List;
@Repository
public interface IPromocionRepository extends JpaRepository<Promocion, Long> {
    // Obtener promociones que tienen un descuento mayor a un valor específico
    @Query("Select p from Promocion p where p.descuentoPromocion > :descuento")
    public List<Promocion> listarPorDescuentoMayor(@Param("descuento") double descuento);
    // Obtener promociones que comienzan en una fecha específica
    @Query("Select p from Promocion p where p.fechaInicioPromocion = :fechaInicio")
    public List<Promocion> listarPorFechaInicio(@Param("fechaInicio") LocalDate fechaInicio);
    // Obtener promociones cuyo nombre contiene una palabra específica
    @Query("Select p from Promocion p where p.nombrePromocion like %:nombre%")
    public List<Promocion> listarPorNombre(@Param("nombre") String nombre);
    // Obtener promociones con un precio menor a un valor específico
    @Query("Select p from Promocion p where p.precioPromocion < :precio")
    public List<Promocion> obtenerPorPrecioMenor(@Param("precio") double precio);
    // Obtener todas las promociones activas
    @Query("Select p from Promocion p where current_date between p.fechaInicioPromocion and p.fechaFinPromocion")
    public List<Promocion> obtenerTodasLasPromocionesActivas();
    // Obtener promociones que terminan antes de una fecha específica
    @Query("Select p from Promocion p where p.fechaFinPromocion < :fechaFin")
    public List<Promocion> obtenerPorFechaFin(@Param("fechaFin") LocalDate fechaFin);
    // Obtener promociones que tienen un rango de precios entre dos valores
    @Query("Select p from Promocion p where p.precioPromocion between :min and :max")
    public List<Promocion> obtenerPorRangoPrecio(@Param("min") double min, @Param("max") double max);
    // Obtener promociones con una descripción que contiene una palabra específica
    @Query("Select p from Promocion p where p.descripcionPromocion like %:descripcion%")
    public List<Promocion> obtenerPorDescripcion(@Param("descripcion") String descripcion);
    // Contar cuántas promociones están activas en una fecha específica
    @Query("Select count(p) from Promocion p where :fecha between p.fechaInicioPromocion and p.fechaFinPromocion")
    public long contarActivosPorFecha(@Param("fecha") LocalDate fecha);
    // Promociones activas con negocios participantes
    @Query(value = " SELECT \n" +
            " p.nombre_promocion AS promocion, \n" +
            " p.descripcion_promocion AS descripcion, \n" +
            " n.nombre_negocio AS negocio, \n" +
            " n.calificacion_negocio AS calificacionNegocio, \n" +
            " p.fecha_inicio_promocion AS inicioPromocion, \n" +
            " p.fecha_fin_promocion AS finPromocion \n" +
        " FROM \n" +
            " promocion p \n" +
        " JOIN \n" +
            " negocio n ON p.id_promocion = n.id_promocion \n" +
        " WHERE \n" +
            " p.fecha_fin_promocion >= CURRENT_DATE \n" +
        " ORDER BY \n" +
            " p.fecha_inicio_promocion ASC ", nativeQuery = true)
    public List<String[]> promocionesActivaConNegociosParticipantes();
}
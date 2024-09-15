package pe.edu.upc.backend.dtos;
import java.time.LocalDate;
public class PromocionDTO {
    private int idPromocion;
    private String nombrePromocion;
    private String descripcionPromocion;
    private double precioPromocion;
    private double descuentoPromocion;
    private LocalDate fechaInicioPromocion;
    private LocalDate fechaFinPromocion;
    public int getIdPromocion() { return idPromocion; }
    public void setIdPromocion(int idPromocion) { this.idPromocion = idPromocion; }
    public String getNombrePromocion() { return nombrePromocion; }
    public void setNombrePromocion(String nombrePromocion) { this.nombrePromocion = nombrePromocion; }
    public String getDescripcionPromocion() { return descripcionPromocion; }
    public void setDescripcionPromocion(String descripcionPromocion) { this.descripcionPromocion = descripcionPromocion; }
    public double getPrecioPromocion() { return precioPromocion; }
    public void setPrecioPromocion(double precioPromocion) { this.precioPromocion = precioPromocion; }
    public double getDescuentoPromocion() { return descuentoPromocion; }
    public void setDescuentoPromocion(double descuentoPromocion) { this.descuentoPromocion = descuentoPromocion; }
    public LocalDate getFechaInicioPromocion() { return fechaInicioPromocion; }
    public void setFechaInicioPromocion(LocalDate fechaInicioPromocion) { this.fechaInicioPromocion = fechaInicioPromocion; }
    public LocalDate getFechaFinPromocion() { return fechaFinPromocion; }
    public void setFechaFinPromocion(LocalDate fechaFinPromocion) { this.fechaFinPromocion = fechaFinPromocion; }
}
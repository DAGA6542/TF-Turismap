package pe.edu.upc.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PromocionTuristica")
public class PromocionTuristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPromocion;
    @Column(name = "nombrePromocion", nullable = false, length = 50)
    private String nombrePromocion;
    @Column(name = "descripcionPromocion", nullable = false, length = 150)
    private String descripcionPromocion;
    @Column(name = "precioPromocion", nullable = false)
    private double precioPromocion;
    @Column(name = "descuentoPromocion", nullable = false)
    private double descuentoPromocion;
    @Column(name = "fechaInicioPromocion", nullable = false)
    private LocalDate fechaInicioPromocion;
    @Column(name = "fechaFinPromocion", nullable = false)
    private LocalDate fechaFinPromocion;

    public PromocionTuristica() {
    }

    public PromocionTuristica(int idPromocion, String nombrePromocion, String descripcionPromocion, double precioPromocion, double descuentoPromocion, LocalDate fechaInicioPromocion, LocalDate fechaFinPromocion) {
        this.idPromocion = idPromocion;
        this.nombrePromocion = nombrePromocion;
        this.descripcionPromocion = descripcionPromocion;
        this.precioPromocion = precioPromocion;
        this.descuentoPromocion = descuentoPromocion;
        this.fechaInicioPromocion = fechaInicioPromocion;
        this.fechaFinPromocion = fechaFinPromocion;

    }

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
    }

    public String getDescripcionPromocion() {
        return descripcionPromocion;
    }

    public void setDescripcionPromocion(String descripcionPromocion) {
        this.descripcionPromocion = descripcionPromocion;
    }

    public double getPrecioPromocion() {
        return precioPromocion;
    }

    public void setPrecioPromocion(double precioPromocion) {
        this.precioPromocion = precioPromocion;
    }

    public double getDescuentoPromocion() {
        return descuentoPromocion;
    }

    public void setDescuentoPromocion(double descuentoPromocion) {
        this.descuentoPromocion = descuentoPromocion;
    }

    public LocalDate getFechaInicioPromocion() {
        return fechaInicioPromocion;
    }

    public void setFechaInicioPromocion(LocalDate fechaInicioPromocion) {
        this.fechaInicioPromocion = fechaInicioPromocion;
    }

    public LocalDate getFechaFinPromocion() {
        return fechaFinPromocion;
    }

    public void setFechaFinPromocion(LocalDate fechaFinPromocion) {
        this.fechaFinPromocion = fechaFinPromocion;
    }
}
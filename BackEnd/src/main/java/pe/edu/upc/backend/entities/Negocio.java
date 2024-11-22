package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "Negocio")
public class Negocio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNegocio;
    @Column(name = "nombreNegocio", nullable = false, length = 80)
    private String nombreNegocio;
    @Column(name = "horarioNegocio", nullable = false, length = 60)
    private String horarioNegocio;
    @Column(name = "latitudNegocio", nullable = false)
    private double latitudNegocio;
    @Column(name = "longitudNegocio", nullable = false)
    private double longitudNegocio;
    @Column(name = "numeroTelefonoNegocio", nullable = false)
    private int numeroTelefonoNegocio;
    @Column(name = "calificacionNegocio", nullable = false)
    private int calificacionNegocio;
    @Column(name = "descripcionNegocio", nullable = false, length = 250)
    private String descripcionNegocio;
    @Column(name = "reservaNegocio", nullable = false)
    private Boolean reservaNegocio;
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad idCiudad;
    @ManyToOne
    @JoinColumn(name = "idPromocion")
    private Promocion idPromocion;
    public Negocio() {}
    public Negocio(Long idNegocio, String nombreNegocio, String horarioNegocio, double latitudNegocio, double longitudNegocio, int numeroTelefonoNegocio, int calificacionNegocio, String descripcionNegocio, Boolean reservaNegocio, Ciudad idCiudad, Promocion idPromocion) {
        this.idNegocio = idNegocio;
        this.nombreNegocio = nombreNegocio;
        this.horarioNegocio = horarioNegocio;
        this.latitudNegocio = latitudNegocio;
        this.longitudNegocio = longitudNegocio;
        this.numeroTelefonoNegocio = numeroTelefonoNegocio;
        this.calificacionNegocio = calificacionNegocio;
        this.descripcionNegocio = descripcionNegocio;
        this.reservaNegocio = reservaNegocio;
        this.idCiudad = idCiudad;
        this.idPromocion = idPromocion;
    }
    public Long getIdNegocio() {
        return idNegocio;
    }
    public void setIdNegocio(Long idNegocio) {
        this.idNegocio = idNegocio;
    }
    public String getNombreNegocio() {
        return nombreNegocio;
    }
    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }
    public String getHorarioNegocio() {
        return horarioNegocio;
    }
    public void setHorarioNegocio(String horarioNegocio) {
        this.horarioNegocio = horarioNegocio;
    }
    public double getLatitudNegocio() {
        return latitudNegocio;
    }
    public void setLatitudNegocio(double latitudNegocio) {
        this.latitudNegocio = latitudNegocio;
    }
    public double getLongitudNegocio() {
        return longitudNegocio;
    }
    public void setLongitudNegocio(double longitudNegocio) {
        this.longitudNegocio = longitudNegocio;
    }
    public int getNumeroTelefonoNegocio() {
        return numeroTelefonoNegocio;
    }
    public void setNumeroTelefonoNegocio(int numeroTelefonoNegocio) { this.numeroTelefonoNegocio = numeroTelefonoNegocio; }
    public int getCalificacionNegocio() {
        return calificacionNegocio;
    }
    public void setCalificacionNegocio(int calificacionNegocio) {
        this.calificacionNegocio = calificacionNegocio;
    }
    public String getDescripcionNegocio() {
        return descripcionNegocio;
    }
    public void setDescripcionNegocio(String descripcionNegocio) {
        this.descripcionNegocio = descripcionNegocio;
    }
    public Boolean getReservaNegocio() {
        return reservaNegocio;
    }
    public void setReservaNegocio(Boolean reservaNegocio) {
        this.reservaNegocio = reservaNegocio;
    }
    public Ciudad getIdCiudad() {
        return idCiudad;
    }
    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }
    public Promocion getIdPromocion() {
        return idPromocion;
    }
    public void setIdPromocion(Promocion idPromocion) {
        this.idPromocion = idPromocion;
    }
}
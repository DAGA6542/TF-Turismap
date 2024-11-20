package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Ciudad;
import pe.edu.upc.backend.entities.Promocion;
public class NegocioDTO {
    private Long idNegocio;
    private String nombreNegocio;
    private double latitudNegocio;
    private double longitudNegocio;
    private String horarioNegocio;
    private int numeroTelefonoNegocio;
    private int calificacionNegocio;
    private String descripcionNegocio;
    private Boolean reservaNegocio;
    private Ciudad idCiudad;
    private Promocion idPromocion;
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

    public String getHorarioNegocio() {
        return horarioNegocio;
    }
    public void setHorarioNegocio(String horarioNegocio) {
        this.horarioNegocio = horarioNegocio;
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
    public Ciudad getIdCiudad() {
        return idCiudad;
    }
    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }
    public String getDescripcionNegocio() { return descripcionNegocio; }
    public void setDescripcionNegocio(String descripcionNegocio) { this.descripcionNegocio = descripcionNegocio; }
    public Boolean getReservaNegocio() { return reservaNegocio; }
    public void setReservaNegocio(Boolean reservaNegocio) { this.reservaNegocio = reservaNegocio; }
    public Promocion getIdPromocion() { return idPromocion; }
    public void setIdPromocion(Promocion idPromocion) { this.idPromocion = idPromocion; }
}
package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Ciudad;
import pe.edu.upc.backend.entities.Promocion;
public class NegocioDTO {
    private int idNegocio;
    private String nombreNegocio;
    private String horarioNegocio;
    private int numeroTelefonoNegocio;
    private int calificacionNegocio;
    private String descripcionNegocio;
    private Boolean reservaNegocio;
    private Ciudad idCiudad;
    private Promocion idPromocion;
    public int getIdNegocio() {
        return idNegocio;
    }
    public void setIdNegocio(int idNegocio) {
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
    public void setReservaNegocio(Boolean reservadoNegocio) { this.reservaNegocio = reservadoNegocio; }
    public Promocion getIdPromocion() { return idPromocion; }
    public void setIdPromocion(Promocion idPromocion) { this.idPromocion = idPromocion; }
}
package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "Negocio")
public class Negocio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNegocio;
    @Column(name = "nombreNegocio", nullable = false, length = 50)
    private String nombreNegocio;
    @Column(name = "horarioNegocio", nullable = false, length = 20)
    private String horarioNegocio;
    @Column(name = "numeroTelefonoNegocio", nullable = false)
    private int numeroTelefonoNegocio;
    @Column(name = "calificacionNegocio", nullable = false)
    private int calificacionNegocio;
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad idCiudad;
    public Negocio() {}
    public Negocio(int idNegocio, String nombreNegocio, String horarioNegocio, int numeroTelefonoNegocio, int calificacionNegocio, Ciudad idCiudad) {
        this.idNegocio = idNegocio;
        this.nombreNegocio = nombreNegocio;
        this.horarioNegocio = horarioNegocio;
        this.numeroTelefonoNegocio = numeroTelefonoNegocio;
        this.calificacionNegocio = calificacionNegocio;
        this.idCiudad = idCiudad;
    }
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
}
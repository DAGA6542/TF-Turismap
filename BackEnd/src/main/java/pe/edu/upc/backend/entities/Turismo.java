package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "Turismo")
public class Turismo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurismo;
    @Column(name = "nombreTurismo", nullable = false, length = 50)
    private String nombreTurismo;
    @Column(name = "descripcionTurimos", nullable = false, length = 50)
    private String descripcionTurismo;
    @Column(name = "numeroTelefonoTurismo", nullable = false)
    private int numeroTelefonoTurismo;
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad idCiudad;
    @ManyToOne
    @JoinColumn(name = "idPromocion")
    private PromocionTuristica idPromocion;
    public Turismo() {}
    public Turismo(int idTurismo, String nombreTurismo, String descripcionTurismo, int numeroTelefonoTurismo, Ciudad idCiudad, PromocionTuristica idPromocion) {
        this.idTurismo = idTurismo;
        this.nombreTurismo = nombreTurismo;
        this.descripcionTurismo = descripcionTurismo;
        this.numeroTelefonoTurismo = numeroTelefonoTurismo;
        this.idCiudad = idCiudad;
        this.idPromocion = idPromocion;
    }
    public int getIdTurismo() {
        return idTurismo;
    }
    public void setIdTurismo(int idTurismo) {
        this.idTurismo = idTurismo;
    }
    public String getNombreTurismo() {
        return nombreTurismo;
    }
    public void setNombreTurismo(String nombreTurismo) {
        this.nombreTurismo = nombreTurismo;
    }
    public String getDescripcionTurismo() {
        return descripcionTurismo;
    }
    public void setDescripcionTurismo(String descripcionTurismo) {
        this.descripcionTurismo = descripcionTurismo;
    }
    public int getNumeroTelefonoTurismo() {
        return numeroTelefonoTurismo;
    }
    public void setNumeroTelefonoTurismo(int numeroTelefonoTurismo) { this.numeroTelefonoTurismo = numeroTelefonoTurismo; }
    public Ciudad getIdCiudad() {
        return idCiudad;
    }
    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }
    public PromocionTuristica getIdPromocion() {
        return idPromocion;
    }
    public void setIdPromocion(PromocionTuristica idPromocion) {
        this.idPromocion = idPromocion;
    }
}
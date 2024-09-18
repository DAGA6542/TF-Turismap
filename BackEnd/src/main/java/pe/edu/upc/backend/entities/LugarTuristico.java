package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "LugarTuristico")
public class LugarTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLugarTuristico;
    @Column(name = "nombreLugarTuristico", nullable = false, length = 70)
    private String nombreLugarTuristico;
    @Column(name = "descripcionLugarTuristico", nullable = false, length = 250)
    private String descripcionLugarTuristico;
    @Column(name = "numeroTelefonoLugar", nullable = false)
    private int numeroLugarTuristico;
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad idCiudad;
    public LugarTuristico() {}
    public LugarTuristico(int idLugarTuristico, String nombreLugarTuristico, String descripcionLugarTuristico, int numeroLugarTuristico) {
        this.idLugarTuristico = idLugarTuristico;
        this.nombreLugarTuristico = nombreLugarTuristico;
        this.descripcionLugarTuristico = descripcionLugarTuristico;
        this.numeroLugarTuristico = numeroLugarTuristico;
    }
    public LugarTuristico(int idLugarTuristico, String nombreLugarTuristico, String descripcionLugarTuristico, int numeroLugarTuristico, Ciudad idCiudad) {
        this.idLugarTuristico = idLugarTuristico;
        this.nombreLugarTuristico = nombreLugarTuristico;
        this.descripcionLugarTuristico = descripcionLugarTuristico;
        this.numeroLugarTuristico = numeroLugarTuristico;
        this.idCiudad = idCiudad;
    }
    public int getIdLugarTuristico() { return idLugarTuristico; }
    public void setIdLugarTuristico(int idLugarTuristico) { this.idLugarTuristico = idLugarTuristico; }
    public String getNombreLugarTuristico() { return nombreLugarTuristico; }
    public void setNombreLugarTuristico(String nombreLugarTuristico) { this.nombreLugarTuristico = nombreLugarTuristico; }
    public String getDescripcionLugarTuristico() { return descripcionLugarTuristico; }
    public void setDescripcionLugarTuristico(String descripcionLugarTuristico) { this.descripcionLugarTuristico = descripcionLugarTuristico; }
    public int getNumeroLugarTuristico() { return numeroLugarTuristico; }
    public void setNumeroLugarTuristico(int numeroLugarTuristico) { this.numeroLugarTuristico = numeroLugarTuristico; }
    public Ciudad getIdCiudad() { return idCiudad; }
    public void setIdCiudad(Ciudad idCiudad) { this.idCiudad = idCiudad; }
}
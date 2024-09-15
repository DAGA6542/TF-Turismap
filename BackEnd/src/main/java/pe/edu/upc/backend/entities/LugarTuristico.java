package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "LugarTuristico")
public class LugarTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLugar;
    @Column(name = "nombreLugar", nullable = false, length = 50)
    private String nombreLugar;
    @Column(name = "descripcionLugar", nullable = false, length = 50)
    private String descripcionLugar;
    @Column(name = "numeroTelefonoLugar", nullable = false)
    private int numeroTelefonoLugar;
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad idCiudad;
    public LugarTuristico() {}
    public LugarTuristico(int idLugar, String nombreLugar, String descripcionLugar, int numeroTelefonoLugar, Ciudad idCiudad) {
        this.idLugar = idLugar;
        this.nombreLugar = nombreLugar;
        this.descripcionLugar = descripcionLugar;
        this.numeroTelefonoLugar = numeroTelefonoLugar;
        this.idCiudad = idCiudad;
    }
    public int getIdLugar() { return idLugar; }
    public void setIdLugar(int idLugar) { this.idLugar = idLugar; }
    public String getNombreLugar() { return nombreLugar; }
    public void setNombreLugar(String nombreLugar) { this.nombreLugar = nombreLugar; }
    public String getDescripcionLugar() { return descripcionLugar; }
    public void setDescripcionLugar(String descripcionLugar) { this.descripcionLugar = descripcionLugar; }
    public int getNumeroTelefonoLugar() { return numeroTelefonoLugar; }
    public void setNumeroTelefonoLugar(int numeroTelefonoLugar) { this.numeroTelefonoLugar = numeroTelefonoLugar; }
    public Ciudad getIdCiudad() { return idCiudad; }
    public void setIdCiudad(Ciudad idCiudad) { this.idCiudad = idCiudad; }
}
package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "LugarTuristico")
public class LugarTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLugar;
    @Column(name = "nombreLugar", nullable = false, length = 70)
    private String nombreLugar;
    @Column(name = "descripcionLugar", nullable = false, length = 250)
    private String descripcionLugar;
    @Column(name = "numeroLugar", nullable = false)
    private int numeroLugar;
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad idCiudad;
    public LugarTuristico() {}
    public LugarTuristico(Long idLugar, String nombreLugar, String descripcionLugar, int numeroLugar, Ciudad idCiudad) {
        this.idLugar = idLugar;
        this.nombreLugar = nombreLugar;
        this.descripcionLugar = descripcionLugar;
        this.numeroLugar = numeroLugar;
        this.idCiudad = idCiudad;
    }
    public Long getIdLugar() { return idLugar; }
    public void setIdLugar(Long idLugar) { this.idLugar = idLugar; }
    public String getNombreLugar() { return nombreLugar; }
    public void setNombreLugar(String nombreLugar) { this.nombreLugar = nombreLugar; }
    public String getDescripcionLugar() { return descripcionLugar; }
    public void setDescripcionLugar(String descripcionLugar) { this.descripcionLugar = descripcionLugar; }
    public int getNumeroLugar() { return numeroLugar; }
    public void setNumeroLugar(int numeroLugar) { this.numeroLugar = numeroLugar; }
    public Ciudad getIdCiudad() { return idCiudad; }
    public void setIdCiudad(Ciudad idCiudad) { this.idCiudad = idCiudad; }
}
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
    @Column(name = "latitudLugar", nullable = false)
    private double latitudLugar;
    @Column(name = "longitudLugar", nullable = false)
    private double longitudLugar;
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad idCiudad;
    public LugarTuristico() {}
    public LugarTuristico(Long idLugar, String nombreLugar, String descripcionLugar, int numeroLugar, double latitudLugar, double longitudLugar, Ciudad idCiudad) {
        this.idLugar = idLugar;
        this.nombreLugar = nombreLugar;
        this.descripcionLugar = descripcionLugar;
        this.numeroLugar = numeroLugar;
        this.latitudLugar = latitudLugar;
        this.longitudLugar = longitudLugar;
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
    public double getLatitudLugar() { return latitudLugar; }
    public void setLatitudLugar(double latitudLugar) { this.latitudLugar = latitudLugar; }
    public double getLongitudLugar() { return longitudLugar; }
    public void setLongitudLugar(double longitudLugar) { this.longitudLugar = longitudLugar; }
    public Ciudad getIdCiudad() { return idCiudad; }
    public void setIdCiudad(Ciudad idCiudad) { this.idCiudad = idCiudad; }
}
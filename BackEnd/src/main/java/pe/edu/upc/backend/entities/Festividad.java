package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Festividad")
public class Festividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFestividad;
    @Column(name = "nombreFestividad", nullable = false, length = 60)
    private String nombreFestividad;
    @Column(name = "descripcionFestividad", nullable = false, length = 250)
    private String descripcionFestividad;
    @Column(name = "fechaFestividad", nullable = false)
    private LocalDate fechaFestividad;
    @ManyToOne
    @JoinColumn(name = "idLugarTuristico")
    private LugarTuristico idLugarTuristico;
    public Festividad() {}
    public Festividad(int idFestividad, String nombreFestividad, String descripcionFestividad, LocalDate fechaFestividad) {
        this.idFestividad = idFestividad;
        this.nombreFestividad = nombreFestividad;
        this.descripcionFestividad = descripcionFestividad;
        this.fechaFestividad = fechaFestividad;
    }
    public Festividad(int idFestividad, String nombreFestividad, String descripcionFestividad, LocalDate fechaFestividad, LugarTuristico idLugarTuristico) {
        this.idFestividad = idFestividad;
        this.nombreFestividad = nombreFestividad;
        this.descripcionFestividad = descripcionFestividad;
        this.fechaFestividad = fechaFestividad;
        this.idLugarTuristico = idLugarTuristico;
    }
    public int getIdFestividades() { return idFestividad; }
    public void setIdFestividades(int idFestividad) { this.idFestividad = idFestividad; }
    public String getNombreFestividad() { return nombreFestividad; }
    public void setNombreFestividad(String nombreFestividad) { this.nombreFestividad = nombreFestividad; }
    public String getDescripcionFestividad() { return descripcionFestividad; }
    public void setDescripcionFestividad(String descripcionFestividad) { this.descripcionFestividad = descripcionFestividad; }
    public LocalDate getFechaFestividad() { return fechaFestividad; }
    public void setFechaFestividad(LocalDate fechaFestividad) { this.fechaFestividad = fechaFestividad; }
    public LugarTuristico getIdLugarTuristico() { return idLugarTuristico; }
    public void setIdLugarTuristico(LugarTuristico idLugarTuristico) { this.idLugarTuristico = idLugarTuristico; }
}
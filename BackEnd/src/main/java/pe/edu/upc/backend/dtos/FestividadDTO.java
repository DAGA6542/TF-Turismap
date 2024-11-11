package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.LugarTuristico;
import java.time.LocalDate;
public class FestividadDTO {
    private int idFestividad;
    private String nombreFestividad;
    private String descripcionFestividad;
    private LocalDate fechaFestividad;
    private LugarTuristico idLugarTuristico;
    public int getIdFestividad() { return idFestividad; }
    public void setIdFestividad(int idFestividad) { this.idFestividad = idFestividad; }
    public String getNombreFestividad() { return nombreFestividad; }
    public void setNombreFestividad(String nombreFestividad) { this.nombreFestividad = nombreFestividad; }
    public String getDescripcionFestividad() { return descripcionFestividad; }
    public void setDescripcionFestividad(String descripcionFestividad) { this.descripcionFestividad = descripcionFestividad; }
    public LocalDate getFechaFestividad() { return fechaFestividad; }
    public void setFechaFestividad(LocalDate fechaFestividad) { this.fechaFestividad = fechaFestividad; }
    public LugarTuristico getIdLugarTuristico() { return idLugarTuristico; }
    public void setIdLugarTuristico(LugarTuristico idLugarTuristico) { this.idLugarTuristico = idLugarTuristico; }
}
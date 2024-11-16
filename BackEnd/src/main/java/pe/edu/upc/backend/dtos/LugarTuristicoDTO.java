package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Ciudad;
public class LugarTuristicoDTO {
    private Long idLugar;
    private String nombreLugar;
    private String descripcionLugar;
    private int numeroLugar;
    private Ciudad idCiudad;
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
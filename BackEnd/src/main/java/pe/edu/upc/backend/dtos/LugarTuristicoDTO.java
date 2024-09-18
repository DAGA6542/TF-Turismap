package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Ciudad;
public class LugarTuristicoDTO {
    private int idLugar;
    private String nombreLugar;
    private String descripcionLugar;
    private int numeroTelefonoLugar;
    private Ciudad idCiudad;
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
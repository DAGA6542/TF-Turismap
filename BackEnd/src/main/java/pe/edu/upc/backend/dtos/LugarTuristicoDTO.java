package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Ciudad;
public class LugarTuristicoDTO {
    private Long idLugar;
    private String nombreLugar;
    private String descripcionLugar;
    private double latitudLugar;
    private double longitudLugar;
    private int numeroLugar;
    private Ciudad idCiudad;
    public Long getIdLugar() { return idLugar; }
    public void setIdLugar(Long idLugar) { this.idLugar = idLugar; }
    public String getNombreLugar() { return nombreLugar; }
    public void setNombreLugar(String nombreLugar) { this.nombreLugar = nombreLugar; }
    public String getDescripcionLugar() { return descripcionLugar; }

    public double getLatitudLugar() {
        return latitudLugar;
    }

    public void setLatitudLugar(double latitudLugar) {
        this.latitudLugar = latitudLugar;
    }

    public double getLongitudLugar() {
        return longitudLugar;
    }

    public void setLongitudLugar(double longitudLugar) {
        this.longitudLugar = longitudLugar;
    }

    public void setDescripcionLugar(String descripcionLugar) { this.descripcionLugar = descripcionLugar; }
    public int getNumeroLugar() { return numeroLugar; }
    public void setNumeroLugar(int numeroLugar) { this.numeroLugar = numeroLugar; }
    public Ciudad getIdCiudad() { return idCiudad; }
    public void setIdCiudad(Ciudad idCiudad) { this.idCiudad = idCiudad; }
}
package pe.edu.upc.backend.dtos;

public class FestividadPorLugarTuristicoDTO {
    private String nombreLugar;
    private String nombreFestividad;
    public String nombreLugar() {
        return nombreLugar;
    }
    public void nombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }
    public String nombreFestividad() {
        return nombreFestividad;
    }
    public void nombreFestividad(String nombreFestividad) {
        this.nombreFestividad = nombreFestividad;
    }

}

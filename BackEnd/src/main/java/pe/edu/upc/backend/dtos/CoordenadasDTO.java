package pe.edu.upc.backend.dtos;

public class CoordenadasDTO {
    public String nombreLugar;
    public double latitudLugar;
    public double longitudLugar;

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

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


}

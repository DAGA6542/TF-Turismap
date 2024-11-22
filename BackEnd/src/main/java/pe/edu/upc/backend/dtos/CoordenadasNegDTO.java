package pe.edu.upc.backend.dtos;

public class CoordenadasNegDTO {
    public String nombreNegocio;
    public double latitudNegocio;
    public double longitudNegocio;

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public double getLatitudNegocio() {
        return latitudNegocio;
    }

    public void setLatitudNegocio(double latitudNegocio) {
        this.latitudNegocio = latitudNegocio;
    }

    public double getLongitudNegocio() {
        return longitudNegocio;
    }

    public void setLongitudNegocio(double longitudNegocio) {
        this.longitudNegocio = longitudNegocio;
    }
}

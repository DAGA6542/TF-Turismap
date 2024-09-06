package pe.edu.upc.backend.dtos;

public class CantidadTurismoxCiudadDTO {
    public String nombreCiudad;
    public int cantidadTurismoxCiudad;

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public int getCantidadTurismoxCiudad() {
        return cantidadTurismoxCiudad;
    }

    public void setCantidadTurismoxCiudad(int cantidadTurismoxCiudad) {
        this.cantidadTurismoxCiudad = cantidadTurismoxCiudad;
    }
}

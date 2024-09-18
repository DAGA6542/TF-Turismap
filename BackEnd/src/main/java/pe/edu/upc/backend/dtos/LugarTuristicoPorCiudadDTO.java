package pe.edu.upc.backend.dtos;

public class LugarTuristicoPorCiudadDTO {
    private String nombreCiudad;
    private String nombreTurismo;

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombreTurismo() {
        return nombreTurismo;
    }

    public void setNombreTurismo(String nombreTurismo) {
        this.nombreTurismo = nombreTurismo;
    }
}

package pe.edu.upc.backend.dtos;
public class CalifacionPromedioPorCiudadDTO {
    private String ciudad;
    private double calificacionPromedio;
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public double getCalificacionPromedio() { return calificacionPromedio; }
    public void setCalificacionPromedio(double calificacionPromedio) { this.calificacionPromedio = calificacionPromedio; }
}
package pe.edu.upc.backend.dtos;
public class NegocioPopularCalificaDTO {
    private String negocio;
    private String ciudad;
    private double calificacion;
    private int totalComentarios;
    public String getNegocio() { return negocio; }
    public void setNegocio(String negocio) { this.negocio = negocio; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public double getCalificacion() { return calificacion; }
    public void setCalificacion(double calificacion) { this.calificacion = calificacion; }
    public int getTotalComentarios() { return totalComentarios; }
    public void setTotalComentarios(int totalComentarios) { this.totalComentarios = totalComentarios; }
}
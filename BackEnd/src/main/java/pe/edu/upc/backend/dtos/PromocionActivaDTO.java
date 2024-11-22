package pe.edu.upc.backend.dtos;
public class PromocionActivaDTO {
    private String promocion;
    private String descripcion;
    private String negocio;
    private double calificacionNegocio;
    private String inicioPromocion;
    private String finPromocion;
    public String getPromocion() { return promocion; }
    public void setPromocion(String promocion) { this.promocion = promocion; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getNegocio() { return negocio; }
    public void setNegocio(String negocio) { this.negocio = negocio; }
    public double getCalificacionNegocio() { return calificacionNegocio; }
    public void setCalificacionNegocio(double calificacionNegocio) { this.calificacionNegocio = calificacionNegocio; }
    public String getInicioPromocion() { return inicioPromocion; }
    public void setInicioPromocion(String inicioPromocion) { this.inicioPromocion = inicioPromocion; }
    public String getFinPromocion() { return finPromocion; }
    public void setFinPromocion(String finPromocion) { this.finPromocion = finPromocion; }
}

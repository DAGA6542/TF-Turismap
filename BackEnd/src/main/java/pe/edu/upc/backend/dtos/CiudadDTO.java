package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Departamento;
public class CiudadDTO {
    private int idCiudad;
    private String nombreCiudad;
    private Long poblacionCiudad;
    private int superficieCiudad;
    private double latitudCiudad;
    private double longitudCiudad;
    private int codigoPostalCiudad;
    private Departamento idDepartamento;
    public int getIdCiudad() { return idCiudad; }
    public void setIdCiudad(int idCiudad) { this.idCiudad = idCiudad; }
    public String getNombreCiudad() { return nombreCiudad; }
    public void setNombreCiudad(String nombreCiudad) { this.nombreCiudad = nombreCiudad; }
    public Long getPoblacionCiudad() { return poblacionCiudad; }
    public void setPoblacionCiudad(Long poblacionCiudad) { this.poblacionCiudad = poblacionCiudad; }
    public int getSuperficieCiudad() { return superficieCiudad; }
    public void setSuperficieCiudad(int superficieCiudad) { this.superficieCiudad = superficieCiudad; }
    public double getLatitudCiudad() { return latitudCiudad; }
    public void setLatitudCiudad(double latitudCiudad) { this.latitudCiudad = latitudCiudad; }
    public double getLongitudCiudad() { return longitudCiudad; }
    public void setLongitudCiudad(double longitudCiudad) { this.longitudCiudad = longitudCiudad; }
    public int getCodigoPostalCiudad() { return codigoPostalCiudad; }
    public void setCodigoPostalCiudad(int codigoPostalCiudad) { this.codigoPostalCiudad = codigoPostalCiudad; }
    public Departamento getIdDepartamento() { return idDepartamento; }
    public void setIdDepartamento(Departamento idDepartamento) { this.idDepartamento = idDepartamento; }
}
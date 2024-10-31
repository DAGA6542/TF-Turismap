package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Pais;
public class DepartamentoDTO {
    private int idDepartamento;
    private String nombreDepartamento;
    private String capitalDepartamento;
    private Long poblacionDepartamento;
    private int superficieDepartamento;
    private Pais idPais;
    public int getIdDepartamento() {
        return idDepartamento;
    }
    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    public String getCapitalDepartamento() {
        return capitalDepartamento;
    }
    public void setCapitalDepartamento(String capitalDepartamento) {
        this.capitalDepartamento = capitalDepartamento;
    }
    public Long getPoblacionDepartamento() {
        return poblacionDepartamento;
    }
    public void setPoblacionDepartamento(Long poblacionDepartamento) { this.poblacionDepartamento = poblacionDepartamento; }
    public int getSuperficieDepartamento() {
        return superficieDepartamento;
    }
    public void setSuperficieDepartamento(int superficieDepartamento) { this.superficieDepartamento = superficieDepartamento; }
    public Pais getIdPais() { return idPais; }
    public void setIdPais(Pais idPais) { this.idPais = idPais; }
}
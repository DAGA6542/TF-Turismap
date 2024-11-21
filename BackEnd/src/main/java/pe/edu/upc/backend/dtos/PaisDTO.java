package pe.edu.upc.backend.dtos;
public class PaisDTO {
    private Long idPais;
    private String nombrePais;
    private String codigoIsoPais;
    private String continentePais;
    private String capitalPais;
    private String monedaPais;
    private String idiomaOficialPais;
    private Long poblacionPais;
    private Long superficiePais;
    public Long getIdPais() {
        return idPais;
    }
    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
    public String getNombrePais() {
        return nombrePais;
    }
    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    public String getCodigoIsoPais() {
        return codigoIsoPais;
    }
    public void setCodigoIsoPais(String codigoIsoPais) {
        this.codigoIsoPais = codigoIsoPais;
    }
    public String getContinentePais() {
        return continentePais;
    }
    public void setContinentePais(String continentePais) {
        this.continentePais = continentePais;
    }
    public String getCapitalPais() {
        return capitalPais;
    }
    public void setCapitalPais(String capitalPais) {
        this.capitalPais = capitalPais;
    }
    public String getMonedaPais() {
        return monedaPais;
    }
    public void setMonedaPais(String monedaPais) {
        this.monedaPais = monedaPais;
    }
    public String getIdiomaOficialPais() {
        return idiomaOficialPais;
    }
    public void setIdiomaOficialPais(String idiomaOficialPais) {
        this.idiomaOficialPais = idiomaOficialPais;
    }
    public Long getPoblacionPais() {
        return poblacionPais;
    }
    public void setPoblacionPais(Long poblacionPais) {
        this.poblacionPais = poblacionPais;
    }
    public Long getSuperficiePais() { return superficiePais; }
    public void setSuperficiePais(Long superficiePais) { this.superficiePais = superficiePais; }
}

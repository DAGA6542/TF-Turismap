package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "Pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;
    @Column(name = "nombrePais", nullable = false, length = 60)
    private String nombrePais;
    @Column(name = "codigoIsoPais", nullable = false, length = 5)
    private String codigoIsoPais;
    @Column(name = "continentePais", nullable = false, length = 50)
    private String continentePais;
    @Column(name = "capitalPais", nullable = false, length = 50)
    private String capitalPais;
    @Column(name = "monedaPais", nullable = false, length = 50)
    private String monedaPais;
    @Column(name = "idiomaOficialPais", nullable = false, length = 40)
    private String idiomaOficialPais;
    @Column(name = "poblacionPais", nullable = false)
    private Long poblacionPais;
    @Column(name = "superficiePais", nullable = false)
    private Long superficiePais;
    public Pais() {}
    public Pais(Long idPais, String nombrePais, String codigoIsoPais, String continentePais, String capitalPais, String monedaPais, String idiomaOficialPais, Long poblacionPais, Long superficiePais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
        this.codigoIsoPais = codigoIsoPais;
        this.continentePais = continentePais;
        this.capitalPais = capitalPais;
        this.monedaPais = monedaPais;
        this.idiomaOficialPais = idiomaOficialPais;
        this.poblacionPais = poblacionPais;
        this.superficiePais = superficiePais;
    }
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
    public void setMonedaPais(String monedaPais) { this.monedaPais = monedaPais; }
    public String getIdiomaOficialPais() { return idiomaOficialPais; }
    public void setIdiomaOficialPais(String idiomaOficialPais) { this.idiomaOficialPais = idiomaOficialPais; }
    public Long getPoblacionPais() {
        return poblacionPais;
    }
    public void setPoblacionPais(Long poblacionPais) { this.poblacionPais = poblacionPais; }
    public Long getSuperficiePais() {
        return superficiePais;
    }
    public void setSuperficiePais(Long superficiePais) {
        this.superficiePais = superficiePais;
    }
}
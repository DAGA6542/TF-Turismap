package pe.edu.upc.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepartamento;
    @Column(name = "nombreDepartamento", nullable = false, length = 50)
    private String nombreDepartamento;
    @Column(name = "capitalDepartamento", nullable = false, length = 40)
    private String capitalDepartamento;
    @Column(name = "poblacionDepartamento", nullable = false)
    private Long poblacionDepartamento;
    @Column(name = "superficieDepartamento", nullable = false)
    private int superficieDepartamento;
    @ManyToOne
    @JoinColumn(name = "idPais")
    private Pais idPais;

    public Departamento() {
    }

    public Departamento(int idDepartamento, String nombreDepartamento, String capitalDepartamento, Long poblacionDepartamento, int superficieDepartamento, Pais idPais) {
        this.idDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.capitalDepartamento = capitalDepartamento;
        this.poblacionDepartamento = poblacionDepartamento;
        this.superficieDepartamento = superficieDepartamento;
        this.idPais = idPais;
    }

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

    public void setPoblacionDepartamento(Long poblacionDepartamento) {
        this.poblacionDepartamento = poblacionDepartamento;
    }

    public int getSuperficieDepartamento() {
        return superficieDepartamento;
    }

    public void setSuperficieDepartamento(int superficieDepartamento) {
        this.superficieDepartamento = superficieDepartamento;
    }

    public Pais getIdPaid() {
        return idPais;
    }

    public void setIdPaid(Pais idPaid) {
        this.idPais = idPaid;
    }
}

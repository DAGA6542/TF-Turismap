package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "Ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudad;
    @Column(name = "nombreCiudad", nullable = false, length = 70)
    private String nombreCiudad;
    @Column(name = "poblacionCiudad", nullable = false)
    private Long poblacionCiudad;
    @Column(name = "superficieCiudad", nullable = false)
    private int superficieCiudad;

    @Column(name = "codigoPostalCiudad", nullable = false)
    private int codigoPostalCiudad;
    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento idDepartamento;
    public Ciudad() {}

    public Ciudad(Long idCiudad, String nombreCiudad, Long poblacionCiudad, int superficieCiudad, int codigoPostalCiudad, Departamento idDepartamento) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.poblacionCiudad = poblacionCiudad;
        this.superficieCiudad = superficieCiudad;
        this.codigoPostalCiudad = codigoPostalCiudad;
        this.idDepartamento = idDepartamento;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Long getPoblacionCiudad() {
        return poblacionCiudad;
    }

    public void setPoblacionCiudad(Long poblacionCiudad) {
        this.poblacionCiudad = poblacionCiudad;
    }

    public int getSuperficieCiudad() {
        return superficieCiudad;
    }

    public void setSuperficieCiudad(int superficieCiudad) {
        this.superficieCiudad = superficieCiudad;
    }

    public int getCodigoPostalCiudad() {
        return codigoPostalCiudad;
    }

    public void setCodigoPostalCiudad(int codigoPostalCiudad) {
        this.codigoPostalCiudad = codigoPostalCiudad;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
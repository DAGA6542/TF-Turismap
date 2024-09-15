package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "Ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCiudad;
    @Column(name = "nombreCiudad", nullable = false, length = 50)
    private String nombreCiudad;
    @Column(name = "poblacionCiudad", nullable = false)
    private Long poblacionCiudad;
    @Column(name = "superficieCiudad", nullable = false)
    private int superficieCiudad;
    @Column(name = "latitudCiudad", nullable = false)
    private double latitudCiudad;
    @Column(name = "longitudCiudad", nullable = false)
    private double longitudCiudad;
    @Column(name = "codigoPostalCiudad", nullable = false)
    private int codigoPostalCiudad;
    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento idDepartamento;
    public Ciudad() {}
    public Ciudad(int idCiudad, String nombreCiudad, Long poblacionCiudad, int superficieCiudad, double latitudCiudad, double longitudCiudad, int codigoPostalCiudad, Departamento idDepartamento) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.poblacionCiudad = poblacionCiudad;
        this.superficieCiudad = superficieCiudad;
        this.latitudCiudad = latitudCiudad;
        this.longitudCiudad = longitudCiudad;
        this.codigoPostalCiudad = codigoPostalCiudad;
        this.idDepartamento = idDepartamento;
    }
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
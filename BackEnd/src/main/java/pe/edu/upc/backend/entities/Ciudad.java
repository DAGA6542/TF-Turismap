package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

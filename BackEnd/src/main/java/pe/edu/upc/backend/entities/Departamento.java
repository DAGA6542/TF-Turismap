package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

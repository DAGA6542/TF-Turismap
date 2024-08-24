package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPais;
    @Column(name = "nombrePais", nullable = false, length = 40)
    private String nombrePais;
    @Column(name = "codigoIsoPais", nullable = false, length = 3)
    private String codigoIsoPais;
    @Column(name = "continentePais", nullable = false, length = 40)
    private String continentePais;
    @Column(name = "capitalPais", nullable = false, length = 50)
    private String capitalPais;
    @Column(name = "monedaPais", nullable = false, length = 20)
    private String monedaPais;
    @Column(name = "idiomaOficialPais", nullable = false, length = 15)
    private String idiomaOficialPais;
    @Column(name = "poblacionPais", nullable = false)
    private Long poblacionPais;
    @Column(name = "superficiePais", nullable = false)
    private int superficiePais;
}
package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Negocio")
public class Negocio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNegocio;
    @Column(name = "nombreNegocio", nullable = false, length = 50)
    private String nombreNegocio;
    @Column(name = "horarioNegocio", nullable = false, length = 20)
    private String horarioNegocio;
    @Column(name = "numeroTelefonoNegocio", nullable = false)
    private int numeroTelefonoNegocio;
    @Column(name = "calificacionNegocio", nullable = false)
    private int calificacionNegocio;
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad idCiudad;
}
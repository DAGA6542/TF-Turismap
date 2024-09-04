package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Turismo")
public class Turismo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurismo;
    @Column(name = "nombreTurismo", nullable = false, length = 50)
    private String nombreTurismo;
    @Column(name = "descripcionTurimos", nullable = false, length = 50)
    private String descripcionTurismo;
    @Column(name = "numeroTelefonoTurismo", nullable = false)
    private int numeroTelefonoTurismo;
    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad idCiudad;
    @ManyToOne
    @JoinColumn(name = "idPromocion")
    private PromocionTuristica idPromocion;
}
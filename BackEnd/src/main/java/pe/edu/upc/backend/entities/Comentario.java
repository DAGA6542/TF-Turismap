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
@Table(name = "Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;
    @Column(name = "textoComentario", nullable = false, length = 150)
    private String textoComentario;
    @Column(name = "fechaComentario", nullable = false)
    private LocalDate fechaComentario;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idTurismo")
    private Turismo idTurismo;
    @ManyToOne
    @JoinColumn(name = "idNegocio")
    private Negocio idNegocio;
}

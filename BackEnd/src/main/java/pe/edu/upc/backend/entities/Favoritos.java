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
@Table(name = "Favoritos")
public class Favoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFavorito;
    @Column(name = "fechaAgregadoFavorito", nullable = false)
    private LocalDate fechaAgregadoFavorito;
    @Column(name = "fechaModificacionFavorito", nullable = false)
    private LocalDate fechaModificacionFavorito;
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

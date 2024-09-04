package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MenbresiaVIP")
public class MenbresiaVIP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenbresiaVIP;
    @Column(name = "tipoMenbresiaVIP", nullable = false, length = 50)
    private String tipoMenbresiaVIP;
    @Column(name = "fechaInicioMenbresiaVIP", nullable = false)
    private String fechaInicioMenbresiaVIP;
    @Column(name = "fechaFinMenbresiaVIP", nullable = false)
    private String fechaFinMenbresiaVIP;
    @Column(name = "estadoMenbresiaVIP", nullable = false, length = 1)
    private String estadoMenbresiaVIP;
    @Column(name = "beneficioMenbresiaVIP", nullable = false, length = 250)
    private String beneficioMenbresiaVIP;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
}
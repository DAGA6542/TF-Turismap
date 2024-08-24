package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombreUsuario", nullable = false, length = 50)
    private String nombreUsuario;
    @Column(name = "emailUsuario", nullable = false, length = 50)
    private String emailUsuario;
    @Column(name = "contraseniaUsuario", nullable = false, length = 250)
    private String contraseniaUsuario;
    @Column(name = "telefonoUsuario", nullable = false)
    private int telefonoUsuario;
    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol idRol;
}

package pe.edu.upc.backend.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    private String emailUsuario;
    private String contraseniaUsuario;
    private int telefonoUsuario;
}
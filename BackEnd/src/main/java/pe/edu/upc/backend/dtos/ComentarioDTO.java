package pe.edu.upc.backend.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDTO {
    private int idComentario;
    private String textoComentario;
    private LocalDate fechaComentario;
}

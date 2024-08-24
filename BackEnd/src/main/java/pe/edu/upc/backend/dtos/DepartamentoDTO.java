package pe.edu.upc.backend.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoDTO {
    private int idDepartamento;
    private String nombreDepartamento;
    private String capitalDepartamento;
    private Long poblacionDepartamento;
    private int superficieDepartamento;
}
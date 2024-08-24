package pe.edu.upc.backend.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaisDTO {
    private int idPais;
    private String nombrePais;
    private String codigoIsoPais;
    private String continentePais;
    private String capitalPais;
    private String monedaPais;
    private String idiomaOficialPais;
    private Long poblacionPais;
}

package pe.edu.upc.backend.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiudadDTO {
    private int idCiudad;
    private String nombreCiudad;
    private Long poblacionCiudad;
    private int superficieCiudad;
    private double latitudCiudad;
    private double longitudCiudad;
    private int codigoPostalCiudad;
}
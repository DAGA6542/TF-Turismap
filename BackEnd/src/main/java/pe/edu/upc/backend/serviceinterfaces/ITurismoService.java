package pe.edu.upc.backend.serviceinterfaces;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.backend.entities.Comentario;
import pe.edu.upc.backend.entities.Turismo;
import java.util.List;
public interface ITurismoService {
    public void insert(Turismo turismo);
    public List<Turismo> list();
    public void update(Turismo turismo);
    public void delete(int idTurismo);
    public List<Turismo> listarPorNumero(int idTurismo);
    public List<Turismo> listarlugarturisticoporciudad1(String nombreCiudad);
}

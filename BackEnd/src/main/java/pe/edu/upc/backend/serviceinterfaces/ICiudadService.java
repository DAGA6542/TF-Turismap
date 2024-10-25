package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Ciudad;
import java.util.List;
public interface ICiudadService {
    public void insert(Ciudad ciudad);
    public List<Ciudad> list();
    public void update(Ciudad ciudad);
    public void delete(int idCiudad);
    public Ciudad listId(int idCiudad);
    public List<Ciudad> buscarNombreCiudad(String nombreCiudad);
    public List<Ciudad> latitudMayor(double latitud);
    public List<Ciudad> longitudMenor(double longitud);
    public List<Ciudad> poblacionMayor(Long poblacion);
    public List<String[]>cantidadTurismo();
}

package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Pais;
import java.util.List;
public interface IPaisService {
    public void insert(Pais pais);
    public List<Pais> list();
    public void update(Pais pais);
    public void delete(int idPais);
    public Pais listById(int idPais);
    public List<Pais> obtenerPorContinente(String continente);
    public List<Pais> obtenerPorNombre(String nombre);
    public List<Pais> obtenerPorPoblacionMayor(Long poblacion);
    public Pais obtenerPorCodigoIso(String codigoIso);
    public long obtenerCantidadPaisEnUnContinente(String continente);
    public List<Pais> obtenerSuperficieMayor(int superficie);
    public List<Pais> obtenerPorMoneda(String moneda);
    public List<Pais> obtenerPorIdioma(String idioma);
    public Pais obtenerPorCapital(String capital);
}
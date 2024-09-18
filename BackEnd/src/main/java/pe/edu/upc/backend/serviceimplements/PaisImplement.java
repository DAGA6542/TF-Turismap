package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Pais;
import pe.edu.upc.backend.repositories.IPaisRepository;
import pe.edu.upc.backend.serviceinterfaces.IPaisService;
import java.util.List;
@Service
public class PaisImplement implements IPaisService {
    @Autowired
    private IPaisRepository pR;
    @Override
    public void insert(Pais pais) { pR.save(pais); }
    @Override
    public void update(Pais pais) { pR.save(pais); }
    @Override
    public List<Pais> list() { return pR.findAll(); }
    @Override
    public void delete(int idPais) { pR.deleteById(idPais); }
    @Override
    public List<Pais> obtenerPorContinente(String continente) { return pR.obtenerPorContinente(continente); }
    @Override
    public List<Pais> obtenerPorNombre(String nombre) { return pR.obtenerPorNombre(nombre); }
    @Override
    public List<Pais> obtenerPorPoblacionMayor(Long poblacion) { return pR.obtenerPorPoblacionMayor(poblacion); }
    @Override
    public Pais obtenerPorCodigoIso(String codigoIso) { return pR.obtenerPorCodigoIso(codigoIso); }
    @Override
    public long obtenerCantidadPaisEnUnContinente(String continente) { return pR.obtenerCantidadPaisEnUnContinente(continente); }
    @Override
    public List<Pais> obtenerSuperficieMayor(int superficie) { return pR.obtenerSuperficieMayor(superficie); }
    @Override
    public List<Pais> obtenerPorMoneda(String moneda) { return pR.obtenerPorMoneda(moneda); }
    @Override
    public List<Pais> obtenerPorIdioma(String idioma) { return pR.obtenerPorIdioma(idioma); }
    @Override
    public Pais obtenerPorCapital(String capital) { return pR.obtenerPorCapital(capital); }
}

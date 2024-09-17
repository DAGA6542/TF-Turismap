package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Favorito;
import pe.edu.upc.backend.repositories.IFavoritoRepository;
import pe.edu.upc.backend.serviceinterfaces.IFavoritoService;
import java.time.LocalDate;
import java.util.List;
@Service
public class FavoritoImplement implements IFavoritoService {
    @Autowired
    private IFavoritoRepository fR;
    @Override
    public void insert(Favorito favorito) { fR.save(favorito); }
    @Override
    public List<Favorito> list() { return fR.findAll(); }
    @Override
    public void update(Favorito favorito) { fR.save(favorito); }
    @Override
    public void delete(int idFavorito) { fR.deleteById(idFavorito); }
    @Override
    public List<Favorito> obtenerFavPorUsuario(int idUsuario) { return fR.obtenerFavPorUsuario(idUsuario); }
    @Override
    public List<Favorito> obtenerFavPorFechaAgregado(LocalDate fecha) { return fR.obtenerFavPorFechaAgregado(fecha); }
    @Override
    public long cantidadFavoritosDeUsuario(int idUsuario) { return cantidadFavoritosDeUsuario(idUsuario); }
    @Override
    public List<Favorito> obtenerFavoRelacionANegocio(int idNegocio) { return fR.obtenerFavoRelacionANegocio(idNegocio); }
    @Override
    public List<Favorito> obtenerFavoritosPorFechaModificacion(LocalDate fecha) { return fR.obtenerFavoritosPorFechaModificacion(fecha); }
    @Override
    public List<Favorito> obtenerFavoDeTurismo(int idTuristico) { return fR.obtenerFavoDeTurismo(idTuristico); }
    @Override
    public void eliminarFavoDeUsuario(int idUsuario) { fR.eliminarFavoDeUsuario(idUsuario); }
}
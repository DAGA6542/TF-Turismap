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
    public void delete(Long idFavorito) { fR.deleteById(idFavorito); }
    @Override
    public Favorito findById(Long idFavorito) { return fR.findById(idFavorito).orElse(new Favorito()); }
    @Override
    public List<Favorito> obtenerFavPorUsuario(Long idUsuario) { return fR.obtenerFavPorUsuario(idUsuario); }
    @Override
    public List<Favorito> obtenerFavPorFechaAgregado(LocalDate fecha) { return fR.obtenerFavPorFechaAgregado(fecha); }
    @Override
    public long cantidadFavoritosDeUsuario(Long idUsuario) { return cantidadFavoritosDeUsuario(idUsuario); }
    @Override
    public List<Favorito> obtenerFavoRelacionANegocio(Long idNegocio) { return fR.obtenerFavoRelacionANegocio(idNegocio); }
    @Override
    public List<Favorito> obtenerFavoritosPorFechaModificacion(LocalDate fecha) { return fR.obtenerFavoritosPorFechaModificacion(fecha); }
    @Override
    public List<Favorito> obtenerFavoDeTurismo(Long idLugar) { return fR.obtenerFavoDeTurismo(idLugar); }
    @Override
    public void eliminarFavoDeUsuario(Long idUsuario) { fR.eliminarFavoDeUsuario(idUsuario); }
}
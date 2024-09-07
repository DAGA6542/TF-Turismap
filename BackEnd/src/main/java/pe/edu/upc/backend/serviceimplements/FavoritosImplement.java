package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Favoritos;
import pe.edu.upc.backend.repositories.IFavoritosRepository;
import pe.edu.upc.backend.serviceinterfaces.IFavoritosService;
import java.time.LocalDate;
import java.util.List;
@Service
public class FavoritosImplement implements IFavoritosService {
    @Autowired
    private IFavoritosRepository fR;
    @Override
    public void insert(Favoritos favoritos) { fR.save(favoritos); }
    @Override
    public List<Favoritos> list() { return fR.findAll(); }
    @Override
    public void update(Favoritos favoritos) { fR.save(favoritos); }
    @Override
    public void delete(int idFavoritos) { fR.deleteById(idFavoritos); }
    @Override
    public List<Favoritos> obtenerFavPorUsuario(int idUsuario) { return fR.obtenerFavPorUsuario(idUsuario); }
    @Override
    public List<Favoritos> obtenerFavPorFechaAgregado(LocalDate fecha) { return fR.obtenerFavPorFechaAgregado(fecha); }
    @Override
    public long cantidadFavoritosDeUsuario(int idUsuario) { return fR.cantidadFavoritosDeUsuario(idUsuario); }
    @Override
    public List<Favoritos> obtenerFavoRelacionANegocio(int idNegocio) { return fR.obtenerFavoRelacionANegocio(idNegocio); }
    @Override
    public List<Favoritos> obtenerFavoritosPorFechaModificacion(LocalDate fecha) { return fR.obtenerFavoritosPorFechaModificacion(fecha); }
    @Override
    public List<Favoritos> ObtenerFavoDeTurismo(int idTurismo) { return fR.ObtenerFavoDeTurismo(idTurismo); }
    @Override
    public void eliminarFavoDeUsuario(int idUsuario) { fR.eliminarFavoDeUsuario(idUsuario); }
}
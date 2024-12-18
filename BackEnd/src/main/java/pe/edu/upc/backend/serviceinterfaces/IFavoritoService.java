package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Favorito;
import java.time.LocalDate;
import java.util.List;
public interface IFavoritoService {
    public void insert(Favorito favorito);
    public List<Favorito> list();
    public void update(Favorito favorito);
    public void delete(Long idFavorito);
    public Favorito findById(Long idFavorito);
    public List<Favorito> obtenerFavPorUsuario(Long idUsuario);
    public List<Favorito> obtenerFavPorFechaAgregado(LocalDate fecha);
    public long cantidadFavoritosDeUsuario(Long idUsuario);
    public List<Favorito> obtenerFavoRelacionANegocio(Long idNegocio);
    public List<Favorito> obtenerFavoritosPorFechaModificacion(LocalDate fecha);
    public List<Favorito> obtenerFavoDeTurismo(Long idLugar);
    public void eliminarFavoDeUsuario(Long idUsuario);
}
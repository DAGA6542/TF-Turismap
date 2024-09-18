package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Favorito;
import java.time.LocalDate;
import java.util.List;
public interface IFavoritoService {
    public void insert(Favorito favorito);
    public List<Favorito> list();
    public void update(Favorito favorito);
    public void delete(int idFavorito);
    public List<Favorito> obtenerFavPorUsuario(int idUsuario);
    public List<Favorito> obtenerFavPorFechaAgregado(LocalDate fecha);
    public long cantidadFavoritosDeUsuario(int idUsuario);
    public List<Favorito> obtenerFavoRelacionANegocio(int idNegocio);
    public List<Favorito> obtenerFavoritosPorFechaModificacion(LocalDate fecha);
    public List<Favorito> obtenerFavoDeTurismo(int idTuristico);
    public void eliminarFavoDeUsuario(int idUsuario);
}
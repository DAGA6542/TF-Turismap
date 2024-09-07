package pe.edu.upc.backend.serviceinterfaces;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.backend.entities.Favoritos;
import java.time.LocalDate;
import java.util.List;
public interface IFavoritosService {
    public void insert(Favoritos favoritos);
    public List<Favoritos> list();
    public void update(Favoritos favoritos);
    public void delete(int idFavoritos);
    public List<Favoritos> obtenerFavPorUsuario(int idUsuario);
    public List<Favoritos> obtenerFavPorFechaAgregado(LocalDate fecha);
    public long cantidadFavoritosDeUsuario(int idUsuario);
    public List<Favoritos> obtenerFavoRelacionANegocio(int idNegocio);
    public List<Favoritos> obtenerFavoritosPorFechaModificacion(LocalDate fecha);
    public List<Favoritos> ObtenerFavoDeTurismo(int idTurismo);
    public void eliminarFavoDeUsuario(int idUsuario);
}

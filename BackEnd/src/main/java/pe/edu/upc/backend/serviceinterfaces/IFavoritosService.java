package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Favoritos;
import java.util.List;
public interface IFavoritosService {
    public void insert(Favoritos favoritos);
    public List<Favoritos> list();
    public void update(Favoritos favoritos);
    public void delete(int idFavoritos);
}

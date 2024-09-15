package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.Favorito;
import java.util.List;
public interface IFavoritoService {
    public void insert(Favorito favorito);
    public List<Favorito> list();
    public void update(Favorito favorito);
    public void delete(int idFavorito);
}
package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Favoritos;
import pe.edu.upc.backend.repositories.IFavoritosRepository;
import pe.edu.upc.backend.serviceinterfaces.IFavoritosService;
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
}
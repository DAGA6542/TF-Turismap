package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Favorito;
import pe.edu.upc.backend.repositories.IFavoritoRepository;
import pe.edu.upc.backend.serviceinterfaces.IFavoritoService;
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
}
package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Promocion;
import pe.edu.upc.backend.repositories.IPromocionRepository;
import pe.edu.upc.backend.serviceinterfaces.IPromocionService;
import java.util.List;
@Service
public class PromocionImplement implements IPromocionService {
    @Autowired
    private IPromocionRepository pR;
    @Override
    public void insert(Promocion promocion) { pR.save(promocion); }
    @Override
    public List<Promocion> list() { return pR.findAll(); }
    @Override
    public void update(Promocion promocion) { pR.save(promocion); }
    @Override
    public void delete(int idPromocion) { pR.deleteById(idPromocion); }
}

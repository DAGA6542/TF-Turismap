package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.PromocionTuristica;
import pe.edu.upc.backend.repositories.IPromocionTuristicaRepository;
import pe.edu.upc.backend.serviceinterfaces.IPromocionTuristicaService;
import java.util.List;
@Service
public class PromocionTuristicaImplement implements IPromocionTuristicaService {
    @Autowired
    private IPromocionTuristicaRepository pR;
    @Override
    public void insert(PromocionTuristica promocionTuristica) { pR.save(promocionTuristica); }
    @Override
    public List<PromocionTuristica> list() { return pR.findAll(); }
    @Override
    public void update(PromocionTuristica promocionTuristica) { pR.save(promocionTuristica); }
    @Override
    public void delete(int idPromocionTuristica) { pR.deleteById(idPromocionTuristica); }
}
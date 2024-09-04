package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.Turismo;
import pe.edu.upc.backend.repositories.ITurismoRepository;
import pe.edu.upc.backend.serviceinterfaces.ITurismoService;
import java.util.List;
@Service
public class TurismoImplement implements ITurismoService {
    @Autowired
    private ITurismoRepository tR;
    @Override
    public void insert(Turismo turismo) { tR.save(turismo); }
    @Override
    public List<Turismo> list() { return tR.findAll(); }
    @Override
    public void update(Turismo turismo) { tR.save(turismo); }
    @Override
    public void delete(int idTurismo) { tR.deleteById(idTurismo); }
}
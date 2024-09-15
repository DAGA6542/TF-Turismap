package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.MenbresiaVIP;
import pe.edu.upc.backend.repositories.IMenbresiaVIPRepository;
import pe.edu.upc.backend.serviceinterfaces.IMenbresiaVIPService;
import java.util.List;
@Service
public class MenbresiaVIPImplement implements IMenbresiaVIPService {
    @Autowired
    private IMenbresiaVIPRepository mR;
    @Override
    public void insert(MenbresiaVIP menbresiaVIP) { mR.save(menbresiaVIP); }
    @Override
    public List<MenbresiaVIP> list() { return mR.findAll(); }
    @Override
    public void update(MenbresiaVIP menbresiaVIP) { mR.save(menbresiaVIP); }
    @Override
    public void delete(int idMenbresiaVIP) { mR.deleteById(idMenbresiaVIP); }
}

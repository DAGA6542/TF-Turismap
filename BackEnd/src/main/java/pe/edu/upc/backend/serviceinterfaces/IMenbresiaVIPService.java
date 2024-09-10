package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.MenbresiaVIP;
import java.util.List;
public interface IMenbresiaVIPService {
    public void insert(MenbresiaVIP menbresiaVIP);
    public List<MenbresiaVIP> list();
    public void update(MenbresiaVIP menbresiaVIP);
    public void delete(int idMenbresiaVIP);
}

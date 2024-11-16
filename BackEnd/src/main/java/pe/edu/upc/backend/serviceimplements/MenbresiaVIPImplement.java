package pe.edu.upc.backend.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.backend.entities.MenbresiaVIP;
import pe.edu.upc.backend.repositories.IMenbresiaVIPRepository;
import pe.edu.upc.backend.serviceinterfaces.IMenbresiaVIPService;
import java.time.LocalDate;
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
    public void delete(Long idMenbresiaVIP) { mR.deleteById(idMenbresiaVIP); }
    @Override
    public MenbresiaVIP listById(Long idMenbreidMenbresiaVIP) { return mR.findById(idMenbreidMenbresiaVIP).orElse(new MenbresiaVIP()); }
    @Override
    public List<MenbresiaVIP> obtenerMenbresActiv() { return mR.obtenerMenbresActiv(); }
    @Override
    public List<MenbresiaVIP> obtenerMenbresDeUsuar(Long idUsuario) {  return mR.obtenerMenbresDeUsuar(idUsuario); }
    @Override
    public List<MenbresiaVIP> obtenerMenbresiasTipoMayorEspecifico(String tipo) { return mR.obtenerMenbresiasTipoMayorEspecifico(tipo); }
    @Override
    public int cantidadMenbresActivas() { return mR.cantidadMenbresActivas(); }
    @Override
    public List<MenbresiaVIP> obtenerMenbresExpiranEnFechaEspecifi(LocalDate fecha) { return mR.obtenerMenbresExpiranEnFechaEspecifi(fecha); }
    @Override
    public List<MenbresiaVIP> obtenerMenbresDeUsuario(Long idUsuario) { return mR.obtenerMenbresDeUsuario(idUsuario); }
    @Override
    public List<MenbresiaVIP> obtenerNombreUsuarioYTipoMembresia(String tipo) { return mR.obtenerNombreUsuarioYTipoMembresia(tipo); }
}
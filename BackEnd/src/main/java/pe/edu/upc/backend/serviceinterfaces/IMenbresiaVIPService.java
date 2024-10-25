package pe.edu.upc.backend.serviceinterfaces;
import pe.edu.upc.backend.entities.MenbresiaVIP;
import java.time.LocalDate;
import java.util.List;
public interface IMenbresiaVIPService {
    public void insert(MenbresiaVIP menbresiaVIP);
    public List<MenbresiaVIP> list();
    public void update(MenbresiaVIP menbresiaVIP);
    public void delete(int idMenbresiaVIP);
    public MenbresiaVIP listById(int idMenbreidMenbresiaVIP);
    public List<MenbresiaVIP> obtenerMenbresActiv();
    public List<MenbresiaVIP> obtenerMenbresDeUsuar(int idUsuario);
    public List<MenbresiaVIP> obtenerMenbresiasTipoMayorEspecifico(String tipo);
    public int cantidadMenbresActivas();
    public List<MenbresiaVIP> obtenerMenbresExpiranEnFechaEspecifi(LocalDate fecha);
    public List<MenbresiaVIP> obtenerMenbresDeUsuario(int idUsuario);
    public List<MenbresiaVIP> obtenerNombreUsuarioYTipoMembresia(String tipo);
}

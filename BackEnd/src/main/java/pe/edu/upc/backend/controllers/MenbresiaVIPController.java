package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.MenbresiaVIPDTO;
import pe.edu.upc.backend.dtos.UsuarioConMasMenbreDTO;
import pe.edu.upc.backend.entities.MenbresiaVIP;
import pe.edu.upc.backend.serviceinterfaces.IMenbresiaVIPService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/membresiavip")
public class MenbresiaVIPController {
    @Autowired
    private IMenbresiaVIPService mS;
    @PostMapping
    public void agregar(@RequestBody MenbresiaVIPDTO menbresiaVIPDTO) {
        ModelMapper m = new ModelMapper();
        MenbresiaVIP menbresiaVIP = m.map(menbresiaVIPDTO, MenbresiaVIP.class);
        mS.insert(menbresiaVIP);
    }
    @PutMapping
    public void modificar(@RequestBody MenbresiaVIPDTO menbresiaVIPDTO) {
        ModelMapper m = new ModelMapper();
        MenbresiaVIP menbresiaVIP = m.map(menbresiaVIPDTO, MenbresiaVIP.class);
        mS.update(menbresiaVIP);
    }
    @GetMapping
    public List<MenbresiaVIPDTO> listar() {
        return mS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MenbresiaVIPDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping({"/id"})
    public void eliminar(@RequestParam("id") Long id) { mS.delete(id); }
    @GetMapping("/{id}")
    public MenbresiaVIPDTO listPorId(@PathVariable Long id) {
        ModelMapper m = new ModelMapper();
        MenbresiaVIPDTO chupetin = m.map(listPorId(id),MenbresiaVIPDTO.class);
        return chupetin;
    }
    @GetMapping("/obtenermenbresactiv")
    public List<MenbresiaVIPDTO> obtenerMenbresActiv() {
        return mS.obtenerMenbresActiv().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MenbresiaVIPDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenermenbresdeusuar")
    public List<MenbresiaVIPDTO> obtenerMenbresDeUsuar(@RequestParam Long idUsuario) {
        return mS.obtenerMenbresDeUsuar(idUsuario).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MenbresiaVIPDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenermenbresiastipomayorespecifico")
    public List<MenbresiaVIPDTO> obtenerMenbresiasTipoMayorEspecifico(@RequestParam String tipo) {
        return mS.obtenerMenbresiasTipoMayorEspecifico(tipo).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MenbresiaVIPDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidadmenbresactivas")
    public int cantidadMenbresActivas() {
        return mS.cantidadMenbresActivas();
    }
    @GetMapping("/obtenermenbresexpiranenfechaespecifi")
    public List<MenbresiaVIPDTO> obtenerMenbresExpiranEnFechaEspecifi(@RequestParam LocalDate fecha) {
        return mS.obtenerMenbresExpiranEnFechaEspecifi(fecha).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MenbresiaVIPDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenermenbresdeusuario")
    public List<MenbresiaVIPDTO> obtenerMenbresDeUsuario(@RequestParam Long idUsuario) {
        return mS.obtenerMenbresDeUsuario(idUsuario).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MenbresiaVIPDTO.class);
        }).collect(Collectors.toList());
    }
    
    @GetMapping("/obtenerNombreUsuarioYTipoMembresia")
    public List<MenbresiaVIPDTO> obtenerNombreUsuarioYTipoMembresia(@RequestParam String tipo) {
        return mS.obtenerNombreUsuarioYTipoMembresia(tipo).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MenbresiaVIPDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/usuariosConMasMembresiasActivas")
    public List<UsuarioConMasMenbreDTO> usuariosConMasMembresiasActivas() {
        List<String[]> resultados = mS.usuariosConMasMenbresiasActivas();
        List<UsuarioConMasMenbreDTO> listaDTO = new ArrayList<>();
        for (String[] fila : resultados) {
            UsuarioConMasMenbreDTO dto = new UsuarioConMasMenbreDTO();
            dto.setUsuario(fila[0]);
            dto.setTipoMembresia(fila[1]);
            dto.setBeneficios(fila[2]);
            if (fila[3] != null && !fila[3].isEmpty()) {
                dto.setInicio(LocalDate.parse(fila[3]));
            }
            if (fila[4] != null && !fila[4].isEmpty()) {
                dto.setFin(LocalDate.parse(fila[4]));
            }
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.MenbresiaVIPDTO;
import pe.edu.upc.backend.entities.MenbresiaVIP;
import pe.edu.upc.backend.serviceinterfaces.IMenbresiaVIPService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/menbresiavip")
public class MenbresiaVIPController {
    @Autowired
    private IMenbresiaVIPService mS;
    @PostMapping
    @PreAuthorize("hasAuthority('VIP') or hasAuthority('ADMIN')")
    public void agregar(@RequestBody MenbresiaVIPDTO menbresiaVIPDTO) {
        ModelMapper m = new ModelMapper();
        MenbresiaVIP menbresiaVIP = m.map(menbresiaVIPDTO, MenbresiaVIP.class);
        mS.insert(menbresiaVIP);
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody MenbresiaVIPDTO menbresiaVIPDTO) {
        ModelMapper m = new ModelMapper();
        MenbresiaVIP menbresiaVIP = m.map(menbresiaVIPDTO, MenbresiaVIP.class);
        mS.update(menbresiaVIP);
    }
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<MenbresiaVIPDTO> listar() {
        return mS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MenbresiaVIPDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping({"/id"})
    @PreAuthorize("hasAuthority('VIP') or hasAuthority('ADMIN')")
    public void eliminar(@RequestParam("id") int id) {
        mS.delete(id);
    }
    @GetMapping("/obtenermenbresactiv")
    public List<MenbresiaVIPDTO> obtenerMenbresActiv() {
        return mS.obtenerMenbresActiv().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,MenbresiaVIPDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenermenbresdeusuar")
    public List<MenbresiaVIPDTO> obtenerMenbresDeUsuar(@RequestParam int idUsuario) {
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
    public List<MenbresiaVIPDTO> obtenerMenbresDeUsuario(@RequestParam int idUsuario) {
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
}

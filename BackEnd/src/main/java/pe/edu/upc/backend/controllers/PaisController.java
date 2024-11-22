package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.PaisDTO;
import pe.edu.upc.backend.entities.Pais;
import pe.edu.upc.backend.serviceinterfaces.IPaisService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    IPaisService pS;
    @PostMapping
    public void insertar(@RequestBody PaisDTO paisDTO) {
        ModelMapper m = new ModelMapper();
        Pais pais = m.map(paisDTO, Pais.class);
        pS.insert(pais);
    }
    @PutMapping
    public void modificar(@RequestBody PaisDTO paisDTO) {
        ModelMapper m = new ModelMapper();
        Pais pais = m.map(paisDTO, Pais.class);
        pS.update(pais);
    }
    @GetMapping
    public List<PaisDTO> listar() {
        return pS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PaisDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        pS.delete(id);
    }
    @GetMapping("/{id}")
    public PaisDTO buscarPorId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        return m.map(pS.listById(id), PaisDTO.class);
    }
    @GetMapping("/obtenerporcontinente")
    public List<PaisDTO> obtenerPorContinente(@RequestParam String continente) {
        return pS.obtenerPorContinente(continente).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PaisDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerpornombre")
    public List<PaisDTO> obtenerPorNombre(@RequestParam String nombre) {
        return pS.obtenerPorNombre(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PaisDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporpoblacionmayor")
    public List<PaisDTO> obtenerPorPoblacionMayor(@RequestParam Long poblacion) {
        return pS.obtenerPorPoblacionMayor(poblacion).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PaisDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporcodigoiso")
    public PaisDTO obtenerPorCodigoIso(@RequestParam String codigoIso) {
        Pais pais = pS.obtenerPorCodigoIso(codigoIso);
        ModelMapper m = new ModelMapper();
        return m.map(pais,PaisDTO.class);
    }
    @GetMapping("/obtenercantidadpaisenuncontinente")
    public long obtenerCantidadPaisEnUnContinente(@RequestParam String continente) {
        return pS.obtenerCantidadPaisEnUnContinente(continente);
    }
    @GetMapping("/obtenersuperficiemayor")
    public List<PaisDTO> obtenerSuperficieMayor(@RequestParam int superficie) {
        return pS.obtenerSuperficieMayor(superficie).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PaisDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerpormoneda")
    public List<PaisDTO> obtenerPorMoneda(@RequestParam String moneda) {
        return pS.obtenerPorMoneda(moneda).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PaisDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporidioma")
    public List<PaisDTO> obtenerPorIdioma(@RequestParam String idioma) {
        return pS.obtenerPorIdioma(idioma).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PaisDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporcapital")
    public PaisDTO obtenerPorCapital(@RequestParam String capital) {
        Pais pais = pS.obtenerPorCapital(capital);
        ModelMapper m = new ModelMapper();
        return m.map(pais,PaisDTO.class);
    }
}
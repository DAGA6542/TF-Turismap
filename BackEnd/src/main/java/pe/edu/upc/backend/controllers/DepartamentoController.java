package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.DepartamentoDTO;
import pe.edu.upc.backend.entities.Departamento;
import pe.edu.upc.backend.serviceinterfaces.IDepartamentoService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/departamentos")
@PreAuthorize("hasAuthority('ADMIN')")
public class DepartamentoController {
    @Autowired
    private IDepartamentoService dS;
    @PostMapping
    public void agregar(@RequestBody DepartamentoDTO departamentoDTO) {
        ModelMapper m = new ModelMapper();
        Departamento departamento = m.map(departamentoDTO, Departamento.class);
        dS.insert(departamento);
    }
    @PutMapping
    public void modificar(@RequestBody DepartamentoDTO departamentoDTO) {
        ModelMapper m = new ModelMapper();
        Departamento departamento = m.map(departamentoDTO, Departamento.class);
        dS.update(departamento);
    }
    @GetMapping
    public List<DepartamentoDTO> listar() {
        return dS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,DepartamentoDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        dS.delete(id);
    }
    @GetMapping("/buscarpornombre")
    public List<DepartamentoDTO> buscarPorNombre(String nombre) {
        return dS.buscarPorNombre(nombre).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,DepartamentoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listarporpais")
    public List<DepartamentoDTO> listarPorPais(int idPais) {
        return dS.listarPorPais(idPais).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,DepartamentoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerdepartamentopoblacion")
    public List<DepartamentoDTO> obtenerDepartamentPoblac(Long poblacion) {
        return dS.obtenerDepartamentPoblac(poblacion).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,DepartamentoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscardepartamentosuperficie")
    public List<DepartamentoDTO> buscarDepartamentoConSuperficie(int minSuperficie, int maxSuperficie) {
        return dS.buscarDepartamentoConSuperficie(minSuperficie, maxSuperficie).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,DepartamentoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/obtenerporpoblaciondesc")
    public List<DepartamentoDTO> obtenerPorPoblacionDesc() {
        return dS.obtenerPorPoblacionDesc().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,DepartamentoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/buscarporcapital")
    public List<DepartamentoDTO> buscarPorCapital(String capital) {
        return dS.buscarPorCapital(capital).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,DepartamentoDTO.class);
        }).collect(Collectors.toList());
    }
}
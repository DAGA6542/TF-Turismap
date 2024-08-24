package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.DepartamentoDTO;
import pe.edu.upc.backend.entities.Departamento;
import pe.edu.upc.backend.serviceinterfaces.IDepartamentoService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/departamentos")
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
        dS.insert(departamento);
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
}

package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.NegocioDTO;
import pe.edu.upc.backend.entities.Negocio;
import pe.edu.upc.backend.serviceinterfaces.INegocioService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/negocio")
@PreAuthorize("hasAuthority('JEFE') or hasAuthority('ADMIN')")
public class NegocioController {
    @Autowired
    private INegocioService nS;
    @PostMapping
    public void agregar(@RequestBody NegocioDTO negocioDTO) {
        ModelMapper m = new ModelMapper();
        Negocio negocio = m.map(negocioDTO, Negocio.class);
        nS.insert(negocio);
    }
    @PutMapping
    public void modificar(@RequestBody NegocioDTO negocioDTO) {
        ModelMapper m = new ModelMapper();
        Negocio negocio = m.map(negocioDTO, Negocio.class);
        nS.update(negocio);
    }
    @GetMapping
    public List<NegocioDTO> listar() {
        return nS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,NegocioDTO.class);
        }).collect(Collectors.toList());
    }
}
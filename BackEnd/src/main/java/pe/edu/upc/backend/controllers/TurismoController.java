package pe.edu.upc.backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.TurismoDTO;
import pe.edu.upc.backend.entities.Turismo;
import pe.edu.upc.backend.serviceinterfaces.ITurismoService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/turismo")
public class TurismoController {
    @Autowired
    private ITurismoService tS;
    @PostMapping
    public void agregar(@RequestBody TurismoDTO turismoDTO) {
        ModelMapper m = new ModelMapper();
        Turismo turismo = m.map(turismoDTO, Turismo.class);
        tS.insert(turismo);
    }
    @PutMapping
    public void modificar(@RequestBody TurismoDTO turismoDTO) {
        ModelMapper m = new ModelMapper();
        Turismo turismo = m.map(turismoDTO, Turismo.class);
        tS.update(turismo);
    }
    @GetMapping
    public List<TurismoDTO> listar() {
        return tS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,TurismoDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        tS.delete(id);
    }
}

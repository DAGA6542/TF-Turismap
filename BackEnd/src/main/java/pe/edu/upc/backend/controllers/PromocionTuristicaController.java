package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.PromocionTuristicaDTO;
import pe.edu.upc.backend.entities.PromocionTuristica;
import pe.edu.upc.backend.serviceinterfaces.IPromocionTuristicaService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/promocionesturisticas")
public class PromocionTuristicaController {
    @Autowired
    private IPromocionTuristicaService pS;
    @PostMapping
    public void agregar(@RequestBody PromocionTuristicaDTO promocionTuristicaDTO) {
        ModelMapper m = new ModelMapper();
        PromocionTuristica promocion = m.map(promocionTuristicaDTO, PromocionTuristica.class);
        pS.insert(promocion);
    }
    @PutMapping
    public void modificar(@RequestBody PromocionTuristicaDTO promocionTuristicaDTO) {
        ModelMapper m = new ModelMapper();
        PromocionTuristica promocion = m.map(promocionTuristicaDTO, PromocionTuristica.class);
        pS.update(promocion);
    }
    @GetMapping
    public List<PromocionTuristica> listar() {
        return pS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,PromocionTuristica.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id) {
        pS.delete(id);
    }
}

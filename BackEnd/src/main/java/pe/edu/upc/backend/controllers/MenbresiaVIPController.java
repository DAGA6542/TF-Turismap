package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.MenbresiaVIPDTO;
import pe.edu.upc.backend.entities.MenbresiaVIP;
import pe.edu.upc.backend.serviceinterfaces.IMenbresiaVIPService;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/menbresiavip")
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
    public void eliminar(@RequestParam("id") int id) {
        mS.delete(id);
    }
}
package pe.edu.upc.backend.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.CiudadDTO;
import pe.edu.upc.backend.dtos.LugarTuristicoDTO;
import pe.edu.upc.backend.dtos.LugarTuristicoPorComentarioDTO;
import pe.edu.upc.backend.entities.LugarTuristico;
import pe.edu.upc.backend.serviceinterfaces.ILugarTuristicoService;
import pe.edu.upc.backend.dtos.LugarTuristicoPorCiudadDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/lugarturistico")
public class LugarTuristicoController {
    @Autowired
    private ILugarTuristicoService lS;
    @PostMapping
    public void agregar(@RequestBody LugarTuristicoDTO lugarTuristicoDTO) {
        ModelMapper m = new ModelMapper();
        LugarTuristico lugarTuristico = m.map(lugarTuristicoDTO, LugarTuristico.class);
        lS.insert(lugarTuristico);
    }
    @PutMapping
    public void modificar(@RequestBody LugarTuristicoDTO lugarTuristicoDTO) {
        ModelMapper m = new ModelMapper();
        LugarTuristico lugarTuristico = m.map(lugarTuristicoDTO, LugarTuristico.class);
        lS.update(lugarTuristico);
    }
    @GetMapping
    public List<LugarTuristicoDTO> listar() {
        return lS.list().stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        lS.delete(id);
    }
    @GetMapping("/{id}")
    public LugarTuristicoDTO listPorId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        return m.map(lS.listById(id), LugarTuristicoDTO.class);
    }
    @GetMapping("/lugarturisticoporciudad")
    public List<LugarTuristicoDTO> obtenerPorCiudadL(@RequestParam Long idCiudad) {
        return lS.obtenerPorCiudadL(idCiudad).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/latitud")
    public List<LugarTuristicoDTO> latitudMayor(@RequestParam double latitud) {
        return lS.latitudMayor(latitud).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/longitud")
    public List<LugarTuristicoDTO> longitudMenor(@RequestParam double longitud) {
        return lS.longitudMenor(longitud).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y, LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/cantidadlugaresturisticosporciudad")
    public long contarPorCiudadL(@RequestParam Long idCiudad) {
        return lS.contarPorCiudadL(idCiudad);
    }
    @GetMapping("/listarPorNumero")
    public List<LugarTuristicoDTO> listarPorNumero(@RequestParam String nombreLugar) { // By Diego
        return lS.listarPorNumero(nombreLugar).stream().map(y->{
            ModelMapper m = new ModelMapper();
            return m.map(y,LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listarlugarturisticoporciudad")
    public List<LugarTuristicoPorCiudadDTO> listarlugarturisticoporciudad(@RequestParam String nombreCiudad) { // By Diego
        return lS.listarlugarturisticoporciudad(nombreCiudad).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, LugarTuristicoPorCiudadDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/listarPorCoordenadas")
    public List<LugarTuristicoDTO> findByLatitudAndLongitud(@RequestParam double latitud, @RequestParam double longitud){
        return lS.findByLatitudAndLongitud(latitud,longitud).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, LugarTuristicoDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/lugaresTuristicosMasComentarios")
    public List<LugarTuristicoPorComentarioDTO> lugaresTuristicosMasComentarios() {
        List<String[]> resultados = lS.lugaresTuristicosMasComentarios();
        return resultados.stream().map(row -> {
            LugarTuristicoPorComentarioDTO dto = new LugarTuristicoPorComentarioDTO();
            dto.setLugarTuristico(row[0]);
            dto.setCiudad(row[1]);
            dto.setTotalComentarios(Long.parseLong(row[2]));
            if (row[3] != null && !row[3].isEmpty()) {
                dto.setUltimaFechaComentario(LocalDate.parse(row[3]));
            } else {
                dto.setUltimaFechaComentario(null);
            }
            return dto;
        }).collect(Collectors.toList());
    }
}
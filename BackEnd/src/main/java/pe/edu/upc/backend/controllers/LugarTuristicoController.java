package pe.edu.upc.backend.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backend.dtos.CantidadTurismoxCiudadDTO;
import pe.edu.upc.backend.dtos.CoordenadasDTO;
import pe.edu.upc.backend.dtos.LugarTuristicoDTO;
import pe.edu.upc.backend.dtos.LugarTuristicoPorCiudadDTO;
import pe.edu.upc.backend.entities.LugarTuristico;
import pe.edu.upc.backend.serviceinterfaces.ILugarTuristicoService;

import java.util.ArrayList;
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
    @GetMapping("/listarCoordenadas")
    public List<CoordenadasDTO> obtenerCoordenadas() {
        List<String[]> lista = lS.coordenadas();
        List<CoordenadasDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            CoordenadasDTO dto = new CoordenadasDTO();
            dto.setNombreLugar(columna[0]);
            dto.setLatitudLugar(Double.parseDouble(columna[1]));
            dto.setLongitudLugar(Double.parseDouble(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}

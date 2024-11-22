package pe.edu.upc.backend.dtos;
import java.time.LocalDate;
public class LugarTuristicoPorComentarioDTO {
    private String lugarTuristico;
    private String ciudad;
    private Long totalComentarios;
    private LocalDate ultimaFechaComentario;
    public LugarTuristicoPorComentarioDTO() {}
    public LugarTuristicoPorComentarioDTO(String lugarTuristico, String ciudad, Long totalComentarios, LocalDate ultimaFechaComentario) {
        this.lugarTuristico = lugarTuristico;
        this.ciudad = ciudad;
        this.totalComentarios = totalComentarios;
        this.ultimaFechaComentario = ultimaFechaComentario;
    }
    public String getLugarTuristico() { return lugarTuristico; }
    public void setLugarTuristico(String lugarTuristico) { this.lugarTuristico = lugarTuristico; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public Long getTotalComentarios() { return totalComentarios; }
    public void setTotalComentarios(Long totalComentarios) { this.totalComentarios = totalComentarios; }
    public LocalDate getUltimaFechaComentario() { return ultimaFechaComentario; }
    public void setUltimaFechaComentario(LocalDate ultimaFechaComentario) { this.ultimaFechaComentario = ultimaFechaComentario; }
}
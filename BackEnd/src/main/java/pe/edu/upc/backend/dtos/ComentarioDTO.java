package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.LugarTuristico;
import pe.edu.upc.backend.entities.Negocio;
import pe.edu.upc.backend.entities.Usuario;
import java.time.LocalDate;
public class ComentarioDTO {
    private Long idComentario;
    private String textoComentario;
    private LocalDate fechaComentario;
    private Usuario idUsuario;
    private LugarTuristico idLugarTuristico;
    private Negocio idNegocio;
    public Long getIdComentario() {
        return idComentario;
    }
    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }
    public String getTextoComentario() {
        return textoComentario;
    }
    public void setTextoComentario(String textoComentario) {
        this.textoComentario = textoComentario;
    }
    public LocalDate getFechaComentario() {
        return fechaComentario;
    }
    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
    public Usuario getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Usuario idUsuario) { this.idUsuario = idUsuario; }
    public LugarTuristico getIdLugarTuristico() { return idLugarTuristico; }
    public void setIdLugarTuristico(LugarTuristico idLugarTuristico) { this.idLugarTuristico = idLugarTuristico; }
    public Negocio getIdNegocio() { return idNegocio; }
    public void setIdNegocio(Negocio idNegocio) { this.idNegocio = idNegocio; }
}
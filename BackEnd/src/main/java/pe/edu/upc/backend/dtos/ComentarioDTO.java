package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.LugarTuristico;
import pe.edu.upc.backend.entities.Negocio;
import pe.edu.upc.backend.entities.Usuario;
import java.time.LocalDate;
public class ComentarioDTO {
    private int idComentario;
    private String textoComentario;
    private LocalDate fechaComentario;
    private Usuario idUsuario;
    private LugarTuristico idLugarTuristico;
    private Negocio idNegocio;
    public int getIdComentario() {
        return idComentario;
    }
    public void setIdComentario(int idComentario) {
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
}
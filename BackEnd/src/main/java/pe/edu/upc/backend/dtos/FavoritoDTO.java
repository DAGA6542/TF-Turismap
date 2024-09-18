package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.LugarTuristico;
import pe.edu.upc.backend.entities.Negocio;
import pe.edu.upc.backend.entities.Usuario;
import java.time.LocalDate;
public class FavoritoDTO {
    private int idFavorito;
    private LocalDate fechaAgregadoFavorito;
    private LocalDate fechaModificacionFavorito;
    private Usuario idUsuario;
    private Negocio idNegocio;
    private LugarTuristico idLugar;
    public int getIdFavorito() {
        return idFavorito;
    }
    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }
    public LocalDate getFechaAgregadoFavorito() {
        return fechaAgregadoFavorito;
    }
    public void setFechaAgregadoFavorito(LocalDate fechaAgregadoFavorito) { this.fechaAgregadoFavorito = fechaAgregadoFavorito; }
    public LocalDate getFechaModificacionFavorito() {
        return fechaModificacionFavorito;
    }
    public void setFechaModificacionFavorito(LocalDate fechaModificacionFavorito) { this.fechaModificacionFavorito = fechaModificacionFavorito; }
    public Usuario getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Usuario idUsuario) { this.idUsuario = idUsuario; }
    public Negocio getIdNegocio() { return idNegocio; }
    public void setIdNegocio(Negocio idNegocio) { this.idNegocio = idNegocio; }
    public LugarTuristico getIdLugar() { return idLugar; }
    public void setIdLugar(LugarTuristico idLugar) { this.idLugar = idLugar; }
}

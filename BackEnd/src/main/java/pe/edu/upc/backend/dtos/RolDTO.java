package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Usuario;
public class RolDTO {
    private int idRol;
    private String nombreRol;
    private Usuario idUsuario;
    public int getIdRol() {
        return idRol;
    }
    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }
    public String getNombreRol() {
        return nombreRol;
    }
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public Usuario getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Usuario idUsuario) { this.idUsuario = idUsuario; }
}
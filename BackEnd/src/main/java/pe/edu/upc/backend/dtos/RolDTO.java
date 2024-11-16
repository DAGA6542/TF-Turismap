package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Usuario;
public class RolDTO {
    private Long idRol;
    private String nombreRol;
    private Usuario user;
    public Long getIdRol() {
        return idRol;
    }
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
    public String getNombreRol() {
        return nombreRol;
    }
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public Usuario getUser() { return user; }
    public void setUser(Usuario user) { this.user = user; }
}
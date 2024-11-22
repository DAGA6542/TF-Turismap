package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "rol"})})
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    @Column(name = "rol", nullable = false, length = 30)
    private String nombreRol;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;
    public Long getIdRol() { return idRol; }
    public void setIdRol(Long idRol) { this.idRol = idRol; }
    public String getNombreRol() { return nombreRol; }
    public void setNombreRol(String nombreRol) { this.nombreRol = nombreRol; }
    public Usuario getUser() { return user; }
    public void setUser(Usuario user) { this.user = user; }
}
package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;
    @Column(name = "textoComentario", nullable = false, length = 150)
    private String textoComentario;
    @Column(name = "fechaComentario", nullable = false)
    private LocalDate fechaComentario;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idTurismo")
    private Turismo idTurismo;
    @ManyToOne
    @JoinColumn(name = "idNegocio")
    private Negocio idNegocio;
    public Comentario() {}
    public Comentario(int idComentario, String textoComentario, LocalDate fechaComentario, Usuario idUsuario, Turismo idTurismo, Negocio idNegocio) {
        this.idComentario = idComentario;
        this.textoComentario = textoComentario;
        this.fechaComentario = fechaComentario;
        this.idUsuario = idUsuario;
        this.idTurismo = idTurismo;
        this.idNegocio = idNegocio;
    }
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
    public Usuario getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Turismo getIdTurismo() {
        return idTurismo;
    }
    public void setIdTurismo(Turismo idTurismo) {
        this.idTurismo = idTurismo;
    }
    public Negocio getIdNegocio() {
        return idNegocio;
    }
    public void setIdNegocio(Negocio idNegocio) {
        this.idNegocio = idNegocio;
    }
}

package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;
    @Column(name = "textoComentario", nullable = false, length = 250)
    private String textoComentario;
    @Column(name = "fechaComentario", nullable = false)
    private LocalDate fechaComentario;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idLugar")
    private LugarTuristico idLugar;
    @ManyToOne
    @JoinColumn(name = "idNegocio")
    private Negocio idNegocio;
    public Comentario() {}
    public Comentario(Long idComentario, String textoComentario, LocalDate fechaComentario) {
        this.idComentario = idComentario;
        this.textoComentario = textoComentario;
        this.fechaComentario = fechaComentario;
    }
    public Comentario(Long idComentario, String textoComentario, LocalDate fechaComentario, Usuario idUsuario, LugarTuristico idLugar, Negocio idNegocio) {
        this.idComentario = idComentario;
        this.textoComentario = textoComentario;
        this.fechaComentario = fechaComentario;
        this.idUsuario = idUsuario;
        this.idLugar = idLugar;
        this.idNegocio = idNegocio;
    }
    public Long getIdComentario() {
        return idComentario;
    }
    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }
    public String getTextoComentario() { return textoComentario; }
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
    public LugarTuristico getIdLugar() {
        return idLugar;
    }
    public void setIdLugar(LugarTuristico idLugar) {
        this.idLugar = idLugar;
    }
    public Negocio getIdNegocio() {
        return idNegocio;
    }
    public void setIdNegocio(Negocio idNegocio) {
        this.idNegocio = idNegocio;
    }
}
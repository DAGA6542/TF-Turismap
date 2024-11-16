package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Favorito")
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFavorito;
    @Column(name = "fechaAgregadoFavorito", nullable = false)
    private LocalDate fechaAgregadoFavorito;
    @Column(name = "fechaModificacionFavorito", nullable = false)
    private LocalDate fechaModificacionFavorito;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;
    @ManyToOne
    @JoinColumn(name = "idLugarTuristico")
    private LugarTuristico idLugarTuristico;
    @ManyToOne
    @JoinColumn(name = "idNegocio")
    private Negocio idNegocio;
    public Favorito() {}
    public Favorito(int idFavorito, LocalDate fechaAgregadoFavorito, LocalDate fechaModificacionFavorito) {
        this.idFavorito = idFavorito;
        this.fechaAgregadoFavorito = fechaAgregadoFavorito;
        this.fechaModificacionFavorito = fechaModificacionFavorito;
    }
    public Favorito(int idFavorito, LocalDate fechaAgregadoFavorito, LocalDate fechaModificacionFavorito, Usuario idUsuario, LugarTuristico idLugarTuristico, Negocio idNegocio) {
        this.idFavorito = idFavorito;
        this.fechaAgregadoFavorito = fechaAgregadoFavorito;
        this.fechaModificacionFavorito = fechaModificacionFavorito;
        this.idUsuario = idUsuario;
        this.idLugarTuristico = idLugarTuristico;
        this.idNegocio = idNegocio;
    }
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
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
    public LugarTuristico getIdLugarTuristico() {
        return idLugarTuristico;
    }
    public void setIdLugarTuristico(LugarTuristico idLugarTuristico) {
        this.idLugarTuristico = idLugarTuristico;
    }
    public Negocio getIdNegocio() {
        return idNegocio;
    }
    public void setIdNegocio(Negocio idNegocio) {
        this.idNegocio = idNegocio;
    }
}
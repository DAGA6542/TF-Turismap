package pe.edu.upc.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(name = "nombreUsuario", nullable = false, length = 50)
    private String nombreUsuario;
    @Column(name = "emailUsuario", nullable = false, length = 50)
    private String emailUsuario;
    @Column(name = "contraseniaUsuario", nullable = false, length = 250)
    private String contraseniaUsuario;
    @Column(name = "telefonoUsuario", nullable = false)
    private int telefonoUsuario;
    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol idRol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String emailUsuario, String contraseniaUsuario, int telefonoUsuario, Rol idRol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.emailUsuario = emailUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.idRol = idRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }
}

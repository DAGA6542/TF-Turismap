package pe.edu.upc.backend.entities;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "MenbresiaVIP")
public class MenbresiaVIP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenbresiaVIP;
    @Column(name = "tipoMenbresiaVIP", nullable = false, length = 50)
    private String tipoMenbresiaVIP;
    @Column(name = "fechaInicioMenbresiaVIP", nullable = false)
    private LocalDate fechaInicioMenbresiaVIP;
    @Column(name = "fechaFinMenbresiaVIP", nullable = false)
    private LocalDate fechaFinMenbresiaVIP;
    @Column(name = "estadoMenbresiaVIP", nullable = false)
    private Boolean estadoMenbresiaVIP;
    @Column(name = "beneficioMenbresiaVIP", nullable = false, length = 250)
    private String beneficioMenbresiaVIP;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public MenbresiaVIP() {
    }

    public MenbresiaVIP(int idMenbresiaVIP, String tipoMenbresiaVIP, LocalDate fechaInicioMenbresiaVIP, LocalDate fechaFinMenbresiaVIP, Boolean estadoMenbresiaVIP, String beneficioMenbresiaVIP, Usuario idUsuario) {
        this.idMenbresiaVIP = idMenbresiaVIP;
        this.tipoMenbresiaVIP = tipoMenbresiaVIP;
        this.fechaInicioMenbresiaVIP = fechaInicioMenbresiaVIP;
        this.fechaFinMenbresiaVIP = fechaFinMenbresiaVIP;
        this.estadoMenbresiaVIP = estadoMenbresiaVIP;
        this.beneficioMenbresiaVIP = beneficioMenbresiaVIP;
        this.idUsuario = idUsuario;
    }

    public int getIdMenbresiaVIP() {
        return idMenbresiaVIP;
    }

    public void setIdMenbresiaVIP(int idMenbresiaVIP) {
        this.idMenbresiaVIP = idMenbresiaVIP;
    }

    public String getTipoMenbresiaVIP() {
        return tipoMenbresiaVIP;
    }

    public void setTipoMenbresiaVIP(String tipoMenbresiaVIP) {
        this.tipoMenbresiaVIP = tipoMenbresiaVIP;
    }

    public LocalDate getFechaInicioMenbresiaVIP() {
        return fechaInicioMenbresiaVIP;
    }

    public void setFechaInicioMenbresiaVIP(LocalDate fechaInicioMenbresiaVIP) {
        this.fechaInicioMenbresiaVIP = fechaInicioMenbresiaVIP;
    }

    public LocalDate getFechaFinMenbresiaVIP() {
        return fechaFinMenbresiaVIP;
    }

    public void setFechaFinMenbresiaVIP(LocalDate fechaFinMenbresiaVIP) {
        this.fechaFinMenbresiaVIP = fechaFinMenbresiaVIP;
    }

    public Boolean getEstadoMenbresiaVIP() {
        return estadoMenbresiaVIP;
    }

    public void setEstadoMenbresiaVIP(Boolean estadoMenbresiaVIP) {
        this.estadoMenbresiaVIP = estadoMenbresiaVIP;
    }

    public String getBeneficioMenbresiaVIP() {
        return beneficioMenbresiaVIP;
    }

    public void setBeneficioMenbresiaVIP(String beneficioMenbresiaVIP) {
        this.beneficioMenbresiaVIP = beneficioMenbresiaVIP;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
package pe.edu.upc.backend.dtos;
import pe.edu.upc.backend.entities.Usuario;
import java.time.LocalDate;
public class MenbresiaVIPDTO {
    private int idMenbresiaVIP;
    private String tipoMenbresiaVIP;
    private LocalDate fechaInicioMenbresiaVIP;
    private LocalDate fechaFinMenbresiaVIP;
    private Boolean estadoMenbresiaVIP;
    private String beneficioMenbresiaVIP;
    private Usuario idUsuario;
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
    public void setFechaInicioMenbresiaVIP(LocalDate fechaInicioMenbresiaVIP) { this.fechaInicioMenbresiaVIP = fechaInicioMenbresiaVIP; }
    public LocalDate getFechaFinMenbresiaVIP() {
        return fechaFinMenbresiaVIP;
    }
    public void setFechaFinMenbresiaVIP(LocalDate fechaFinMenbresiaVIP) { this.fechaFinMenbresiaVIP = fechaFinMenbresiaVIP; }
    public Boolean getEstadoMenbresiaVIP() {
        return estadoMenbresiaVIP;
    }
    public void setEstadoMenbresiaVIP(Boolean estadoMenbresiaVIP) {
        this.estadoMenbresiaVIP = estadoMenbresiaVIP;
    }
    public String getBeneficioMenbresiaVIP() {
        return beneficioMenbresiaVIP;
    }
    public void setBeneficioMenbresiaVIP(String beneficioMenbresiaVIP) { this.beneficioMenbresiaVIP = beneficioMenbresiaVIP; }
    public Usuario getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}

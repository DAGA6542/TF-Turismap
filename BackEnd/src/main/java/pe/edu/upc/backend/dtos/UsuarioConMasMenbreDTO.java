package pe.edu.upc.backend.dtos;
import java.time.LocalDate;
public class UsuarioConMasMenbreDTO {
    private String usuario;
    private String tipoMembresia;
    private String beneficios;
    private LocalDate inicio;
    private LocalDate fin;
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getTipoMembresia() { return tipoMembresia; }
    public void setTipoMembresia(String tipoMembresia) { this.tipoMembresia = tipoMembresia; }
    public String getBeneficios() { return beneficios; }
    public void setBeneficios(String beneficios) { this.beneficios = beneficios; }
    public LocalDate getInicio() { return inicio; }
    public void setInicio(LocalDate inicio) { this.inicio = inicio; }
    public LocalDate getFin() { return fin; }
    public void setFin(LocalDate fin) { this.fin = fin; }
}
package pe.edu.upc.backend.dtos;
public class UsuarioPorComentarioDTO {
    private String usuario;
    private Long totalComentarios;
    public UsuarioPorComentarioDTO() {}
    public UsuarioPorComentarioDTO(String usuario, Long totalComentarios) {
        this.usuario = usuario;
        this.totalComentarios = totalComentarios;
    }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public Long getTotalComentarios() { return totalComentarios; }
    public void setTotalComentarios(Long totalComentarios) { this.totalComentarios = totalComentarios; }
}
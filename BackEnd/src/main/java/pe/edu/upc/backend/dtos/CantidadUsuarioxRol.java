package pe.edu.upc.backend.dtos;
public class CantidadUsuarioxRol {
    private String NombreRol;
    private int CantidadUsuario;
    public String getNombreRol() {
        return NombreRol;
    }
    public void setNombreRol(String nombreRol) {
        NombreRol = nombreRol;
    }
    public int getCantidadUsuario() {
        return CantidadUsuario;
    }
    public void setCantidadUsuario(int cantidadUsuario) {
        CantidadUsuario = cantidadUsuario;
    }
}
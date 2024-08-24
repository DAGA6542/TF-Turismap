package pe.edu.upc.backend.serviceinterfaces;

import pe.edu.upc.backend.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public void insert(Usuario usuario);
    public List<Usuario> list();
    public void delete(int idUsuario);
}

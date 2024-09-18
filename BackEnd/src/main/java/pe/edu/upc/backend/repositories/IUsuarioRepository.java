package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Buscar usuarios por nombre
    @Query(value = "Select * from Usuario where nombre_usuario like %:partialName%", nativeQuery = true)
    List<Usuario> buscarPorNombre(String partialName);
    //  Buscar usuarios por correo electrónico
    @Query(value = "SELECT * from Usuario where email_usuario = %:emailUsuario%", nativeQuery = true)
    Usuario buscarPorEmail(String emailUsuario);
    // Listar usuarios por rol
    @Query(value = "Select * from Usuario where id_rol = %:idRol%", nativeQuery = true)
    List<Usuario> buscarPorRol(int idRol);
    // Buscar usuarios por número de teléfono
    @Query(value = "Select * from Usuario where telefono_usuario = %:telefonoUsuario%", nativeQuery = true)
    Usuario buscarPorTelefono(int telefonoUsuario);
    //  Listar usuarios ordenados por nombre en orden ascendente
    @Query(value = "Select * from Usuario order by nombre_usuario asc", nativeQuery = true)
    List<Usuario> listarPorNombreAscendente();
    public Usuario findOneByUsername(String username);
}
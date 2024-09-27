package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Usuario;
import java.util.List;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Buscar usuarios por nombre
    @Query(value = "Select * from Usuario where nombre_usuario like %:partialName%", nativeQuery = true)
    public List<Usuario> buscarPorNombre(@Param("partialName") String partialName);
    //  Buscar usuarios por correo electrónico
    @Query(value = "SELECT * from Usuario where email_usuario = %:emailUsuario%", nativeQuery = true)
    public Usuario buscarPorEmail(@Param("emailUsuario") String emailUsuario);
    // Listar usuarios por rol
    @Query(value = "Select * from Usuario where id_rol = %:idRol%", nativeQuery = true)
    public List<Usuario> buscarPorRol(@Param("idRol") int idRol);
    // Buscar usuarios por número de teléfono
    @Query(value = "Select * from Usuario where telefono_usuario = %:telefonoUsuario%", nativeQuery = true)
    public Usuario buscarPorTelefono(@Param("telefonoUsuario") int telefonoUsuario);
    //  Listar usuarios ordenados por nombre en orden ascendente
    @Query(value = "Select * from Usuario order by nombre_usuario asc", nativeQuery = true)
    public List<Usuario> listarPorNombreAscendente();
    public Usuario findOneByUsername(String username);
    @Query(value = "SELECT u.* FROM Usuario u " +
            " JOIN Comentario c ON u.id_usuario = c.id_usuario " +
            " JOIN Negocio n ON c.id_negocio = n.id_negocio " +
            " WHERE n.nombre_negocio LIKE CONCAT('%', :nombre_negocio, '%')", nativeQuery = true)
    public List<Usuario> obtenerComentario(@Param("nombre_negocio") String nombre_negocio);
    @Query(value = "insert into rol (nombre_rol, usuario) SELECT :nombre_rol, u FROM usuario u WHERE u.id_usuario = :id_usuario", nativeQuery = true)
    public void registrarRolUsuario(@Param("nombre_rol") String nombreRol, @Param("id_usuario") Long id_usuario);
}

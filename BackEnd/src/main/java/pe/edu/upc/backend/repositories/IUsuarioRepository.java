package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Usuario;
import java.util.List;
@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    // Buscar usuarios por nombre
    @Query(value = "Select * from Usuario where nombre_usuario like %:partialName%", nativeQuery = true)
    List<Usuario> buscarPorNombre(String partialName);
    //  Buscar usuarios por correo electrónico
    @Query(value = "SELECT * from Usuario where email_usuario = %:emailUsuario%", nativeQuery = true)
    Usuario buscarPorEmail(String emailUsuario);
    // Listar usuarios por rol
    @Query(value = "Select * from Usuario where id_rol = %:idRol%", nativeQuery = true)
    List<Usuario> buscarPorRol(@Param("idRol") Long idRol);
    // Buscar usuarios por número de teléfono
    @Query(value = "Select * from Usuario where telefono_usuario = %:telefonoUsuario%", nativeQuery = true)
    Usuario buscarPorTelefono(int telefonoUsuario);
    //  Listar usuarios ordenados por nombre en orden ascendente
    @Query(value = "Select * from Usuario order by nombre_usuario asc", nativeQuery = true)
    List<Usuario> listarPorNombreAscendente();
    public Usuario findOneByUsername(String username);
    @Query(value = " SELECT u.* \n" +
        " FROM usuario u \n" +
        " INNER JOIN comentario c ON u.id_usuario = c.id_usuario \n" +
        " INNER JOIN negocio n ON c.id_negocio = n.id_negocio \n" +
        " WHERE LOWER(n.nombre_negocio) LIKE LOWER(CONCAT('%', :nombreNegocio, '%')) ", nativeQuery = true)
    List<Usuario> buscarUsuariosPorComentariosEnNegocio(@Param("nombreNegocio") String nombreNegocio);
    // Usuarios con más comentarios realizados
    @Query(value = " SELECT \n" +
            " u.nombre_usuario AS usuario, \n" +
            " COUNT(c.id_comentario) AS totalComentarios \n" +
        " FROM \n" +
            " usuario u \n" +
        " LEFT JOIN \n" +
            " comentario c ON u.id_usuario = c.id_usuario \n" +
        " GROUP BY \n" +
            " u.id_usuario, u.nombre_usuario \n" +
        " HAVING \n" +
            " COUNT(c.id_comentario) > 0 \n" +
        " ORDER BY \n" +
            " totalComentarios DESC ", nativeQuery = true)
    public List<String[]> usuariosConMasComentariosRealizados();
}
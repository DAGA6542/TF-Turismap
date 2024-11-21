package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.upc.backend.entities.Departamento;
import java.util.List;
@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {
    // Buscar departamento por nombre
    @Query("Select d from Departamento d where lower(d.nombreDepartamento) = lower(:nombre)")
    public List<Departamento> buscarPorNombre(@Param("nombre") String nombre);
    // Listar departamento por pais
    @Query("Select d from Departamento d where d.idPais.idPais = :idPais")
    public List<Departamento> listarPorPais(@Param("idPais") int idPais);
    // Obtener departamentos con población mayor a un cierto umbral
    @Query("Select d from Departamento d where d.poblacionDepartamento > :poblacion")
    public List<Departamento> obtenerDepartamentPoblac(@Param("poblacion") Long poblacion);
    // Buscar departamentos con superficie dentro de un rango específico
    @Query("Select d from Departamento d where d.superficieDepartamento between :minSuperficie and :maxSuperficie")
    public List<Departamento> buscarDepartamentoConSuperficie(@Param("minSuperficie") int minSuperficie, @Param("maxSuperficie") int maxSuperficie);
    // Listar departamentos ordenados por población de forma descendente
    @Query("Select d from Departamento d order by d.poblacionDepartamento desc")
    public List<Departamento> obtenerPorPoblacionDesc();
    // Buscar departamentos por la capital
    @Query("Select d from Departamento d where LOWER(d.capitalDepartamento) like lower(concat('%', :capital, '%'))")
    public List<Departamento> buscarPorCapital(@Param("capital") String capital);
}
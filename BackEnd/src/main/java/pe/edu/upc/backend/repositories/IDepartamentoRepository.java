package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.backend.entities.Departamento;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDepartamentoRepository extends JpaRepository<Departamento, Integer> {
    @Query("SELECT d FROM Departamento d WHERE LOWER(d.nombreDepartamento) = LOWER(:nombre)")
    List<Departamento> buscarPorNombre(@Param("nombre") String nombre); // Buscar departamento por nombre
    @Query("SELECT d FROM Departamento d WHERE d.idPais.idPais = :idPais")
    List<Departamento> listarPorPais(@Param("idPais") int idPais); // Listar departamento por pais
    @Query("SELECT d FROM Departamento d WHERE d.poblacionDepartamento > :poblacion")
    List<Departamento> obtenerDepartamentPoblac(@Param("poblacion") Long poblacion); // Obtener departamentos con población mayor a un cierto umbral
    @Query("SELECT d FROM Departamento d WHERE d.superficieDepartamento BETWEEN :minSuperficie AND :maxSuperficie")
    List<Departamento> buscarDepartamentoConSuperficie(@Param("minSuperficie") int minSuperficie, @Param("maxSuperficie") int maxSuperficie); // Buscar departamentos con superficie dentro de un rango específico
    @Query("SELECT d FROM Departamento d ORDER BY d.poblacionDepartamento DESC")
    List<Departamento> obtenerPorPoblacionDesc(); // Listar departamentos ordenados por población de forma descendente
    @Query("SELECT d FROM Departamento d WHERE LOWER(d.capitalDepartamento) LIKE LOWER(CONCAT('%', :capital, '%'))")
    List<Departamento> buscarPorCapital(@Param("capital") String capital); //Buscar departamentos por la capital

}
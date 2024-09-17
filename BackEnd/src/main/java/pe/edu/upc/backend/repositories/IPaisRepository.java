package pe.edu.upc.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import pe.edu.upc.backend.entities.Pais;
import java.util.List;
@Repository
public interface IPaisRepository extends JpaRepository<Pais, Integer> {
    // Obtener países por continente
    @Query("Select p from Pais p where p.continentePais = :continente")
    public List<Pais> obtenerPorContinente(@RequestParam("continente") String continente);
    // Buscar países por nombre
    @Query("Select p from Pais p where p.nombrePais like %:nombre%")
    public List<Pais> obtenerPorNombre(@RequestParam("nombre") String nombre);
    // Obtener países con población mayor a un valor específico
    @Query("Select p from Pais p where p.poblacionPais > :poblacion")
    public List<Pais> obtenerPorPoblacionMayor(@RequestParam("poblacion") Long poblacion);
    // Obtener países por código ISO
    @Query("Select p from Pais p where p.codigoIsoPais = :codigoIso")
    public Pais obtenerPorCodigoIso(@RequestParam("codigoIso") String codigoIso);
    // Contar países en un continente específico
    @Query("Select count(p) from Pais p where p.continentePais = :continente")
    public long obtenerCantidadPaisEnUnContinente(@RequestParam("continente") String continente);
    // Obtener países cuya superficie es mayor que un valor dado
    @Query("Select p from Pais p where p.superficiePais > :superficie")
    public List<Pais> obtenerSuperficieMayor(@RequestParam("superficie") int superficie);
    // Obtener países con una moneda específica
    @Query("Select p from Pais p where p.monedaPais = :moneda")
    public List<Pais> obtenerPorMoneda(@RequestParam("moneda") String moneda);
    // Obtener países por idioma oficial
    @Query("Select p from Pais p where p.idiomaOficialPais = :idioma")
    public List<Pais> obtenerPorIdioma(@RequestParam("idioma") String idioma);
    // Obtener países cuya capital es igual a un valor dado
    @Query("Select p from Pais p where p.capitalPais = :capital")
    public Pais obtenerPorCapital(@RequestParam("capital") String capital);
}
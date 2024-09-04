package pe.edu.upc.backend.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PromocionTuristica")
public class PromocionTuristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPromocion;
    @Column(name = "nombrePromocion", nullable = false, length = 50)
    private String nombrePromocion;
    @Column(name = "descripcionPromocion", nullable = false, length = 150)
    private String descripcionPromocion;
    @Column(name = "precioPromocion", nullable = false)
    private double precioPromocion;
    @Column(name = "descuentoPromocion", nullable = false)
    private double descuentoPromocion;
    @Column(name = "fechaInicioPromocion", nullable = false)
    private LocalDate fechaInicioPromocion;
    @Column(name = "fechaFinPromocion", nullable = false)
    private LocalDate fechaFinPromocion;
}
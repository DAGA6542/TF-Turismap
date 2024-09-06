package pe.edu.upc.backend.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.backend.entities.Ciudad;
import pe.edu.upc.backend.entities.PromocionTuristica;

public class TurismoDTO {
    private int idTurismo;

    private String nombreTurismo;

    private String descripcionTurismo;

    private int numeroTelefonoTurismo;

    private Ciudad idCiudad;

    private PromocionTuristica idPromocion;

    public int getIdTurismo() {
        return idTurismo;
    }

    public void setIdTurismo(int idTurismo) {
        this.idTurismo = idTurismo;
    }

    public String getNombreTurismo() {
        return nombreTurismo;
    }

    public void setNombreTurismo(String nombreTurismo) {
        this.nombreTurismo = nombreTurismo;
    }

    public String getDescripcionTurismo() {
        return descripcionTurismo;
    }

    public void setDescripcionTurismo(String descripcionTurismo) {
        this.descripcionTurismo = descripcionTurismo;
    }

    public int getNumeroTelefonoTurismo() {
        return numeroTelefonoTurismo;
    }

    public void setNumeroTelefonoTurismo(int numeroTelefonoTurismo) {
        this.numeroTelefonoTurismo = numeroTelefonoTurismo;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public PromocionTuristica getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(PromocionTuristica idPromocion) {
        this.idPromocion = idPromocion;
    }
}

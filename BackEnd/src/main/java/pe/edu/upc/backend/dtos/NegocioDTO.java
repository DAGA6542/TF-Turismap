package pe.edu.upc.backend.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.backend.entities.Ciudad;

public class NegocioDTO {
    private int idNegocio;

    private String nombreNegocio;

    private String horarioNegocio;

    private int numeroTelefonoNegocio;

    private int calificacionNegocio;

    private Ciudad idCiudad;

    public int getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(int idNegocio) {
        this.idNegocio = idNegocio;
    }

    public String getNombreNegocio() {
        return nombreNegocio;
    }

    public void setNombreNegocio(String nombreNegocio) {
        this.nombreNegocio = nombreNegocio;
    }

    public String getHorarioNegocio() {
        return horarioNegocio;
    }

    public void setHorarioNegocio(String horarioNegocio) {
        this.horarioNegocio = horarioNegocio;
    }

    public int getNumeroTelefonoNegocio() {
        return numeroTelefonoNegocio;
    }

    public void setNumeroTelefonoNegocio(int numeroTelefonoNegocio) {
        this.numeroTelefonoNegocio = numeroTelefonoNegocio;
    }

    public int getCalificacionNegocio() {
        return calificacionNegocio;
    }

    public void setCalificacionNegocio(int calificacionNegocio) {
        this.calificacionNegocio = calificacionNegocio;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }
}

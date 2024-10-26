/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author Valentina
 */
public class Multa {
    private String identificacion;
    private String fechaMulta;
    private String fechaEventoMulta;
    private String espacioMulta;
    private String propiedad;
    private String personaOriginaEvento;
    private String descripcionEvento;
    private String valorMulta;

    public Multa() {
    }

    public Multa(String identificacion, String fechaMulta, String fechaEventoMulta, String espacioMulta, String propiedad, String personaOriginaEvento, String descripcionEvento, String valorMulta) {
        this.identificacion = identificacion;
        this.fechaMulta = fechaMulta;
        this.fechaEventoMulta = fechaEventoMulta;
        this.espacioMulta = espacioMulta;
        this.propiedad = propiedad;
        this.personaOriginaEvento = personaOriginaEvento;
        this.descripcionEvento = descripcionEvento;
        this.valorMulta = valorMulta;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getFechaMulta() {
        return fechaMulta;
    }

    public void setFechaMulta(String fechaMulta) {
        this.fechaMulta = fechaMulta;
    }

    public String getFechaEventoMulta() {
        return fechaEventoMulta;
    }

    public void setFechaEventoMulta(String fechaEventoMulta) {
        this.fechaEventoMulta = fechaEventoMulta;
    }

    public String getEspacioMulta() {
        return espacioMulta;
    }

    public void setEspacioMulta(String espacioMulta) {
        this.espacioMulta = espacioMulta;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    public String getPersonaOriginaEvento() {
        return personaOriginaEvento;
    }

    public void setPersonaOriginaEvento(String personaOriginaEvento) {
        this.personaOriginaEvento = personaOriginaEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(String valorMulta) {
        this.valorMulta = valorMulta;
    }

    @Override
    public String toString() {
        return "Multa{" + "identificacion=" + identificacion + ", fechaMulta=" + fechaMulta + ", fechaEventoMulta=" + fechaEventoMulta + ", espacioMulta=" + espacioMulta + ", propiedad=" + propiedad + ", personaOriginaEvento=" + personaOriginaEvento + ", descripcionEvento=" + descripcionEvento + ", valorMulta=" + valorMulta + '}';
    }

   
    
}

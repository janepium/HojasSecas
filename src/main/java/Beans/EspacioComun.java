/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author Valentina
 */
public class EspacioComun {
    private String nombreLugar;
    private String horaInicio;
    private String horaFin;
    private String disponibilidad;
    
    public EspacioComun(String nombreLugar, String horaInicio, String horaFin, String disponibilidad) {
        this.nombreLugar = nombreLugar;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponibilidad = disponibilidad;
    }

    // Getters
    public String getNombreLugar() {
        return nombreLugar;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    // Setters
    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}

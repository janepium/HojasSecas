/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author Valentina
 */
public class Propietario {
    private String nombre;
    private String edad;
    private String id;
    private String email;
    private String celular;
    private String sexo;
    private String ocupacion;
    private String fechaCompra;
    private String propiedad;

    public Propietario() {
    }

    public Propietario(String nombre, String edad, String id, String email, String celular, String sexo, String ocupacion, String propiedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.email = email;
        this.celular = celular;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.propiedad = propiedad;
    }
    
    
    public Propietario(String nombre, String edad, String id, String email, String celular, String sexo, String ocupacion, String fechaCompra, String propiedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
        this.email = email;
        this.celular = celular;
        this.sexo = sexo;
        this.ocupacion = ocupacion;
        this.fechaCompra = fechaCompra;
        this.propiedad = propiedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(String propiedad) {
        this.propiedad = propiedad;
    }

    @Override
    public String toString() {
        return "Propietario{" + "nombre=" + nombre + ", edad=" + edad + ", id=" + id + ", email=" + email + ", celular=" + celular + ", sexo=" + sexo + ", ocupacion=" + ocupacion + ", fechaCompra=" + fechaCompra + ", propiedad=" + propiedad + '}';
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;
import Beans.EspacioComun;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Valentina
 */
public class GestionDeCSV {
    private List<EspacioComun> listaDatos;  // Lista para almacenar los datos

    public GestionDeCSV() {
        listaDatos = new ArrayList<>();  // Inicialización de la lista
    }

    // Método que agrega datos y los guarda en el archivo CSV
    public void agregarYGuardarDatos(String nombreLugar, String horaInicio, String horaFin, String disponibilidad) {
        // Definir la ruta del archivo
        String rutaArchivo = "RegistroEspaciosComunes.csv"; // Define la ruta del archivo

        // Crear un nuevo objeto EspacioComun
        EspacioComun espacio = new EspacioComun(nombreLugar, horaInicio, horaFin, disponibilidad);
        
        // Agregar los datos a la lista
        listaDatos.add(espacio);
        
        // Guardar los datos en el archivo CSV
        File file = new File(rutaArchivo);
        boolean fileExists = file.exists();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) { // El modo "true" permite agregar datos sin borrar lo existente
            // Escribir el encabezado solo si el archivo es nuevo
            if (!fileExists) {
                bw.write("Nombre_Lugar;Hora_Inicio;Hora_Fin;Disponibilidad\n"); // Escribir el encabezado
            }
            // Escribir los datos almacenados
            bw.write(String.join(";", espacio.getNombreLugar(), espacio.getHoraInicio(), espacio.getHoraFin(), espacio.getDisponibilidad()) + "\n"); // Guardar el último agregado
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método que carga los datos desde el archivo CSV
    public void cargarDatosDesdeCSV(String rutaArchivo) {
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            br.readLine(); // Saltar el encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";", -1);
                // Crear un nuevo objeto EspacioComun y agregarlo a la lista
                EspacioComun espacio = new EspacioComun(datos[0], datos[1], datos[2], datos[3]);
                listaDatos.add(espacio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    
    public List<EspacioComun> getListaDatos() {
        return listaDatos;
    }

    public EspacioComun buscarLugar(String nombreLugar) {
        for (EspacioComun espacioComun : listaDatos) {

            if (espacioComun.getNombreLugar().equals(nombreLugar)) {
                return espacioComun;  // Usuario encontrado
            }
        }
        return null;  // Usuario no encontrado
    }

    public List<EspacioComun> leerCSV(String rutaArchivo) {
        
        listaDatos = new ArrayList<EspacioComun>();
        String linea;
        try (BufferedReader br = new BufferedReader(new FileReader("RegistroUsuario.csv"))) {
            br.readLine();
            while ((linea = br.readLine()) != null) {
                
                // Separar por punto y coma
                String[] valores = linea.split(";", -1);
                
                String nombreLugar = valores[0];
                String horaInicio = valores[1];
                
                String horaFin = (String)valores[2];
                String disponibilidad = valores[3];
                

                EspacioComun espacioComun = new EspacioComun(nombreLugar,  horaInicio,  horaFin,  disponibilidad);
                // Agregar el usuario a la lista
                listaDatos.add(espacioComun);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return listaDatos;
    }
    public boolean actualizarZonaComun(String nombreLugar, EspacioComun nuevosDatos) {
        for (EspacioComun zona : listaDatos) {
            if (zona.getNombreLugar().equalsIgnoreCase(nombreLugar)) {
                zona.setHoraInicio(nuevosDatos.getHoraInicio());
                zona.setHoraFin(nuevosDatos.getHoraFin());
                zona.setDisponibilidad(nuevosDatos.getDisponibilidad());
                return true;
            }
        }
        return false; // Si no se encuentra la zona común, devuelve falso
    }
    
    public void guardarEnCSV(String rutaArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (EspacioComun zona : listaDatos) {
                pw.println(zona.getNombreLugar() + "," + zona.getHoraInicio() + "," + zona.getHoraFin() + "," + zona.getDisponibilidad());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

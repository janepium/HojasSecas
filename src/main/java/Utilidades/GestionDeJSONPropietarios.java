/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;
import Beans.Propietario;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Valentina
 */
public class GestionDeJSONPropietarios {
    private List<String> ocupaciones = new ArrayList<>();
    public List<Propietario> leerJSON(String rutaArchivo) {
        
        List<Propietario> propietarios = new ArrayList<>();
        
        try (FileReader reader = new FileReader("propietarios.json")) {
            // Instanciar Gson y definir el tipo de la lista
            Gson gson = new Gson();
            Type propietariosListType = new TypeToken<ArrayList<Propietario>>() {}.getType();
            
            // Deserializar el JSON al tipo esperado
            propietarios = gson.fromJson(reader, propietariosListType);
            
            // Confirmación para verificar que se leyeron los datos
            System.out.println("Datos leídos: " + propietarios);//debug
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
        return propietarios;
    }
        
    // Método para cargar personas al archivo JSON
    private List<Propietario> cargarPropietarios() {
        List<Propietario> personas = new ArrayList<>();
        try {
            // Verificar si el archivo existe y cargar los datos
            FileReader reader = new FileReader("propietarios.json");
            Type personaListType = new TypeToken<ArrayList<Propietario>>() {}.getType();
            Gson gson = new Gson();
            personas = gson.fromJson(reader, personaListType);
            reader.close();
        } catch (IOException e) {
            // Si el archivo no existe, creamos una nueva lista
            System.out.println("No se encontró el archivo. Se creará uno nuevo.");
        }
        return personas;
    }
        
    // Método para guardar la lista de personas en el archivo JSON
    public void guardarJson(String nombre, String edad, String id, String email, String celular, String sexo, String ocupacion, String fechaCompra, String propiedad) {
        // Cargar las personas existentes
        List<Propietario> propietarios = cargarPropietarios();

        // Crear el nuevo objeto Persona
        Propietario nuevaPropietario = new Propietario(nombre, edad,  id,  email,  celular,  sexo,  ocupacion,  fechaCompra,  propiedad);
        
        // Agregar la nueva persona a la lista
        propietarios.add(nuevaPropietario);

        // Convertir la lista de personas a JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(propietarios);

        // Guardar el JSON en un archivo
        try (FileWriter file = new FileWriter("propietarios.json")) {
            file.write(json);
            file.flush();
            System.out.println("Archivo JSON actualizado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ocupaciones.add(ocupacion);
    }
    public List<String> getOcupaciones() {
        return ocupaciones;
    }
    
    public void generarPdfOcupaciones(String rutaPdf) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(rutaPdf));
        document.open();

        document.add(new Paragraph("Lista de Ocupaciones Registradas\n\n"));
        for (String ocupacion : ocupaciones) {
            document.add(new Paragraph(ocupacion));
        }

        document.close();
    }
    
    public Propietario buscarPropietarioPorId(String id) {
        List<Propietario> propietarios = cargarPropietarios();
        for (Propietario propietario : propietarios) {
            if (propietario.getId().equals(id)) {
                return propietario;
            }
        }
        System.out.println("No se encontró un propietario con el ID: " + id);
        return null;
    }
    
    public boolean actualizarPropietario(String id, Propietario nuevosDatos) {
        List<Propietario> propietarios = cargarPropietarios();
        boolean actualizado = false;

        // Buscar el propietario en la lista y actualizarlo si coincide el id
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).getId().equals(id)) {
                propietarios.set(i, nuevosDatos);
                actualizado = true;
                break;
            }
        }

        if (actualizado) {
            // Guardar la lista actualizada en el JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try (FileWriter file = new FileWriter("propietarios.json")) {
                file.write(gson.toJson(propietarios));
                System.out.println("Propietario con id " + id + " fue actualizado.");
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo JSON: " + e.getMessage());
            }
        } else {
            System.out.println("No se encontró el propietario con id " + id + ".");
        }

        return actualizado;
    }
    
}

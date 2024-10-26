/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Beans.Multa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ManejoDeJSONMultas {

    // Método para leer el JSON como una lista de multas
    public List<Multa> leerJSON(String rutaArchivo) {
        List<Multa> multas = new ArrayList<>();
        Gson gson = new Gson();
        Type multasListType = new TypeToken<ArrayList<Multa>>() {}.getType();

        try (FileReader reader = new FileReader(rutaArchivo)) {
            // Intenta deserializar el archivo como lista de multas
            multas = gson.fromJson(reader, multasListType);
            System.out.println("Datos leídos: " + multas); // Confirmación de depuración
        } catch (JsonSyntaxException e) {
            System.err.println("Error de sintaxis en el JSON, intentando leer como objeto único: " + e.getMessage());
            // Si el archivo contiene un solo objeto, intenta deserializar como un solo objeto `Multa`
            try (FileReader reader = new FileReader(rutaArchivo)) {
                Multa multaUnica = gson.fromJson(reader, Multa.class);
                if (multaUnica != null) {
                    multas.add(multaUnica);
                }
            } catch (IOException innerEx) {
                System.err.println("Error al leer el archivo JSON: " + innerEx.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
        }
        return multas;
    }

    // Método para cargar multas existentes o crear una lista nueva
    private List<Multa> cargarMultas() {
        List<Multa> multas = new ArrayList<>();
        try {
            // Intentar leer el archivo y cargar los datos
            FileReader reader = new FileReader("registromultas.json");
            Type multaListType = new TypeToken<ArrayList<Multa>>() {}.getType();
            Gson gson = new Gson();
            multas = gson.fromJson(reader, multaListType);
            reader.close();
        } catch (IOException e) {
            System.out.println("No se encontró el archivo. Se creará uno nuevo.");
        } catch (JsonSyntaxException e) {
            System.err.println("Error en el formato del archivo JSON: " + e.getMessage());
        }
        return multas;
    }

    // Método para guardar una nueva multa en el archivo JSON
    public void guardarJson(String identificacion, String fechaMulta, String fechaEventoMulta, String espacioMulta, String propiedad, String personaOriginaEvento, String descripcionEvento, String valorMulta) {
        // Cargar las multas existentes
        List<Multa> multas = cargarMultas();

        // Crear la nueva multa
        Multa nuevaMulta = new Multa(identificacion, fechaMulta, fechaEventoMulta, espacioMulta, propiedad, personaOriginaEvento, descripcionEvento, valorMulta);
        
        // Agregar la nueva multa a la lista
        multas.add(nuevaMulta);

        // Convertir la lista de multas a JSON y guardar en el archivo
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(multas);

        try (FileWriter file = new FileWriter("registromultas.json")) {
            file.write(json);
            file.flush();
            System.out.println("Archivo JSON actualizado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

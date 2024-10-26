/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author Valentina
 */
public class GestionDePDF {
     public void generarPDF(String numeroFactura, String fecha,String propiedad, String propietario, String valorPagar, String totalPagar, String descuentos, String otrosCargos, String id) {
        // Ruta donde se guardará el PDF
        String rutaCarpeta = "C:\\Users\\Valentina\\Desktop\\GranLuna";
        String rutaArchivo = rutaCarpeta + "Factura.pdf";

        // Crear la carpeta si no existe
        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdirs(); // Crea las carpetas necesarias
        }

        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
            document.open();

            // Agregar contenido al PDF
            document.add(new Paragraph("Factura Número: " + numeroFactura));
            document.add(new Paragraph("Fecha: " + fecha));
            document.add(new Paragraph("Propiedad: " + propiedad));
            document.add(new Paragraph("Propietario: " + propietario));
            document.add(new Paragraph("Numero de documento de identidad: " + id));
            document.add(new Paragraph("Valor a Pagar: $" + valorPagar));
            document.add(new Paragraph("Valor a Pagar: $" + valorPagar));
            document.add(new Paragraph("Descuentos: $" + descuentos));
            document.add(new Paragraph("Otros cargos: $" + otrosCargos));
            
            document.add(new Paragraph("Gracias por su preferencia."));

            System.out.println("PDF creado exitosamente en: " + rutaArchivo);
        } catch (DocumentException | IOException e) {
            System.err.println("Error al generar el PDF: " + e.getMessage());
        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }
        
    }
     
    
}

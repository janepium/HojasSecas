/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import Ventanas.MenuAdmin;
import Ventanas.MenuPropietario;
import javax.swing.JOptionPane;

/**
 *
 * @author Valentina
 */
public class GestionDeLogica {
    public static String validarUsuario(String usuario, String contraseña) {
        // Datos quemados: usuario y contraseña con roles asociados
        if (usuario.equals("admin") && contraseña.equals("admin123")) {
            return "Administrador";
        } else if (usuario.equals("propietario") && contraseña.equals("prop123")) {
            return "Propietario";
        } else {
            return null; // Usuario no válido
        }
    }
    
    public void iniciarSesion(String usuario, String contraseña) {
        String rol = validarUsuario(usuario, contraseña);

        if (rol != null) {
            abrirVentanaPorRol(rol);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirVentanaPorRol(String rol) {
        switch (rol) {
            case "Administrador":
                new MenuAdmin().setVisible(true);
                break;
            case "Propietario":
                new MenuPropietario().setVisible(true);
                break;
      
    }
    }
}

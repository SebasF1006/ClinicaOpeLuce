/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

/**
 *
 * @author HP
 */
public class Pruebaa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String correo = "fdjifadij@hotmail.com";
        Boolean rspta = CorreoEsGmail(correo);
        if (!rspta) {
            System.out.println("INGRESA BUEN CORREO");
        }
    }
    
    public static Boolean CorreoEsGmail(String correo){
        return correo.endsWith("@gmail.com");
    }
    
}

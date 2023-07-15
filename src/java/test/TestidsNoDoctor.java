/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author HP
 */
public class TestidsNoDoctor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String tipo_cita="Retina";
        LocalTime hora = LocalTime.parse("20:00:00");
        LocalDate fecha = LocalDate.parse("2022-10-15");
        
        DaoCita dao = new DaoCitaImpl();
        List <Integer> lista = dao.idsNoDoctor(tipo_cita, hora, fecha);
        try {
            System.out.println(lista.get(0));
        } catch (Exception e) {
            dao.getMessage();
        }
    }
    
}

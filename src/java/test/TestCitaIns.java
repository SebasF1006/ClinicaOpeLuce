package test;

import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import entidades.Cita;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class TestCitaIns {
    
    public static void main(String[] args) {

        Cita cita = new Cita();
        cita.setIdpacientes(16);
        cita.setIddoctor(2);
        cita.setTipo_cita("Consulta General");
        cita.setCosto_cita(70d);
        cita.setHora_cita(LocalTime.parse("18:00:00"));
        cita.setFecha_cita(LocalDate.parse("2022-06-03"));
        cita.setDiagnostico_cita(" ");
        
        DaoCita dao = new DaoCitaImpl();
        try {
            System.out.println(dao.citaIns(cita));
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }
    
}

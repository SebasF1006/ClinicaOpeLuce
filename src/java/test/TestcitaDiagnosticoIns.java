package test;

import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import java.time.LocalDate;


public class TestcitaDiagnosticoIns {
   
    public static void main(String[] args) {



        DaoCita dao = new DaoCitaImpl();
        String mensaje = "Debes mejorar";
        Integer x = 67;
        try {
            System.out.println(dao.citaDiagnosticoIns(x,mensaje));
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

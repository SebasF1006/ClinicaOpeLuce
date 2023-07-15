package test;

import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import entidades.Cita;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCitaSel3 {

    public static void main(String[] args) {

        //TEST METODO citaSel()
        List<Cita> listado = null;
        DaoCita dao = new DaoCitaImpl();
        try {
            listado = dao.citaSel3("785412543525445458");
            listado.forEach((t) -> {
                System.out.println(t.getIdcita());
            });
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }

}

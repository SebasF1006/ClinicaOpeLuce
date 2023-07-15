package test;

import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import entidades.Cita;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCitaSel {

    public static void main(String[] args) {

        //TEST METODO citaSel()
        List<Cita> listado = null;
        DaoCita dao = new DaoCitaImpl();
        try {
            listado = dao.citaSel();
            listado.forEach((t) -> {
                System.out.println(t.getIdcita());
            });
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }

}

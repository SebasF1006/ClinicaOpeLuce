package test;

import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import entidades.Cita;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCitaGet {

    public static void main(String[] args) {

        //TEST METODO citaGet();
        Cita cit;
        DaoCita dao = new DaoCitaImpl();
        try {
            cit = dao.citaGet(56);
            System.out.println(cit.getIdcita()+" - "
                    +cit.getTipo_cita()+" - "+cit.getFecha_cita());
        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

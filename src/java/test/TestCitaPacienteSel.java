package test;

import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import entidades.Cita;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCitaPacienteSel {

    public static void main(String[] args) {

        //TEST METODO citaGet();
        List<Cita> list;
        DaoCita dao = new DaoCitaImpl();
        try {
            list = dao.citaPacienteSel(2);
            list.forEach((t) -> {
                System.out.println(t.getIdpacientes() + " - "
                        + t.getFecha_cita() + " - " + t.getHora_cita());
            });

        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

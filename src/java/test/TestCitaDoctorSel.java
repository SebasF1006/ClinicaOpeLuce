package test;

import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import entidades.Cita;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCitaDoctorSel {

    public static void main(String[] args) {

        List<Cita> list;
        DaoCita dao = new DaoCitaImpl();
        try {
            list = dao.citaDoctorSel(2);
            list.forEach((t) -> {
                System.out.println(t.getIddoctor() + " - "
                        + t.getFecha_cita() + " - " + t.getHora_cita());
            });

        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

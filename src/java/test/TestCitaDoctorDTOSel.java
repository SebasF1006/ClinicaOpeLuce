package test;

import DTO.CitaDoctorDTO;
import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import entidades.Cita;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCitaDoctorDTOSel {

    public static void main(String[] args) {

        List<CitaDoctorDTO> list;
        DaoCita dao = new DaoCitaImpl();
        try {
            list = dao.citaDoctorDTOSel(2);
            list.forEach((t) -> {
                System.out.println(t.getPaciente()+ " - "
                        + t.getFecha_cita() + " - " + t.getHora_cita());
            });

        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

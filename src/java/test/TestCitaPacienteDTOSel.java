package test;

import DTO.CitaPacienteDTO;
import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import entidades.Cita;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCitaPacienteDTOSel {

    public static void main(String[] args) {

        //TEST METODO citaGet();
        List<CitaPacienteDTO> list;
        DaoCita dao = new DaoCitaImpl();
        try {
            list = dao.citaPacienteDTOSel(1);
            list.forEach((t) -> {
                System.out.println(t.getDoctor() + " - "
                        + t.getFecha_cita() + " - " + t.getHora_cita());
            });

        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

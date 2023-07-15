package test;

import dao.DaoCita;
import dao.DaoPaciente;
import dao.impl.DaoCitaImpl;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestCitaDel2 {

    public static void main(String[] args) {

        DaoCita dao = new DaoCitaImpl();
        try {
            System.out.println(dao.citaDel2(126));
        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

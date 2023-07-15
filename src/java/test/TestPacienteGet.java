package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestPacienteGet {

    public static void main(String[] args) {

        //TEST METODO pacienteGet();
        Paciente paci;
        DaoPaciente dao = new DaoPacienteImpl();
        try {
            paci = dao.pacienteGet(1);
            System.out.println(paci.getNombres_paciente());
        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

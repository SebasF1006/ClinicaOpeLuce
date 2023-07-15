package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestPacienteDel {

    public static void main(String[] args) {

        //TEST METODO pacienteDel()
        DaoPaciente daoPaciente = new DaoPacienteImpl();
        List<Integer> del = new ArrayList<>();
        del.add(17);
        try {
            System.out.println(daoPaciente.pacienteDel(del));
        } catch (Exception e) {
            System.out.println(daoPaciente.getMessage());
            System.out.println(e.getMessage());
        }
    }

}

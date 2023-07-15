package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestPacienteSel2 {

    public static void main(String[] args) {

        //TEST METODO pacienteSel()
        List<Paciente> listado = null;
        DaoPaciente dao = new DaoPacienteImpl();
        try {
            listado = dao.pacienteSel2("1478569600");
            listado.forEach((t) -> {
                System.out.println(t.getIdpacientes());
            });
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }

}


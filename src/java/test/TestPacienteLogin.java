package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestPacienteLogin {

    public static void main(String[] args) {

        //TEST METODO pacienteLogin()
        Boolean rspta = null;
        String correo = "juan2154@gmail.com";
        String pass = "12345";
        DaoPaciente dao = new DaoPacienteImpl();
        try {
            rspta = dao.pacienteLogin(correo, pass);
            System.out.println(rspta);
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }

}

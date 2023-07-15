package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestRecuperarPassword {

    public static void main(String[] args) {

        //TEST METODO pacienteGetLogin();
        Paciente paci;
        DaoPaciente dao = new DaoPacienteImpl();
        try {
            paci = dao.RecuperarPassword("purasad@gmail.com");
            if (paci == null) {
                System.out.println("ES NULL");
            }else{
                System.out.println("NO ES NULL");
                System.out.println(paci.getIdpacientes());
                System.out.println(paci.getNombres_paciente());
                System.out.println(paci.getApellidos_paciente());
                paci.setPassword_paciente("31245");
                System.out.println("PROCEDO A ACTUALIZAR");
                System.out.println(dao.pacienteUpd(paci));
            }
            
        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

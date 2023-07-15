package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestPacienteUpd {

    public static void main(String[] args) {

        //TEST METODO pacienteIUpd()
        Paciente paciente = new Paciente();
        paciente.setIdpacientes(17);
        paciente.setTipo_doc_paciente("DNI");
        paciente.setNro_doc_paciente("71222222");
        paciente.setNombres_paciente("ROBERTA");
        paciente.setApellidos_paciente("JONES SMITH");
        paciente.setTelefono_paciente("997777822");
        paciente.setDireccion_paciente("CALLE PERI 1568");
        paciente.setCorreo_paciente("robertaj@gmail.com");
        paciente.setPassword_paciente("rj71222222");
        paciente.setFecha_nacimiento_paciente(LocalDate.parse("2010-12-18"));
        paciente.setEdad_paciente(11);

        DaoPaciente dao = new DaoPacienteImpl();
        try {
            System.out.println(dao.pacienteUpd(paciente));
        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

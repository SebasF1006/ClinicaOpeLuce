/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;
import java.time.LocalDate;

        
public class TestPacienteIns {
    public static void main(String[] args) {

        
        Paciente paciente = new Paciente();
        paciente.setTipo_doc_paciente("DNI");
        paciente.setNro_doc_paciente("71222222");
        paciente.setNombres_paciente("ROBERT");
        paciente.setApellidos_paciente("JONES SMITH");
        paciente.setTelefono_paciente("997777822");
        paciente.setDireccion_paciente("CALLE OLMOS 8654");
        paciente.setCorreo_paciente("robertj@gmail.com");
        paciente.setPassword_paciente("rj71222222");
        paciente.setFecha_nacimiento_paciente(LocalDate.parse("2002-04-18"));
        paciente.setEdad_paciente(20);

        DaoPaciente dao = new DaoPacienteImpl();
        try {
            System.out.println(dao.pacienteIns(paciente));
        } catch (Exception e) {
            dao.getMessage();
        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import DTO.CitaDoctorDTO;
import DTO.CitaPacienteDTO;
import dao.DaoAdministrador;
import dao.DaoCita;
import dao.DaoDoctor;
import dao.DaoPaciente;
import dao.impl.DaoAdministradorImpl;
import dao.impl.DaoCitaImpl;
import dao.impl.DaoDoctorImpl;
import dao.impl.DaoPacienteImpl;
import entidades.Cita;
import entidades.Doctor;
import entidades.Paciente;
import javax.servlet.http.HttpServletRequest;
import util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PRUEBA3 {

    DaoPaciente daoPaciente = new DaoPacienteImpl();
    DaoDoctor daoDoctor = new DaoDoctorImpl();
    DaoAdministrador daoAdministrador = new DaoAdministradorImpl();
    DaoCita daoCita = new DaoCitaImpl();
    ConexionBD conectaDb = new ConexionBD();
    String mensaje;
    String rsptaTarget = null;

    public String PasswordAG(){
        String CADENA ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890#$%&/()=";
        Integer LONGITUD = 10;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < LONGITUD; i++) {
            double ale = Math.random() * CADENA.length();
            int posicion = (int) ale;
            char letra = CADENA.charAt(posicion);
            sb.append(letra);
        }
        return sb.toString();
    }
    
    public  String login() {
        StringBuilder result = new StringBuilder("<ul>");
        Boolean rsptaPaciente = null;
        Boolean rsptaDoctor = null;
        Boolean rsptaAdministrador = null;
        String correo = "sebastsdasdai200255@gmail.com";
        String pass = "marco1dsdsads234";

        if (correo == null || correo.trim().length() == 0) {
            result.append("<li>Correo</li>");
        } else if (correo.trim().length() < 3 || correo.trim().length() > 50) {
            result.append("<li>La dimensión del usuario debe estar entre ")
                    .append("3 a 50 caracteres</li>");
        }
        if (pass == null || pass.trim().length() == 0) {
            result.append("<li>Contraseña</li>");
        }
        if (result.length() == 4) {
            rsptaPaciente = daoPaciente.pacienteLogin(correo, pass);
            rsptaDoctor = daoDoctor.doctorLogin(correo, pass);
            rsptaAdministrador = daoAdministrador.administradorLogin(correo, pass);
            
            //PONERLE QUIZAS OTRAS VARIBALES A PRUEBA 
            if (rsptaPaciente != null) {
                rsptaTarget = "Paciente";
                Paciente paciente = daoPaciente.pacienteGetLogin(correo,pass);
                List <CitaPacienteDTO> list = daoCita.citaPacienteDTOSel(paciente.getIdpacientes());
            } else if (rsptaDoctor != null) {
                rsptaTarget = "Doctor";
                Doctor doctor = daoDoctor.doctorGetLogin(correo,pass);
                List <CitaDoctorDTO> list = daoCita.citaDoctorDTOSel(doctor.getIddoctor());
            } else if (rsptaAdministrador != null) {
                rsptaTarget = "Administrador";
            }

            if (rsptaTarget == null) {
                result.append("<li>Correo o contraseña incorrecta</li>");
            }
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

}

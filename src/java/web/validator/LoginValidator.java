package web.validator;

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

public class LoginValidator {
    
    private final HttpServletRequest request;
    private final DaoPaciente daoPaciente;
    private final DaoDoctor daoDoctor;
    private final DaoAdministrador daoAdministrador;
    private final DaoCita daoCita;
    private final ConexionBD conectaDb;
    private String mensaje;
    public String rsptaTarget = null;

    public LoginValidator(HttpServletRequest request) {
        this.request = request;
        this.daoPaciente = new DaoPacienteImpl();
        this.daoDoctor = new DaoDoctorImpl();
        this.daoAdministrador = new DaoAdministradorImpl();
        this.daoCita = new DaoCitaImpl();
        this.conectaDb = new ConexionBD();
    }

    public String login() {
        StringBuilder result = new StringBuilder("<ul>");
        Boolean rsptaPaciente = null;
        Boolean rsptaDoctor = null;
        Boolean rsptaAdministrador = null;
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");

        if (correo == null || correo.trim().length() == 0) {
            result.append("<li>Correo</li>");
        } else if (correo.trim().length() < 3 || correo.trim().length() > 50) {
            result.append("<li>La dimensión del Correo debe estar entre ")
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
                request.setAttribute("idPaciente", paciente.getIdpacientes());
                request.setAttribute("NombrePaciente", paciente.getNombres_paciente());
                request.setAttribute("ApellidosPaciente", paciente.getApellidos_paciente());
                request.setAttribute("list", list);
                request.setAttribute("paciente", paciente);
            } else if (rsptaDoctor != null) {
                rsptaTarget = "Doctor";
                Doctor doctor = daoDoctor.doctorGetLogin(correo,pass);
                List <CitaDoctorDTO> list = daoCita.citaDoctorDTOSel(doctor.getIddoctor());
                request.setAttribute("idDoctor", doctor.getIddoctor());
                request.setAttribute("NombreDoctor", doctor.getNombres_doctor());
                request.setAttribute("ApellidosDoctor", doctor.getApellidos_doctor());
                request.setAttribute("list", list);
                request.setAttribute("doctor", doctor);
            } else if (rsptaAdministrador != null) {
                rsptaTarget = "Administrador";
            }

            if (rsptaTarget == null) {
                result.append("<li>Correo o contraseña incorrecta</li>");
            }
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    
    public String EnviarParametros() {

        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");

        request.setAttribute("correo", correo);
        request.setAttribute("pass", pass);
        
        return null;

    }


}

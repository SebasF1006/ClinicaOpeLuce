package dao;

import DTO.CitaPacienteDTO;
import entidades.Paciente;
import java.util.List;

public interface DaoPaciente {
    List<Paciente> pacienteSel();
    List<Paciente> pacienteSel2(String nro_doc);
    Paciente pacienteGet(Integer id);
    String pacienteIns(Paciente paciente);
    String pacienteUpd(Paciente paciente);
    String pacienteDel(List<Integer> ids);
    Boolean pacienteLogin(String correo, String pass);
    Paciente pacienteGetLogin(String correo, String pass);
    Paciente RecuperarPassword(String correo);
    Integer pacienteTieneCita(Integer idpacientes);
    Integer pacienteNro_docDuplicado(String Nro_doc);
    Integer pacienteCorreoDuplicado(String correo);
    String getMessage();
}

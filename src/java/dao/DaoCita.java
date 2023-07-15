package dao;

import DTO.CitaDoctorDTO;
import DTO.CitaPacienteDTO;
import entidades.Cita;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DaoCita {
    List <Cita> citaSel();
    List <Cita> citaSel2(String nro_doc_pac);
    List <Cita> citaSel3(String nro_doc_doc);
    Cita citaGet(Integer id);
    List <Cita> citaPacienteSel(Integer id);
    List <CitaPacienteDTO> citaPacienteDTOSel(Integer id);
    List <Cita> citaDoctorSel(Integer id);
    List <CitaDoctorDTO> citaDoctorDTOSel(Integer id);
    String citaIns(Cita cita);
    List <Integer> idsDoctor(String tipo_cita,LocalTime hora, LocalDate fecha);
    List <Integer> idsNoDoctor(String tipo_cita,LocalTime hora, LocalDate fecha);
    List <Integer> idsDoctorS(String tipo_cita);
    Integer FechaCita(Integer mes, Integer año);
    String citaDiagnosticoIns(Integer idcita,String diag_cita);
    Integer citaNro_Doc_Pac_Existe(String Nro_doc);
    Integer citaNro_Doc_Doc_Existe(String Nro_doc);
    //String citaUpd(Cita cita);
    String citaDel(List<Integer> ids);
    String citaDel2(Integer id);
    String getMessage();
}

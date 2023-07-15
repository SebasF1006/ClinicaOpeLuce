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
import entidades.Administrador;
import entidades.Cita;
import entidades.Doctor;
import entidades.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import util.DeString;
import java.util.ArrayList;

public class CitaValidator {

    private final HttpServletRequest request;
    private final DaoCita daoCita;
    private final DaoPaciente daoPaciente;
    private final DaoDoctor daoDoctor;
    private final DaoAdministrador daoAdministrador;
    public Integer idPac = 0;
    public Integer idPac2 = 0;

    public CitaValidator(HttpServletRequest request) {
        this.request = request;
        this.daoCita = new DaoCitaImpl();
        this.daoPaciente = new DaoPacienteImpl();
        this.daoDoctor = new DaoDoctorImpl();
        this.daoAdministrador = new DaoAdministradorImpl();
    }

    public String citaSel() {
        String result = null;
        List<Cita> list = daoCita.citaSel();
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }
    
    public String citaSel2() {
        StringBuilder result = new StringBuilder("<ul>");
        String nro_doc = request.getParameter("nro_doc_pac");
        Integer id = daoCita.citaNro_Doc_Pac_Existe(nro_doc);
        Integer id2 = daoPaciente.pacienteNro_docDuplicado(nro_doc);
        List<Cita> list = daoCita.citaSel2(nro_doc);
        List<Cita> list2 = daoCita.citaSel();
        
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        
        if (nro_doc == null || nro_doc.trim().length() == 0) {
            result.append("<li>Debe ingresar el Nro de Doc. del Paciente</li>");
        }else if(id2 == null){
            result.append("<li>El Nro de Doc. del paciente no se encuentra registrado</li>");
        }else if(id == null){
            result.append("<li>El paciente no cuenta con citas registradas</li>");
        }
        
        if (result.length() == 4) {
            request.setAttribute("list", list);
        }
        if (result.length() > 4) {
            request.setAttribute("list", list2);
        }
        
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }
    
    
    public String citaSel3() {
        StringBuilder result = new StringBuilder("<ul>");
        String nro_doc = request.getParameter("nro_doc_doc");
        Integer id = daoCita.citaNro_Doc_Doc_Existe(nro_doc);
        Integer id2 = daoDoctor.doctorNro_docDuplicado(nro_doc);
        List<Cita> list = daoCita.citaSel3(nro_doc);
        List<Cita> list2 = daoCita.citaSel();
        
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        
        if (nro_doc == null || nro_doc.trim().length() == 0) {
            result.append("<li>Debe ingresar el Nro de Doc. del Doctor</li>");
        }else if(id2 == null){
            result.append("<li>El Nro de Doc. del doctor no se encuentra registrado</li>");
        }else if(id == null){
            result.append("<li>El doctor no cuenta con citas registradas</li>");
        }
        
        if (result.length() == 4) {
            request.setAttribute("list", list);
        }
        if (result.length() > 4) {
            request.setAttribute("list", list2);
        }
        
        return result.length() == 4 ? null : result.append("</ul>").toString();
    }
    
    public String citaSel4() {
        String result = null;
        String nro_doc = request.getParameter("nro_doc_pac");
        List<Cita> list = daoCita.citaSel2(nro_doc);
        
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        
        if (list != null) {
            request.setAttribute("list", list);
        }else{
           result = daoCita.getMessage(); 
        }
        
        return result;
    }
    
    public String citaSel5() {
        String result = null;
        String nro_doc = request.getParameter("nro_doc_doc");
        List<Cita> list = daoCita.citaSel3(nro_doc);
        
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        
        if (list != null) {
            request.setAttribute("list", list);
        }else{
           result = daoCita.getMessage(); 
        }
        
        return result;
    }

    public String citaGet() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Cita cita = daoCita.citaGet(id);
        if (cita != null) {
            request.setAttribute("cita", cita);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }

    public String citaGet2() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Paciente paciente = daoPaciente.pacienteGet(id);
        List<CitaPacienteDTO> list = daoCita.citaPacienteDTOSel(paciente.getIdpacientes());
        if (id != null) {
            request.setAttribute("id", id);
            request.setAttribute("idPaciente", paciente.getIdpacientes());
            request.setAttribute("NombrePaciente", paciente.getNombres_paciente());
            request.setAttribute("ApellidosPaciente", paciente.getApellidos_paciente());
            request.setAttribute("list", list);
            request.setAttribute("paciente", paciente);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }

    public String citaGet3() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Doctor doctor = daoDoctor.doctorGet(id);
        List<CitaDoctorDTO> list = daoCita.citaDoctorDTOSel(doctor.getIddoctor());
        if (id != null) {
            request.setAttribute("id", id);
            request.setAttribute("idDoctor", doctor.getIddoctor());
            request.setAttribute("NombreDoctor", doctor.getNombres_doctor());
            request.setAttribute("ApellidosDoctor", doctor.getApellidos_doctor());
            request.setAttribute("list", list);
            request.setAttribute("doctor", doctor);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }

    public String citaGet4() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Integer idcita = DeString.aInteger(request.getParameter("idcita"));
        Doctor doctor = daoDoctor.doctorGet(id);
        List<CitaDoctorDTO> list = daoCita.citaDoctorDTOSel(doctor.getIddoctor());
        if (id != null) {
            request.setAttribute("id", id);
            request.setAttribute("idcita", idcita);
            request.setAttribute("idDoctor", doctor.getIddoctor());
            request.setAttribute("NombreDoctor", doctor.getNombres_doctor());
            request.setAttribute("ApellidosDoctor", doctor.getApellidos_doctor());
            request.setAttribute("list", list);
            request.setAttribute("doctor", doctor);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }

    public String citaParameter() {
        String result = null;
        Integer idpacientes = DeString.aInteger(request.getParameter("idpacientes"));
        if (idpacientes != null) {
            request.setAttribute("idpacientes", idpacientes);
        } else {
            result = daoCita.getMessage();
        }
        return result;
    }

    public String citaInsUpd(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");
        Integer idcita = DeString.aInteger(request.getParameter("idcita"));
        Integer idpacientes = DeString.aInteger(request.getParameter("id"));
        String tipo_Cita = request.getParameter("tipo_cita").toString();
        Double costo = 90d;
        if (tipo_Cita.equalsIgnoreCase("CONSULTA GENERAL")) {
            costo = 90d;
        } else if (tipo_Cita.equalsIgnoreCase("CONSULTA PEDRIATICA")) {
            costo = 120d;
        } else if (tipo_Cita.equalsIgnoreCase("SUB ESPECIALIDADES")) {
            costo = 160d;
        } else if (tipo_Cita.equalsIgnoreCase("EXAMEN DE LA VISTA")) {
            costo = 140d;
        } else {
            costo = 100d;
        }

        boolean seguir = true;
        Cita cita = new Cita();
        List<Integer> listaTD = null;
        List<Integer> listaND = null;
        List<Integer> listaAux = null;
        LocalDate fecha = LocalDate.now().plusDays(4);
        LocalTime hora = LocalTime.parse("08:00:00");
        LocalTime horaInicial = LocalTime.parse("08:00:00");
        LocalTime horaAlmuerzo = LocalTime.parse("13:00:00");
        LocalTime horaFinal = LocalTime.parse("22:00:00");
        Integer iddoctor = null;

        if (tipo_Cita == null || tipo_Cita.trim().length() == 0) {
            result.append("<li>INGRESE EL TIPO DE CITA</li>");
        }

        if (result.length() == 4) {

            String msg = null;
            while (seguir) {
                String dia = fecha.getDayOfWeek().toString();
                if (dia.equals("SUNDAY")) {
                    fecha = fecha.plusDays(1);
                }
                try {
                    listaND = daoCita.idsNoDoctor(tipo_Cita, hora, fecha);
                    listaTD = daoCita.idsDoctorS(tipo_Cita);
                    listaAux = new ArrayList();
                    Integer c = 0;
                    if (listaND.size() == 0) {
                        iddoctor = NumMenor(listaTD);
                    } else if (listaND.size() > 0) {
                        for (int i = 0; i < listaTD.size(); i++) {
                            for (int j = 0; j < listaND.size(); j++) {
                                if (listaTD.get(i) != listaND.get(j)) {
                                    c++;
                                }
                            }
                            if (c == listaND.size()) {
                                listaAux.add(listaTD.get(i));
                            }
                            c = 0;
                        }
                        iddoctor = NumMenor(listaAux);
                    } else if (listaND.size() == listaTD.size()) {
                        iddoctor = -1;
                    }

                    if (iddoctor != -1) {

                        cita.setIdpacientes(idpacientes);
                        cita.setIddoctor(iddoctor);
                        cita.setTipo_cita(tipo_Cita);
                        cita.setCosto_cita(costo);
                        cita.setHora_cita(hora);
                        cita.setFecha_cita(fecha);
                        cita.setDiagnostico_cita(" ");
                        try {
                            msg = daoCita.citaIns(cita);
                            System.out.println("CITA REGISTRADA");
                            seguir = false;
                        } catch (Exception e) {
                            daoCita.getMessage();
                        }

                    } else {
                        hora = hora.plusHours(1);
                        if (hora == horaAlmuerzo) {
                            hora = hora.plusHours(1);
                        } else if (hora == horaFinal) {
                            hora = horaInicial;
                            fecha = fecha.plusDays(1);
                        }
                    }
                } catch (Exception e) {
                    daoCita.getMessage();
                }

            }
            //String msg = daoCita.citaIns(cita);
            /*String msg = upd
                    ? daoCita.citaUpd(cita)
                    : daoCita.citaIns(cita);*/

 /*request.setAttribute("id", idpacientes);
            request.setAttribute("idPaciente", paciente.getIdpacientes());
            request.setAttribute("NombrePaciente", paciente.getNombres_paciente());
            request.setAttribute("ApellidosPaciente", paciente.getApellidos_paciente());
            request.setAttribute("list", list);
            request.setAttribute("paciente", paciente);*/
            idPac = idpacientes;
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }

        if (result.length() > 4) {
            request.setAttribute("cita", cita);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }

    public String citaDiagnosticoIns() {

        StringBuilder result = new StringBuilder("<ul>");
        Integer idcita = DeString.aInteger(request.getParameter("idcita"));
        Integer iddoctor = DeString.aInteger(request.getParameter("id_doctor"));
        String diagnostico_cita = request.getParameter("diagnostico_cita");
        String msg = null;

        if (diagnostico_cita == null || diagnostico_cita.trim().length() == 0) {
            result.append("<li>Ingrese el Diagnóstico de la Cita</li>");
        }

        if (result.length() == 4) {

            Doctor doctor = daoDoctor.doctorGet(iddoctor);
            List<CitaDoctorDTO> list = daoCita.citaDoctorDTOSel(doctor.getIddoctor());
            idPac = iddoctor;
            if (iddoctor != null) {
                msg = daoCita.citaDiagnosticoIns(idcita, diagnostico_cita);
                if (msg != null) {
                    result.append("<li>").append(msg).append("</li>");
                }

                request.setAttribute("id", iddoctor);
                request.setAttribute("idDoctor", doctor.getIddoctor());
                request.setAttribute("NombreDoctor", doctor.getNombres_doctor());
                request.setAttribute("ApellidosDoctor", doctor.getApellidos_doctor());
                request.setAttribute("list", list);
                request.setAttribute("doctor", doctor);
            }

        }

        if (result.length() > 4) {
            Doctor doctor = daoDoctor.doctorGet(iddoctor);
            List<CitaDoctorDTO> list = daoCita.citaDoctorDTOSel(doctor.getIddoctor());

            request.setAttribute("id", iddoctor);
            request.setAttribute("idcita", idcita);
            request.setAttribute("idDoctor", doctor.getIddoctor());
            request.setAttribute("NombreDoctor", doctor.getNombres_doctor());
            request.setAttribute("ApellidosDoctor", doctor.getApellidos_doctor());
            request.setAttribute("list", list);
            request.setAttribute("doctor", doctor);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }

    /*
    public String citaDel() {
        List<Integer> ids = DeString.ids(request.getParameter("ids"));
        String result = (ids != null)
                ? daoCita.citaDel(ids)
                : "IDs incorrectos";
        return result;
    }*/
    public Integer NumMenor(List<Integer> lista) {
        Integer numMenor = 10000;
        if (lista.size() == 0) {
            numMenor = -1;
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) < numMenor) {
                    numMenor = lista.get(i);
                }
            }
        }

        return numMenor;

    }

    public String citaGenReporte() {
        StringBuilder result = new StringBuilder("<ul>");
        String PDF_Param = request.getParameter("PDF_Param");
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        String jasper = request.getParameter("jasper");

        Integer año = (PDF_Param == null || PDF_Param.trim().length() == 0)
                ? 0
                : Integer.parseInt(PDF_Param.substring(0, 4));
        Integer mes = (PDF_Param == null || PDF_Param.trim().length() == 0)
                ? 0
                : Integer.parseInt(PDF_Param.substring(5, 7));

        Integer rspta = daoCita.FechaCita(mes, año);

        if (mes == 0 || año == 0) {
            result.append("<li>Ingrese el mes</li>");
        } else if (rspta == null) {
            result.append("<li>No han ocurrido citas durante dicho mes</li>");
        }

        /*request.setAttribute("mes", mes);
        request.setAttribute("año", año);
        request.setAttribute("jasper", jasper);*/
        if (result.length() > 4) {
            List<Cita> list = daoCita.citaSel();
            request.setAttribute("list", list);
            Administrador admin = daoAdministrador.administradorGet(idadmin);
            request.setAttribute("idAdministrador", admin.getIdadministrador());
            request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
            request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
            request.setAttribute("admin", admin);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }
    
    public String citaDel() {
        Integer id_cita = DeString.aInteger(request.getParameter("id_cita"));
        String result = null;
        if (id_cita != null) {
            result = daoCita.citaDel2(id_cita);
        } else {
            result = "ID incorrecto";;
        }
        /*String result = (ids != null)
                ? daoCita.citaDel(ids)
                : "IDs incorrectos";*/
        return result;
    }
    
    public String citaDel2() {
        Integer id_cita = DeString.aInteger(request.getParameter("id_cita"));
        String result = null;
        if (id_cita != null) {
            result = daoCita.citaDel2(id_cita);
        } else {
            result = "ID incorrecto";;
        }
        /*String result = (ids != null)
                ? daoCita.citaDel(ids)
                : "IDs incorrectos";*/
        return result;
    }
}

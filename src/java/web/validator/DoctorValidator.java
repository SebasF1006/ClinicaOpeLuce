package web.validator;

import DTO.CitaDoctorDTO;
import dao.DaoAdministrador;
import dao.DaoCita;
import dao.DaoDoctor;
import dao.impl.DaoAdministradorImpl;
import dao.impl.DaoCitaImpl;
import dao.impl.DaoDoctorImpl;
import entidades.Administrador;
import entidades.Cita;
import entidades.Doctor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import util.DeString;

public class DoctorValidator {

    private final HttpServletRequest request;
    private final DaoDoctor daoDoctor;
    private final DaoCita daoCita;
    private final DaoAdministrador daoAdministrador;
    public Integer idUPD2 = 0;

    public DoctorValidator(HttpServletRequest request) {
        this.request = request;
        this.daoDoctor = new DaoDoctorImpl();
        this.daoAdministrador = new DaoAdministradorImpl();
        this.daoCita = new DaoCitaImpl();
    }

    public String doctorSel() {
        String result = null;
        List<Doctor> list = daoDoctor.doctorSel();
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));

        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoDoctor.getMessage();
        }
        return result;
    }

    public String doctorSel2() {
        StringBuilder result = new StringBuilder("<ul>");
        String nro_doc = request.getParameter("nro_doc");
        Integer id = daoDoctor.doctorNro_docDuplicado(nro_doc);
        List<Doctor> list = daoDoctor.doctorSel2(nro_doc);
        List<Doctor> list2 = daoDoctor.doctorSel();
        
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        
        if (nro_doc == null || nro_doc.trim().length() == 0) {
            result.append("<li>Debe ingresar el Nro de Doc.</li>");
        } else if (id == null) {
            result.append("<li>El Nro de Doc. no se encuentra registrado</li>");
        }

        if (result.length() == 4) {
            request.setAttribute("list", list);
        }
        if (result.length() > 4) {
            request.setAttribute("list", list2);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();
    }
    
    
    public String doctorSel3() {
        String result = null;
        String nro_doc = request.getParameter("nro_doc");
        List<Doctor> list = daoDoctor.doctorSel2(nro_doc);
        
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);

        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoAdministrador.getMessage();
        }
        return result;
    }
    
    
    public String doctorGOINS() {
        String result = null;
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        return result;
    }

    public String doctorGet() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Doctor doctor = daoDoctor.doctorGet(id);
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        if (doctor != null) {
            request.setAttribute("doctor", doctor);
            request.setAttribute("idAdministrador", admin.getIdadministrador());
            request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
            request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
            request.setAttribute("admin", admin);
        } else {
            result = daoDoctor.getMessage();
        }
        return result;
    }
    
    public String doctorGet2() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Doctor doctor = daoDoctor.doctorGet(id);
        if (doctor != null) {
            request.setAttribute("doctor", doctor);
        } else {
            result = daoDoctor.getMessage();
        }
        return result;
    }

    public String doctorInsUpd(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");
        Integer iddoctor = DeString.aInteger(request.getParameter("iddoctor"));
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        String tipo_doc = request.getParameter("tipo_doc_doctor");
        String nro_doc = request.getParameter("nro_doc_doctor");
        String nombres = request.getParameter("nombres_doctor");
        String apellidos = request.getParameter("apellidos_doctor");
        String especialidad = request.getParameter("especialidad_doctor");
        String telefono = request.getParameter("telefono_doctor");
        String direccion = request.getParameter("direccion_doctor");
        String correo = request.getParameter("correo_doctor");
        String password = request.getParameter("password_doctor");
        String aux = request.getParameter("fecha_nacimiento_doctor");
        LocalDate fecha_nacimiento = (aux == null || aux.trim().length() == 0)
                ? null
                : LocalDate.parse(aux);
        LocalDate hoy = LocalDate.now();
        LocalDate registromin = hoy.plusYears(-20);
        LocalDate registromax = hoy.plusYears(-81);

        String Fnombre = FormatoString(nombres);
        String Fapellidos = FormatoString(apellidos);

        if (fecha_nacimiento == null) {
            result.append("<li>Fecha de nacimiento</li>");
        } else if (hoy.isBefore(fecha_nacimiento)) {
            result.append("<li>La fecha de nacimiento no puede ser una fecha futura</li>");
        } else if (registromin.isBefore(fecha_nacimiento)) {
            result.append("<li>La edad mínima del doctor debe ser 20 años</li>");
        } else if (registromax.isAfter(fecha_nacimiento)) {
            result.append("<li>La edad máxima del doctor debe ser 80 años</li>");
        }

        Period edad_aux = (aux == null || aux.trim().length() == 0)
                ? null
                : Period.between(fecha_nacimiento, LocalDate.now());
        Integer edad = (aux == null || aux.trim().length() == 0)
                ? null
                : (Integer) edad_aux.getYears();

        Integer rspta = daoDoctor.doctorNro_docDuplicado(nro_doc);
        Integer rsptaCorreo2 = daoDoctor.doctorCorreoDuplicado(correo);
        String nro_doc_Est = null;
        String correo_Est = null;
        if (upd == true) {
            Doctor doc = daoDoctor.doctorGet(iddoctor);
            nro_doc_Est = doc.getNro_doc_doctor();
            correo_Est = doc.getCorreo_doctor();
        }

        if (upd && iddoctor == null) {
            result.append("<li>Id</li>");
        }
        if (nro_doc == null || nro_doc.trim().length() == 0) {
            result.append("<li>Nro de Doc.</li>");
        } else if (tipo_doc.equals("DNI") && nro_doc.trim().length() != 8) {
            result.append("<li>La dimensión del DNI debe tener")
                    .append(" 8 caracteres</li>");
        } else if (tipo_doc.equals("CARNET DE EXTRANJERIA") && nro_doc.trim().length() != 9) {
            result.append("<li>La dimensión del Carnet de Extranjería debe tener")
                    .append(" 9 caracteres</li>");
        } else if (tipo_doc.equals("C.C.") && nro_doc.trim().length() != 10) {
            result.append("<li>La dimensión del C.C. debe tener")
                    .append(" 10 caracteres</li>");
        } else if (upd == false && rspta != null) {
            result.append("<li>El Nro de Doc. ya ha sido registrado, ingrese otro</li>");
        } else if (upd == true && rspta != null && !nro_doc.equals(nro_doc_Est)) {
            result.append("<li>El Nro de Doc. ya ha sido registrado por otro usuario</li>")
                    .append(" Ingrese otro</li>");
        }

        if (nombres == null || nombres.trim().length() == 0) {
            result.append("<li>Nombre</li>");
        } else if (nombres.trim().length() < 3 || nombres.trim().length() > 50) {
            result.append("<li>La dimensión del nombre debe estar entre")
                    .append("3 a 50 caracteres</li>");
        } else if (Fnombre == null) {
            result.append("<li>El nombre no puede contener caracteres especiales")
                    .append(" (1+´]#¡?)</li>");
        }

        if (apellidos == null || apellidos.trim().length() == 0) {
            result.append("<li>Apellidos</li>");
        } else if (apellidos.trim().length() < 3 || apellidos.trim().length() > 50) {
            result.append("<li>La dimensión de los apellidos debe estar entre")
                    .append("3 a 50 caracteres</li>");
        } else if (Fapellidos == null) {
            result.append("<li>El apellido no puede contener caracteres especiales")
                    .append(" (1+´]#¡?)</li>");
        }

        if (especialidad == null || especialidad.trim().length() == 0) {
            result.append("<li>Especialidad</li>");
        } else if (especialidad.trim().length() < 3 || especialidad.trim().length() > 50) {
            result.append("<li>La dimensión de la especialidad debe estar entre")
                    .append("3 a 50 caracteres</li>");
        }
        if (direccion == null || direccion.trim().length() == 0) {
            result.append("<li>Dirección</li>");
        }
        if (telefono == null || telefono.trim().length() == 0) {
            result.append("<li>Telefono</li>");
        } else if (telefono.trim().length() > 9) {
            result.append("<li>La dimensión del Telefono debe tener")
                    .append(" hasta 9 caracteres</li>");
        }
        if (correo == null || correo.trim().length() == 0) {
            result.append("<li>Correo</li>");
        }else if (upd == false && rsptaCorreo2 != null) {
            result.append("<li>El correo ya ha sido registrado, ingrese otro</li>");
        }else if (upd == true && rsptaCorreo2 != null && !correo.equals(correo_Est)) {
            result.append("<li>El correo ya ha sido registrado por otro usuario</li>")
                    .append(" Ingrese otro</li>");
        }
        
        
        
        if (password == null || password.trim().length() == 0) {
            result.append("<li>Contraseña</li>");
        }

        Doctor doctor = new Doctor();
        doctor.setIddoctor(iddoctor);
        doctor.setTipo_doc_doctor(tipo_doc);
        doctor.setNro_doc_doctor(nro_doc);
        doctor.setNombres_doctor(Fnombre);
        doctor.setApellidos_doctor(Fapellidos);
        doctor.setEspecialidad_doctor(especialidad);
        doctor.setTelefono_doctor(telefono);
        doctor.setDireccion_doctor(direccion);
        doctor.setCorreo_doctor(correo);
        doctor.setPassword_doctor(password);
        doctor.setFecha_nacimiento_doctor(fecha_nacimiento);
        doctor.setEdad_doctor(edad);

        if (result.length() == 4) {
            String msg = upd
                    ? daoDoctor.doctorUpd(doctor)
                    : daoDoctor.doctorIns(doctor);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("doctor", doctor);
            Administrador admin = daoAdministrador.administradorGet(idadmin);
            request.setAttribute("idAdministrador", admin.getIdadministrador());
            request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
            request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
            request.setAttribute("admin", admin);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String doctorInsUpd2(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");
        Integer iddoctor = DeString.aInteger(request.getParameter("iddoctor"));
        String tipo_doc = request.getParameter("tipo_doc_doctor");
        String nro_doc = request.getParameter("nro_doc_doctor");
        String nombres = request.getParameter("nombres_doctor");
        String apellidos = request.getParameter("apellidos_doctor");
        String especialidad = request.getParameter("especialidad_doctor");
        String telefono = request.getParameter("telefono_doctor");
        String direccion = request.getParameter("direccion_doctor");
        String correo = request.getParameter("correo_doctor");
        String password = request.getParameter("password_doctor");
        String aux = request.getParameter("fecha_nacimiento_doctor");
        LocalDate fecha_nacimiento = (aux == null || aux.trim().length() == 0)
                ? null
                : LocalDate.parse(aux);
        LocalDate hoy = LocalDate.now();
        LocalDate registromin = hoy.plusYears(-20);
        LocalDate registromax = hoy.plusYears(-81);

        String Fnombre = FormatoString(nombres);
        String Fapellidos = FormatoString(apellidos);

        if (fecha_nacimiento == null) {
            result.append("<li>Fecha de nacimiento</li>");
        } else if (hoy.isBefore(fecha_nacimiento)) {
            result.append("<li>La fecha de nacimiento no puede ser una fecha futura</li>");
        } else if (registromin.isBefore(fecha_nacimiento)) {
            result.append("<li>La edad mínima del doctor debe ser 20 años</li>");
        } else if (registromax.isAfter(fecha_nacimiento)) {
            result.append("<li>La edad máxima del doctor debe ser 80 años</li>");
        }

        Period edad_aux = (aux == null || aux.trim().length() == 0)
                ? null
                : Period.between(fecha_nacimiento, LocalDate.now());
        Integer edad = (aux == null || aux.trim().length() == 0)
                ? null
                : (Integer) edad_aux.getYears();

        Integer rspta = daoDoctor.doctorNro_docDuplicado(nro_doc);
        Integer rsptaCorreo2 = daoDoctor.doctorCorreoDuplicado(correo);
        
        Doctor doc = daoDoctor.doctorGet(iddoctor);
        String nro_doc_Est = doc.getNro_doc_doctor();
        String correo_Est = doc.getCorreo_doctor();
        
        if (upd && iddoctor == null) {
            result.append("<li>Id</li>");
        }
        if (nro_doc == null || nro_doc.trim().length() == 0) {
            result.append("<li>Nro de Doc.</li>");
        } else if (tipo_doc.equals("DNI") && nro_doc.trim().length() != 8) {
            result.append("<li>La dimensión del DNI debe tener")
                    .append(" 8 caracteres</li>");
        } else if (tipo_doc.equals("CARNET DE EXTRANJERIA") && nro_doc.trim().length() != 9) {
            result.append("<li>La dimensión del Carnet de Extranjería debe tener")
                    .append(" 9 caracteres</li>");
        } else if (tipo_doc.equals("C.C.") && nro_doc.trim().length() != 10) {
            result.append("<li>La dimensión del C.C. debe tener")
                    .append(" 10 caracteres</li>");
        } else if (upd == false && rspta != null) {
            result.append("<li>El Nro de Doc. ya ha sido registrado, ingrese otro</li>");
        } else if (upd == true && rspta != null && !nro_doc.equals(nro_doc_Est)) {
            result.append("<li>El Nro de Doc. ya ha sido registrado por otro usuario</li>")
                    .append(" Ingrese otro</li>");
        }

        if (nombres == null || nombres.trim().length() == 0) {
            result.append("<li>Nombre</li>");
        } else if (nombres.trim().length() < 3 || nombres.trim().length() > 50) {
            result.append("<li>La dimensión del nombre debe estar entre")
                    .append("3 a 50 caracteres</li>");
        } else if (Fnombre == null) {
            result.append("<li>El nombre no puede contener caracteres especiales")
                    .append(" (1+´]#¡?)</li>");
        }

        if (apellidos == null || apellidos.trim().length() == 0) {
            result.append("<li>Apellidos</li>");
        } else if (apellidos.trim().length() < 3 || apellidos.trim().length() > 50) {
            result.append("<li>La dimensión de los apellidos debe estar entre")
                    .append("3 a 50 caracteres</li>");
        } else if (Fapellidos == null) {
            result.append("<li>El apellido no puede contener caracteres especiales")
                    .append(" (1+´]#¡?)</li>");
        }

        if (especialidad == null || especialidad.trim().length() == 0) {
            result.append("<li>Especialidad</li>");
        } else if (especialidad.trim().length() < 3 || especialidad.trim().length() > 50) {
            result.append("<li>La dimensión de la especialidad debe estar entre")
                    .append("3 a 50 caracteres</li>");
        }
        if (direccion == null || direccion.trim().length() == 0) {
            result.append("<li>Dirección</li>");
        }
        if (telefono == null || telefono.trim().length() == 0) {
            result.append("<li>Telefono</li>");
        } else if (telefono.trim().length() > 9) {
            result.append("<li>La dimensión del Telefono debe tener")
                    .append(" hasta 9 caracteres</li>");
        }
        if (correo == null || correo.trim().length() == 0) {
            result.append("<li>Correo</li>");
        }else if (upd == false && rsptaCorreo2 != null) {
            result.append("<li>El correo ya ha sido registrado, ingrese otro</li>");
        }else if (upd == true && rsptaCorreo2 != null && !correo.equals(correo_Est)) {
            result.append("<li>El correo ya ha sido registrado por otro usuario</li>")
                    .append(" Ingrese otro</li>");
        }
        
        
        if (password == null || password.trim().length() == 0) {
            result.append("<li>Contraseña</li>");
        }

        Doctor doctor = new Doctor();
        doctor.setIddoctor(iddoctor);
        doctor.setTipo_doc_doctor(tipo_doc);
        doctor.setNro_doc_doctor(nro_doc);
        doctor.setNombres_doctor(Fnombre);
        doctor.setApellidos_doctor(Fapellidos);
        doctor.setEspecialidad_doctor(especialidad);
        doctor.setTelefono_doctor(telefono);
        doctor.setDireccion_doctor(direccion);
        doctor.setCorreo_doctor(correo);
        doctor.setPassword_doctor(password);
        doctor.setFecha_nacimiento_doctor(fecha_nacimiento);
        doctor.setEdad_doctor(edad);

        idUPD2 = iddoctor;
        if (result.length() == 4) {
            String msg = upd
                    ? daoDoctor.doctorUpd(doctor)
                    : daoDoctor.doctorIns(doctor);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("doctor", doctor);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();
    }

    public String doctorDel() {
        List<Integer> ids = DeString.ids(request.getParameter("ids"));
        String result = (ids != null)
                ? daoDoctor.doctorDel(ids)
                : "IDs incorrectos";
        return result;
    }

    public String FormatoString(String palabra) {
        String stg = "";
        char letrauno = ' ';
        char c = ' ';
        int aux = 0;

        for (int i = 0; i < palabra.length(); i++) {
            letrauno = palabra.charAt(0);
            c = palabra.charAt(i);

            if (letrauno == ' ') {
                return null;
            } else if (!Character.isLetter(c)) {
                if (c != ' ') {
                    return null;
                }

            }

            if (i == 0) {
                c = Character.toUpperCase(c);
            }
            if (i >= 1) {
                c = Character.toLowerCase(c);
            }
            if (c == ' ') {
                aux = (i + 1);
            }
            if (aux == i) {
                c = Character.toUpperCase(c);
            }

            stg += c;
        }

        return stg;
    }

    public String citaGenReporte() {
        StringBuilder result = new StringBuilder("<ul>");
        String PDF_Param = request.getParameter("PDF_Param");
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Integer iddoc = Integer.parseInt(PDF_Param);
        String jasper = request.getParameter("jasper");

        Integer rspta = daoDoctor.doctorTieneCita(iddoc);

        if (rspta == null) {
            result.append("<li>El doctor no cuenta con Citas</li>");
        }

        if (result.length() > 4) {
            List<Doctor> list = daoDoctor.doctorSel();
            request.setAttribute("list", list);
            Administrador admin = daoAdministrador.administradorGet(idadmin);
            request.setAttribute("idAdministrador", admin.getIdadministrador());
            request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
            request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
            request.setAttribute("admin", admin);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }

    public String citaGenReporte2() {
        StringBuilder result = new StringBuilder("<ul>");
        String PDF_Param = request.getParameter("PDF_Param");
        Integer iddoctor = DeString.aInteger(request.getParameter("iddoctor"));
        Integer idcita = Integer.parseInt(PDF_Param);
        String jasper = request.getParameter("jasper");

        Cita cita = daoCita.citaGet(idcita);
        String diag = cita.getDiagnostico_cita();
        Doctor doctor = daoDoctor.doctorGet(iddoctor);
        List<CitaDoctorDTO> list = daoCita.citaDoctorDTOSel(doctor.getIddoctor());

        if (diag.equals(" ")) {
            result.append("<li>La cita no cuenta con un diagnostico</li>");
        }

        if (result.length() > 4) {
            request.setAttribute("id", iddoctor);
            request.setAttribute("idDoctor", doctor.getIddoctor());
            request.setAttribute("NombreDoctor", doctor.getNombres_doctor());
            request.setAttribute("ApellidosDoctor", doctor.getApellidos_doctor());
            request.setAttribute("list", list);
            request.setAttribute("doctor", doctor);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }
}

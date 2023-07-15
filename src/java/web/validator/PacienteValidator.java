package web.validator;

import dao.DaoAdministrador;
import dao.DaoPaciente;
import dao.impl.DaoAdministradorImpl;
import dao.impl.DaoPacienteImpl;
import entidades.Administrador;
import entidades.Paciente;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import util.DeString;

public class PacienteValidator {

    private final HttpServletRequest request;
    private final DaoPaciente daoPaciente;
    private final DaoAdministrador daoAdministrador;
    public Integer idUPD2 = 0;

    public PacienteValidator(HttpServletRequest request) {
        this.request = request;
        this.daoPaciente = new DaoPacienteImpl();
        this.daoAdministrador = new DaoAdministradorImpl();
    }

    public String pacienteSel() {
        String result = null;
        List<Paciente> list = daoPaciente.pacienteSel();
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        
        if (list != null) {
            request.setAttribute("list", list);
        } else {
            result = daoPaciente.getMessage();
        }
        return result;
    }
    
    public String pacienteGOINS() {
        String result = null;
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        return result;
    }
    
    public String pacienteSel2() {
        StringBuilder result = new StringBuilder("<ul>");
        String nro_doc = request.getParameter("nro_doc");
        Integer id = daoPaciente.pacienteNro_docDuplicado(nro_doc);
        List<Paciente> list = daoPaciente.pacienteSel2(nro_doc);
        List<Paciente> list2 = daoPaciente.pacienteSel();
        
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        request.setAttribute("idAdministrador", admin.getIdadministrador());
        request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
        request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
        request.setAttribute("admin", admin);
        
        if (nro_doc == null || nro_doc.trim().length() == 0) {
            result.append("<li>Debe ingresar el Nro de Doc.</li>");
        }else if(id == null){
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
    
    public String pacienteSel3() {
        String result = null;
        String nro_doc = request.getParameter("nro_doc");
        List<Paciente> list = daoPaciente.pacienteSel2(nro_doc);
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

    public String pacienteGet() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Paciente paciente = daoPaciente.pacienteGet(id);
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Administrador admin = daoAdministrador.administradorGet(idadmin);
        
        if (paciente != null) {
            request.setAttribute("paciente", paciente);
            request.setAttribute("idAdministrador", admin.getIdadministrador());
            request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
            request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
            request.setAttribute("admin", admin);
        } else {
            result = daoPaciente.getMessage();
        }
        return result;
    }
    
    public String pacienteGet2() {
        String result = null;
        Integer id = DeString.aInteger(request.getParameter("id"));
        Paciente paciente = daoPaciente.pacienteGet(id);
        
        if (paciente != null) {
            request.setAttribute("paciente", paciente);
        } else {
            result = daoPaciente.getMessage();
        }
        return result;
    }

    public String pacienteLoginGet() {
        String result = null;
        String correo = request.getParameter("correo");
        String pass = request.getParameter("pass");
        Paciente paciente = daoPaciente.pacienteGetLogin(correo, pass);
        if (paciente != null) {
            request.setAttribute("paciente", paciente);
        } else {
            result = daoPaciente.getMessage();
        }
        return result;
    }

    public String pacienteInsUpd(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");
        Integer idpaciente = DeString.aInteger(request.getParameter("idpacientes"));
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        String tipo_doc = request.getParameter("tipo_doc_paciente");
        String nro_doc = request.getParameter("nro_doc_paciente");
        String nombres = request.getParameter("nombres_paciente");
        String apellidos = request.getParameter("apellidos_paciente");
        String telefono = request.getParameter("telefono_paciente");
        String direccion = request.getParameter("direccion_paciente");
        String correo = request.getParameter("correo_paciente");
        String password = request.getParameter("password_paciente");
        String aux = request.getParameter("fecha_nacimiento_paciente");
        LocalDate fecha_nacimiento = (aux == null || aux.trim().length() == 0)
                ? null
                : LocalDate.parse(aux);
        LocalDate hoy = LocalDate.now();
        LocalDate registromin = hoy.plusYears(-4);
        LocalDate registromax = hoy.plusYears(-81);

        String Fnombre = FormatoString(nombres);
        String Fapellidos = FormatoString(apellidos);
        Boolean rsptaCorreo = CorreoEsGmail(correo);

        if (fecha_nacimiento == null) {
            result.append("<li>Fecha de nacimiento</li>");
        } else if (hoy.isBefore(fecha_nacimiento)) {
            result.append("<li>La fecha de nacimiento no puede ser una fecha futura</li>");
        } else if (registromin.isBefore(fecha_nacimiento)) {
            result.append("<li>La edad mínima del paciente debe ser 4 años</li>");
        } else if (registromax.isAfter(fecha_nacimiento)) {
            result.append("<li>La edad máxima del paciente debe ser 80 años</li>");
        }

        Period edad_aux = (aux == null || aux.trim().length() == 0)
                ? null
                : Period.between(fecha_nacimiento, LocalDate.now());
        Integer edad = (aux == null || aux.trim().length() == 0)
                ? null
                : (Integer) edad_aux.getYears();

        Integer rspta = daoPaciente.pacienteNro_docDuplicado(nro_doc);
        Integer rsptaCorreo2 = daoPaciente.pacienteCorreoDuplicado(correo);

        String nro_doc_Est = null;
        String correo_Est = null;
        if (upd == true) {
            Paciente pac = daoPaciente.pacienteGet(idpaciente);
            nro_doc_Est = pac.getNro_doc_paciente();
            correo_Est = pac.getCorreo_paciente();
        }

        if (upd && idpaciente == null) {
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
        }else if (!rsptaCorreo) {
            result.append("<li>El correo debe ser Gmail</li>");
        }else if (upd == false && rsptaCorreo2 != null) {
            result.append("<li>El correo ya ha sido registrado, ingrese otro</li>");
        }else if (upd == true && rsptaCorreo2 != null && !correo.equals(correo_Est)) {
            result.append("<li>El correo ya ha sido registrado por otro usuario</li>")
                    .append(" Ingrese otro</li>");
        }
        
        if (password == null || password.trim().length() == 0) {
            result.append("<li>Contraseña</li>");
        }

        Paciente paciente = new Paciente();
        paciente.setIdpacientes(idpaciente);
        paciente.setTipo_doc_paciente(tipo_doc);
        paciente.setNro_doc_paciente(nro_doc);
        paciente.setNombres_paciente(Fnombre);
        paciente.setApellidos_paciente(Fapellidos);
        paciente.setTelefono_paciente(telefono);
        paciente.setDireccion_paciente(direccion);
        paciente.setCorreo_paciente(correo);
        paciente.setPassword_paciente(password);
        paciente.setFecha_nacimiento_paciente(fecha_nacimiento);
        paciente.setEdad_paciente(edad);

        if (result.length() == 4) {
            String msg = upd
                    ? daoPaciente.pacienteUpd(paciente)
                    : daoPaciente.pacienteIns(paciente);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("paciente", paciente);
            Administrador admin = daoAdministrador.administradorGet(idadmin);
            request.setAttribute("idAdministrador", admin.getIdadministrador());
            request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
            request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
            request.setAttribute("admin", admin);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }

    public String pacienteInsUpd2(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");
        Integer idpaciente = DeString.aInteger(request.getParameter("idpacientes"));
        String tipo_doc = request.getParameter("tipo_doc_paciente");
        String nro_doc = request.getParameter("nro_doc_paciente");
        String nombres = request.getParameter("nombres_paciente");
        String apellidos = request.getParameter("apellidos_paciente");
        String telefono = request.getParameter("telefono_paciente");
        String direccion = request.getParameter("direccion_paciente");
        String correo = request.getParameter("correo_paciente");
        String password = request.getParameter("password_paciente");
        String aux = request.getParameter("fecha_nacimiento_paciente");
        LocalDate fecha_nacimiento = (aux == null || aux.trim().length() == 0)
                ? null
                : LocalDate.parse(aux);
        LocalDate hoy = LocalDate.now();
        LocalDate registromin = hoy.plusYears(-4);
        LocalDate registromax = hoy.plusYears(-81);

        String Fnombre = FormatoString(nombres);
        String Fapellidos = FormatoString(apellidos);
        Boolean rsptaCorreo = CorreoEsGmail(correo);
        

        if (fecha_nacimiento == null) {
            result.append("<li>Fecha de nacimiento</li>");
        } else if (hoy.isBefore(fecha_nacimiento)) {
            result.append("<li>La fecha de nacimiento no puede ser una fecha futura</li>");
        } else if (registromin.isBefore(fecha_nacimiento)) {
            result.append("<li>La edad mínima del paciente debe ser 4 años</li>");
        } else if (registromax.isAfter(fecha_nacimiento)) {
            result.append("<li>La edad máxima del paciente debe ser 80 años</li>");
        }

        Period edad_aux = (aux == null || aux.trim().length() == 0)
                ? null
                : Period.between(fecha_nacimiento, LocalDate.now());
        Integer edad = (aux == null || aux.trim().length() == 0)
                ? null
                : (Integer) edad_aux.getYears();

        Integer rspta = daoPaciente.pacienteNro_docDuplicado(nro_doc);
        Integer rsptaCorreo2 = daoPaciente.pacienteCorreoDuplicado(correo);
        
        Paciente pac = daoPaciente.pacienteGet(idpaciente);
        String nro_doc_Est = pac.getNro_doc_paciente();
        String correo_Est = pac.getCorreo_paciente();
        
        if (upd && idpaciente == null) {
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
        }else if (!rsptaCorreo) {
            result.append("<li>El correo debe ser Gmail</li>");
        }else if (upd == false && rsptaCorreo2 != null) {
            result.append("<li>El correo ya ha sido registrado, ingrese otro</li>");
        }else if (upd == true && rsptaCorreo2 != null && !correo.equals(correo_Est)) {
            result.append("<li>El correo ya ha sido registrado por otro usuario</li>")
                    .append(" Ingrese otro</li>");
        }
        
        
        /*
        else if (upd == false && rspta != null) {
            result.append("<li>El Nro de Doc. ya ha sido registrado, ingrese otro</li>");
        } else if (upd == true && rspta != null && !nro_doc.equals(nro_doc_Est)) {
            result.append("<li>El Nro de Doc. ya ha sido registrado por otro usuario</li>")
                    .append(" Ingrese otro</li>");
        }
        */
        
        if (password == null || password.trim().length() == 0) {
            result.append("<li>Contraseña</li>");
        }

        Paciente paciente = new Paciente();
        paciente.setIdpacientes(idpaciente);
        paciente.setTipo_doc_paciente(tipo_doc);
        paciente.setNro_doc_paciente(nro_doc);
        paciente.setNombres_paciente(Fnombre);
        paciente.setApellidos_paciente(Fapellidos);
        paciente.setTelefono_paciente(telefono);
        paciente.setDireccion_paciente(direccion);
        paciente.setCorreo_paciente(correo);
        paciente.setPassword_paciente(password);
        paciente.setFecha_nacimiento_paciente(fecha_nacimiento);
        paciente.setEdad_paciente(edad);

        idUPD2 = idpaciente;
        if (result.length() == 4) {
            String msg = upd
                    ? daoPaciente.pacienteUpd(paciente)
                    : daoPaciente.pacienteIns(paciente);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("paciente", paciente);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }
    
    //VER SI LO USO, PARA CUANDO UN PACIENTE QUIERE REGISTRARSE
    public String pacienteInsUpd3(boolean upd) {

        StringBuilder result = new StringBuilder("<ul>");
        Integer idpaciente = DeString.aInteger(request.getParameter("idpacientes"));
        String tipo_doc = request.getParameter("tipo_doc_paciente");
        String nro_doc = request.getParameter("nro_doc_paciente");
        String nombres = request.getParameter("nombres_paciente");
        String apellidos = request.getParameter("apellidos_paciente");
        String telefono = request.getParameter("telefono_paciente");
        String direccion = request.getParameter("direccion_paciente");
        String correo = request.getParameter("correo_paciente");
        String password = request.getParameter("password_paciente");
        String aux = request.getParameter("fecha_nacimiento_paciente");
        LocalDate fecha_nacimiento = (aux == null || aux.trim().length() == 0)
                ? null
                : LocalDate.parse(aux);
        LocalDate hoy = LocalDate.now();
        LocalDate registromin = hoy.plusYears(-4);
        LocalDate registromax = hoy.plusYears(-81);

        String Fnombre = FormatoString(nombres);
        String Fapellidos = FormatoString(apellidos);
        Boolean rsptaCorreo = CorreoEsGmail(correo);

        if (fecha_nacimiento == null) {
            result.append("<li>Fecha de nacimiento</li>");
        } else if (hoy.isBefore(fecha_nacimiento)) {
            result.append("<li>La fecha de nacimiento no puede ser una fecha futura</li>");
        } else if (registromin.isBefore(fecha_nacimiento)) {
            result.append("<li>La edad mínima del paciente debe ser 4 años</li>");
        } else if (registromax.isAfter(fecha_nacimiento)) {
            result.append("<li>La edad máxima del paciente debe ser 80 años</li>");
        }

        Period edad_aux = (aux == null || aux.trim().length() == 0)
                ? null
                : Period.between(fecha_nacimiento, LocalDate.now());
        Integer edad = (aux == null || aux.trim().length() == 0)
                ? null
                : (Integer) edad_aux.getYears();

        Integer rspta = daoPaciente.pacienteNro_docDuplicado(nro_doc);
        Integer rsptaCorreo2 = daoPaciente.pacienteCorreoDuplicado(correo);

        String nro_doc_Est = null;
        String correo_Est = null;
        if (upd == true) {
            Paciente pac = daoPaciente.pacienteGet(idpaciente);
            nro_doc_Est = pac.getNro_doc_paciente();
            correo_Est = pac.getCorreo_paciente();
        }

        if (upd && idpaciente == null) {
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
        }else if (!rsptaCorreo) {
            result.append("<li>El correo debe ser Gmail</li>");
        }else if (upd == false && rsptaCorreo2 != null) {
            result.append("<li>El correo ya ha sido registrado, ingrese otro</li>");
        }else if (upd == true && rsptaCorreo2 != null && !correo.equals(correo_Est)) {
            result.append("<li>El correo ya ha sido registrado por otro usuario</li>")
                    .append(" Ingrese otro</li>");
        }
        
        if (password == null || password.trim().length() == 0) {
            result.append("<li>Contraseña</li>");
        }

        Paciente paciente = new Paciente();
        paciente.setIdpacientes(idpaciente);
        paciente.setTipo_doc_paciente(tipo_doc);
        paciente.setNro_doc_paciente(nro_doc);
        paciente.setNombres_paciente(Fnombre);
        paciente.setApellidos_paciente(Fapellidos);
        paciente.setTelefono_paciente(telefono);
        paciente.setDireccion_paciente(direccion);
        paciente.setCorreo_paciente(correo);
        paciente.setPassword_paciente(password);
        paciente.setFecha_nacimiento_paciente(fecha_nacimiento);
        paciente.setEdad_paciente(edad);

        if (result.length() == 4) {
            String msg = upd
                    ? daoPaciente.pacienteUpd(paciente)
                    : daoPaciente.pacienteIns(paciente);
            if (msg != null) {
                result.append("<li>").append(msg).append("</li>");
            }
        }
        if (result.length() > 4) {
            request.setAttribute("paciente", paciente);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }


    public String pacienteDel() {
        List<Integer> ids = DeString.ids(request.getParameter("ids"));
        String result = (ids != null)
                ? daoPaciente.pacienteDel(ids)
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
    
    public Boolean CorreoEsGmail(String correo){
        return correo.endsWith("@gmail.com");
    }

    public String citaGenReporte() {
        StringBuilder result = new StringBuilder("<ul>");
        String PDF_Param = request.getParameter("PDF_Param");
        Integer idadmin = DeString.aInteger(request.getParameter("idadmin"));
        Integer idpac = Integer.parseInt(PDF_Param);
        String jasper = request.getParameter("jasper");

        Integer rspta = daoPaciente.pacienteTieneCita(idpac);

        if (rspta == null) {
            result.append("<li>El paciente no cuenta con Citas</li>");
        }

        if (result.length() > 4) {
            List<Paciente> list = daoPaciente.pacienteSel();
            request.setAttribute("list", list);
            Administrador admin = daoAdministrador.administradorGet(idadmin);
            request.setAttribute("idAdministrador", admin.getIdadministrador());
            request.setAttribute("NombreAdministrador", admin.getNombres_administrador());
            request.setAttribute("ApellidosAdministrador", admin.getApellidos_administrador());
            request.setAttribute("admin", admin);
        }

        return result.length() == 4 ? null : result.append("</ul>").toString();

    }
}

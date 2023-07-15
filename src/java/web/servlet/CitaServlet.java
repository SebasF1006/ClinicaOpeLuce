package web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.CitaValidator;

@WebServlet(name = "CitaServlet", urlPatterns = {"/Cita"})
public class CitaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "citaPacienteSel.jsp";

        CitaValidator validator = new CitaValidator(request);

        switch (accion) {
            case "SEL":
                result = validator.citaGet2();
                break;
            case "SEL2":
                result = validator.citaSel();
                target = "citaSel.jsp";
                break;
            case "SEL3":
                result = validator.citaGet3();
                target="citaDoctorSel.jsp";
                break;
            case "SEL4":
                result = validator.citaSel2();
                target = result == null ? "citaPacienteBuscar.jsp" : "citaSel.jsp";
                break;
            case "SEL5":
                result = validator.citaSel4();
                target = "citaSel.jsp";
                break;
            case "SEL6":
                result = validator.citaSel3();
                target = result == null ? "citaDoctorBuscar.jsp" : "citaSel.jsp";
                break;
            case "SEL7":
                result = validator.citaSel5();
                target = "citaSel.jsp";
                break;
            case "SEL8":
                target = "cita.jsp";
                break;
            case "INS":
                result = validator.citaInsUpd(false);
                String id = validator.idPac.toString();
                //"Administrador?accion=SEL"
                target = result == null ? "citaPaciente.jsp" : "citaPacienteIns.jsp";
                break;
            case "DEL":
                result = validator.citaDel();
                target = "cita.jsp";
                break;
            case "DEL2":
                result = validator.citaDel2();
                //target = "Cita?accion=SEL&id="+id2;
                target = "citaPaciente.jsp";
                break;
            case "DEL3":
                result = validator.citaDel2();
                //target = "Cita?accion=SEL&id="+id2;
                target = "citaDoctor.jsp";
                break;    
            case "GET":
                result = validator.citaGet2();
                target = "citaPacienteIns.jsp";
                break;
            case "GET2":
                result = validator.citaGet3();
                target = "citaDiagnosticoIns.jsp";
                break;
            case "GET3":
                result = validator.citaGet4();
                target = "citaDiagnosticoIns.jsp";
                break;
            case "DINS":
                result = validator.citaDiagnosticoIns();
                String iddoc = validator.idPac.toString();
                target = result == null ? "citaDoctor.jsp" : "citaDiagnosticoIns.jsp";
                break;
            case "GEN":
                result = validator.citaGenReporte();
                target = result == null ? "PDF.jsp" : "citaSel.jsp";
                break;
            /*case "UPD":
                result = validator.citaInsUpd(true);
                target = result == null ? "cita.jsp" : "citaUpd.jsp";
                break;*/
            case "":
                result = "Solicitud requerida";
                break;
            default:
                result = "Solicitud no reconocida";
        }

        if (result != null) {
            request.setAttribute("message", result);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

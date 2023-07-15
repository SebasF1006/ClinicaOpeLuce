package web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.PacienteValidator;

@WebServlet(name = "PacienteServlet", urlPatterns = {"/Paciente"})
public class PacienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "pacienteSel.jsp";

        PacienteValidator validator = new PacienteValidator(request);

        switch (accion) {
            case "SEL":
                result = validator.pacienteSel();
                break;
            case "SEL2":
                result = validator.pacienteSel3();
                break;
            case "SEL3":
                target = "paciente.jsp";
                break;
            case "SEL4":
                result = validator.pacienteSel2();
                target = result == null ? "pacienteBuscar.jsp" : "pacienteSel.jsp";
                break;
            case "GOINS":
                result = validator.pacienteGOINS();
                target = "pacienteIns.jsp";
                break;
            case "INS":
                result = validator.pacienteInsUpd(false);
                target = result == null ? "paciente.jsp" : "pacienteIns.jsp";
                break;
            case "INS2":
                result = validator.pacienteInsUpd3(false);
                target = result == null ? "login.jsp" : "LoginPaciente.jsp";
                break;
            case "DEL":
                result = validator.pacienteDel();
                target = "paciente.jsp";
                break;
            case "GET":
                result = validator.pacienteGet();
                target = "pacienteUpd.jsp";
                break;
            case "GET2":
                result = validator.pacienteGet2();
                target = "pacienteUpd2.jsp";
                break;
            case "UPD":
                result = validator.pacienteInsUpd(true);
                target = result == null ? "paciente.jsp" : "pacienteUpd.jsp";
                break;
            case "UPD2":
                result = validator.pacienteInsUpd2(true);
                String id = validator.idUPD2.toString();
                target = result == null ? "citaPaciente.jsp" : "pacienteUpd2.jsp";
                break;
            case "GEN":
                result = validator.citaGenReporte();
                target = result == null ? "PDF.jsp" : "pacienteSel.jsp";
                break;
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

package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.DoctorValidator;


@WebServlet(name = "DoctorServlet", urlPatterns = {"/Doctor"})
public class DoctorServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "doctorSel.jsp";

        DoctorValidator validator = new DoctorValidator(request);

        switch (accion) {
            case "SEL":
                result = validator.doctorSel();
                break;
            case "SEL2":
                result = validator.doctorSel3();
                break;
            case "SEL3":
                target = "doctor.jsp";
                break;
            case "SEL4":
                result = validator.doctorSel2();
                target = result == null ? "doctorBuscar.jsp" : "doctorSel.jsp";
                break;
            case "GOINS":
                result = validator.doctorGOINS();
                target = "doctorIns.jsp";
                break;
            case "INS":
                result = validator.doctorInsUpd(false);
                target = result == null ? "doctor.jsp" : "doctorIns.jsp";
                break;
            case "DEL":
                result = validator.doctorDel();
                target = "doctor.jsp";
                break;
            case "GET":
                result = validator.doctorGet();
                target = "doctorUpd.jsp";
                break;
            case "GET2":
                result = validator.doctorGet2();
                target = "doctorUpd2.jsp";
                break;
            case "UPD":
                result = validator.doctorInsUpd(true);
                target = result == null ? "doctor.jsp" : "doctorUpd.jsp";
                break;
            case "UPD2":
                result = validator.doctorInsUpd2(true);
                String id = validator.idUPD2.toString();
                target = result == null ? "citaDoctor.jsp" : "doctorUpd2.jsp";
                break;
            case "GEN":
                result = validator.citaGenReporte();
                target = result == null ? "PDF.jsp" : "doctorSel.jsp";
                break;
            case "GEN2":
                result = validator.citaGenReporte2();
                target = result == null ? "PDF.jsp" : "citaDoctorSel.jsp";
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

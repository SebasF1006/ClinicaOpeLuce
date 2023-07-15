package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.AdministradorValidator;

@WebServlet(name = "AdministradorServlet", urlPatterns = {"/Administrador"})
public class AdministradorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = "administradorSel.jsp";

        AdministradorValidator validator = new AdministradorValidator(request);

        switch (accion) {
            case "SEL":
                result = validator.administradorSel();
                break;
            case "SEL2":
                result = validator.administradorSel3();
                break;
            case "SEL3":
                target = "administrador.jsp";
                break;
            case "SEL4":
                result = validator.administradorSel2();
                target = result == null ? "administradorBuscar.jsp" : "administradorSel.jsp";
                break;
            case "GOINS":
                result = validator.administradorGOINS();
                target = "administradorIns.jsp";
                break;
            case "INS":
                result = validator.administradorInsUpd(false);
                target = result == null ? "administrador.jsp" : "administradorIns.jsp";
                break;
            case "DEL":
                result = validator.administradorDel();
                target = "administrador.jsp";
                break;
            case "GET":
                result = validator.administradorGet();
                target = "administradorUpd.jsp";
                break;
            case "UPD":
                result = validator.administradorInsUpd(true);
                target = result == null ? "administrador.jsp" : "administradorUpd.jsp";
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

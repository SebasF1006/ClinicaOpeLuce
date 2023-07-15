
package web.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.validator.LoginValidator;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //String accion = request.getParameter("accion");
        //accion = (accion == null) ? "" : accion;
        
        /* Variable auxiliar, cuando sea null todo está bien, 
        si tiene contenido es un mensaje de error  */
        String result = null;
        
        /* Variable contiene la ubicación a la cual ir*/
        String target = "login.jsp";
        
        /* Clase de apoyo para validar la información*/
        LoginValidator validator = new LoginValidator(request);
        
        /* Ejecuto el proceso de login y devuelvo errores si los hay*/
        result = validator.login();
        String rsptaTarget = validator.rsptaTarget;
        rsptaTarget = rsptaTarget == null ? "" : rsptaTarget;
        
        /* Si hay errores me quedo en "login", caso contrario voy a "intranet"*/
        if (rsptaTarget.equals("Paciente")) {
            target="citaPacienteSel.jsp";
        }else if (rsptaTarget.equals("Doctor")) {
            target="citaDoctorSel.jsp";
        }else if (rsptaTarget.equals("Administrador")) {
            target="administradorLogin.jsp";
        }/*else {
            target="login.jsp";
        }*/
        
        //target = result == null ? "intranet.jsp" : "login.jsp";
        
        /* Verifico si hay errores y los envío al JSP*/
        if (result != null) {
            request.setAttribute("message", result);
        }
        
        /* Me dirijo a la página objetivo  (target)*/
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

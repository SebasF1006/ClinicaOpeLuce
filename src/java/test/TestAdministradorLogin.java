package test;

import dao.DaoAdministrador;
import dao.impl.DaoAdministradorImpl;
import entidades.Administrador;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestAdministradorLogin {

    public static void main(String[] args) {

        //TEST METODO administradorLogin()
        Boolean rspta = null;
        String correo = "prueba@gmail.com";
        String pass = "prueba123555";
        DaoAdministrador dao = new DaoAdministradorImpl();
        try {
            rspta = dao.administradorLogin(correo, pass);
            System.out.println(rspta);
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }

}

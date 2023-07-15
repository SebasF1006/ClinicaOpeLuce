package test;

import dao.DaoAdministrador;
import dao.impl.DaoAdministradorImpl;
import entidades.Administrador;


public class TestAdministradorGet {
    
    public static void main(String[] args) {

        
        Administrador doc;
        DaoAdministrador dao = new DaoAdministradorImpl();
        try {
            doc = dao.administradorGet(1);
            System.out.println(doc.getNombres_administrador());
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

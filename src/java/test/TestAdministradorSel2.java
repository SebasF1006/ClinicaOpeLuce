package test;

import dao.DaoAdministrador;
import dao.impl.DaoAdministradorImpl;
import entidades.Administrador;
import java.util.List;


public class TestAdministradorSel2 {
    
    public static void main(String[] args) {

        
        List<Administrador> listado = null;
        DaoAdministrador dao = new DaoAdministradorImpl();
        try {
            listado = dao.administradorSel2("5896547252545");
            listado.forEach((t) -> {
                System.out.println(t.getIdadministrador());
            });
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }
    
}

package test;

import dao.DaoAdministrador;
import dao.impl.DaoAdministradorImpl;
import entidades.Administrador;
import java.util.List;


public class TestAdministradorSel {
    
    public static void main(String[] args) {

        
        List<Administrador> listado = null;
        DaoAdministrador dao = new DaoAdministradorImpl();
        try {
            listado = dao.administradorSel();
            listado.forEach((t) -> {
                System.out.println(t.getIdadministrador());
            });
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }
    
}

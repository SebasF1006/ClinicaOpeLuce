package test;

import dao.DaoAdministrador;
import dao.impl.DaoAdministradorImpl;
import java.util.ArrayList;
import java.util.List;


public class TestAdministradorDel {
    
    public static void main(String[] args) {

        
        DaoAdministrador daoAdministrador = new DaoAdministradorImpl();
        List<Integer> del = new ArrayList<>();
        del.add(8);
        try {
            System.out.println(daoAdministrador.administradorDel(del));
        } catch (Exception e) {
            System.out.println(daoAdministrador.getMessage());
            System.out.println(e.getMessage());
        }
    }
    
}
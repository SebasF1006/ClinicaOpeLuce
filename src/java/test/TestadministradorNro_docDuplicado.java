package test;

import dao.DaoAdministrador;
import dao.impl.DaoAdministradorImpl;


public class TestadministradorNro_docDuplicado {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoAdministrador dao = new DaoAdministradorImpl();
        try {
            rspta = dao.administradorNro_docDuplicado("98547856552");
            if (rspta==null) {
              System.out.println(rspta);
              System.out.println("El numero no esta repetido");
            }else{
                System.out.println(rspta);  
                System.out.println("El numero esta repetido");
            }
            
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

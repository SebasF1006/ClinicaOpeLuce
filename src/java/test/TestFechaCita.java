package test;

import dao.DaoCita;
import dao.impl.DaoCitaImpl;
import entidades.Administrador;


public class TestFechaCita {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoCita dao = new DaoCitaImpl();
        try {
            rspta = dao.FechaCita(null,null);
            if (rspta==null) {
              System.out.println(rspta);  
            }else{
                System.out.println(rspta);  
                System.out.println("SI DA");
            }
            
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

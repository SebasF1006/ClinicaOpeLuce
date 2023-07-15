package test;

import dao.DaoAdministrador;
import dao.DaoCita;
import dao.impl.DaoAdministradorImpl;
import dao.impl.DaoCitaImpl;


public class Testcita_Nro_Doc_Doc_Existe {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoCita dao = new DaoCitaImpl();
        try {
            rspta = dao.citaNro_Doc_Doc_Existe("147856852152");
            if (rspta==null) {
              System.out.println(rspta);
              System.out.println("El numero no existe");
            }else{
                System.out.println(rspta);  
                System.out.println("El numero existe");
            }
            
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

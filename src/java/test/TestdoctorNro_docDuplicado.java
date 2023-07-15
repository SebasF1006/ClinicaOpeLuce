package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;


public class TestdoctorNro_docDuplicado {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoDoctor dao = new DaoDoctorImpl();
        try {
            rspta = dao.doctorNro_docDuplicado("88556633554");
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

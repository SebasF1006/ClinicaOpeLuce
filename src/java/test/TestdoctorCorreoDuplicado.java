package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;


public class TestdoctorCorreoDuplicado {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoDoctor dao = new DaoDoctorImpl();
        try {
            rspta = dao.doctorCorreoDuplicado("felisa42ew@hotmail.com");
            if (rspta==null) {
              System.out.println(rspta);
              System.out.println("El correo no esta repetido");
            }else{
                System.out.println(rspta);  
                System.out.println("El correo esta repetido");
            }
            
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

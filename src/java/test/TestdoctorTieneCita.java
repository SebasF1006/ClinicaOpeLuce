package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;
import entidades.Doctor;


public class TestdoctorTieneCita {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoDoctor dao = new DaoDoctorImpl();
        try {
            rspta = dao.doctorTieneCita(16);
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

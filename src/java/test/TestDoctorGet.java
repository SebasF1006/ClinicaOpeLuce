package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;
import entidades.Doctor;


public class TestDoctorGet {
    
    public static void main(String[] args) {

        
        Doctor doc;
        DaoDoctor dao = new DaoDoctorImpl();
        try {
            doc = dao.doctorGet(1);
            System.out.println(doc.getNombres_doctor());
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

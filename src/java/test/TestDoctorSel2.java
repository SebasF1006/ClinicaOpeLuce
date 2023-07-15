package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;
import entidades.Doctor;
import java.util.List;


public class TestDoctorSel2 {
    
    public static void main(String[] args) {

        
        List<Doctor> listado = null;
        DaoDoctor dao = new DaoDoctorImpl();
        try {
            listado = dao.doctorSel2("785412580");
            listado.forEach((t) -> {
                System.out.println(t.getIddoctor());
            });
        } catch (Exception e) {
            dao.getMessage();
        }
        
    }
    
}

package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;
import java.util.ArrayList;
import java.util.List;


public class TestDoctorDel {
    
    public static void main(String[] args) {

        
        DaoDoctor daoDoctor = new DaoDoctorImpl();
        List<Integer> del = new ArrayList<>();
        del.add(11);
        try {
            System.out.println(daoDoctor.doctorDel(del));
        } catch (Exception e) {
            System.out.println(daoDoctor.getMessage());
            System.out.println(e.getMessage());
        }
    }
    
}

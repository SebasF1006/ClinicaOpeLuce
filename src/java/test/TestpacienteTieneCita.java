package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;


public class TestpacienteTieneCita {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoPaciente dao = new DaoPacienteImpl();
        try {
            rspta = dao.pacienteTieneCita(100);
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

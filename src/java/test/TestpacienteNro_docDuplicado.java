package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;


public class TestpacienteNro_docDuplicado {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoPaciente dao = new DaoPacienteImpl();
        try {
            rspta = dao.pacienteNro_docDuplicado("1254785491");
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

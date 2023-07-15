package test;

import dao.DaoPaciente;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;


public class TestpacienteCorreoDuplicado {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoPaciente dao = new DaoPacienteImpl();
        try {
            rspta = dao.pacienteCorreoDuplicado("sebasti200255@gmail.com");
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

package test;

import dao.DaoAdministrador;
import dao.DaoPaciente;
import dao.impl.DaoAdministradorImpl;
import dao.impl.DaoPacienteImpl;
import entidades.Paciente;


public class TestadministradorCorreoDuplicado {
    
    public static void main(String[] args) {

        
        Integer rspta;
        DaoAdministrador dao = new DaoAdministradorImpl();
        try {
            rspta = dao.administradorCorreoDuplicado("domingog@hotmail.com");
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

package test;

import dao.DaoAdministrador;
import dao.impl.DaoAdministradorImpl;
import entidades.Administrador;
import java.time.LocalDate;


public class TestAdministradorUpd {
   
    public static void main(String[] args) {

        
        Administrador administrador = new Administrador();
        administrador.setIdadministrador(8);
        administrador.setTipo_doc_administrador("DNI");
        administrador.setNro_doc_administrador("53673742");
        administrador.setNombres_administrador("PEDRO");
        administrador.setApellidos_administrador("GOMEZ GARCIA");
        administrador.setTelefono_administrador("991237822");
        administrador.setDireccion_administrador("CALLE PERI 1568");
        administrador.setCorreo_administrador("QUISAL@gmail.com");
        administrador.setPassword_administrador("aq991237822");
        administrador.setFecha_nacimiento_administrador(LocalDate.parse("1999-12-28"));
        administrador.setEdad_administrador(22);

        DaoAdministrador dao = new DaoAdministradorImpl();
        try {
            System.out.println(dao.administradorUpd(administrador));
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

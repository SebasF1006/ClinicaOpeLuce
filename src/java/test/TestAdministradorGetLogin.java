package test;

import dao.DaoAdministrador;
import dao.DaoPaciente;
import dao.impl.DaoAdministradorImpl;
import dao.impl.DaoPacienteImpl;
import entidades.Administrador;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestAdministradorGetLogin {

    public static void main(String[] args) {

        //TEST METODO pacienteGetLogin();
        Administrador adm;
        DaoAdministrador dao = new DaoAdministradorImpl();
        String correo ="domingog@hotmail.com";
        String pass = "domingo123";
        try {
            adm = dao.administradorGetLogin(correo, pass);
            System.out.println(adm.getNombres_administrador() + " "+adm.getApellidos_administrador());
            System.out.println(adm.getIdadministrador());
        } catch (Exception e) {
            dao.getMessage();
        }

    }

}

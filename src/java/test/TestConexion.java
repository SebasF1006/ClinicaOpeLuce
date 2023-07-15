package test;

import java.sql.Connection;
import util.ConexionBD;

public class TestConexion {

    public static void main(String[] args) {
       
        ConexionBD cbd = new ConexionBD();
        try(Connection cn = cbd.conexionDB()){
            System.out.println("Conexion establecida");
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        
    }
    
}

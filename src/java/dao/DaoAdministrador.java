package dao;

import entidades.Administrador;
import java.util.List;

public interface DaoAdministrador {
    List <Administrador> administradorSel();
    List <Administrador> administradorSel2(String nro_doc);
    Administrador administradorGet(Integer id);
    String administradorIns(Administrador administrador);
    String administradorUpd(Administrador administrador);
    String administradorDel(List<Integer> ids);
    Boolean administradorLogin(String correo, String pass);
    Administrador administradorGetLogin(String correo, String pass);
    Integer administradorNro_docDuplicado(String Nro_doc);
    Integer administradorCorreoDuplicado(String correo);
    String getMessage();
}

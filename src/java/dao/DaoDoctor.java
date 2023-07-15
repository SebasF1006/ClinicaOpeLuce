package dao;

import entidades.Doctor;
import java.util.List;

public interface DaoDoctor {
    List <Doctor> doctorSel();
    List <Doctor> doctorSel2(String nro_doc);
    Doctor doctorGet(Integer id);
    String doctorIns(Doctor doctor);
    String doctorUpd(Doctor doctor);
    String doctorDel(List<Integer> ids);
    Boolean doctorLogin(String correo, String pass);
    Doctor doctorGetLogin(String correo, String pass);
    Integer doctorTieneCita(Integer iddoctor);
    Integer doctorNro_docDuplicado(String Nro_doc);
    Integer doctorCorreoDuplicado(String correo);
    String getMessage();
}

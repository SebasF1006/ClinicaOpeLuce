package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;
import entidades.Doctor;
import java.time.LocalDate;


public class TestDoctorUpd {
   
    public static void main(String[] args) {

        
        Doctor doctor = new Doctor();
        doctor.setIddoctor(11);
        doctor.setTipo_doc_doctor("DNI");
        doctor.setNro_doc_doctor("12489023");
        doctor.setNombres_doctor("ROBERTA");
        doctor.setApellidos_doctor("JONES SMITH");
        doctor.setEspecialidad_doctor("Consulta Pediatrica");
        doctor.setTelefono_doctor("997777822");
        doctor.setDireccion_doctor("CALLE PERI 1568");
        doctor.setCorreo_doctor("robertaj@gmail.com");
        doctor.setPassword_doctor("rj71222222");
        doctor.setFecha_nacimiento_doctor(LocalDate.parse("2010-12-18"));
        doctor.setEdad_doctor(21);

        DaoDoctor dao = new DaoDoctorImpl();
        try {
            System.out.println(dao.doctorUpd(doctor));
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

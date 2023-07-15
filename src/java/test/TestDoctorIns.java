package test;

import dao.DaoDoctor;
import dao.impl.DaoDoctorImpl;
import entidades.Doctor;
import java.time.LocalDate;


public class TestDoctorIns {
    
    public static void main(String[] args) {

        
        Doctor doctor = new Doctor();
        doctor.setTipo_doc_doctor("DNI");
        doctor.setNro_doc_doctor("12489023");
        doctor.setNombres_doctor("MANUEL");
        doctor.setApellidos_doctor("MARLO CASAS");
        doctor.setEspecialidad_doctor("OCULISTA");
        doctor.setTelefono_doctor("923012345");
        doctor.setDireccion_doctor("JR INDEPENDENCIA 1243");
        doctor.setCorreo_doctor("marnu@gmail.com");
        doctor.setPassword_doctor("mm12489023");
        doctor.setFecha_nacimiento_doctor(LocalDate.parse("1980-04-18"));
        doctor.setEdad_doctor(42);

        DaoDoctor dao = new DaoDoctorImpl();
        try {
            System.out.println(dao.doctorIns(doctor));
        } catch (Exception e) {
            dao.getMessage();
        }

    }
    
}

package entidades;

import java.time.LocalDate;

public class Doctor {
    
    private Integer iddoctor;
    private String tipo_doc_doctor;
    private String nro_doc_doctor;
    private String nombres_doctor;
    private String apellidos_doctor;
    private String especialidad_doctor;
    private String telefono_doctor;
    private String direccion_doctor;
    private String correo_doctor;
    private String password_doctor;
    private LocalDate fecha_nacimiento_doctor;
    private Integer edad_doctor;

    public Doctor() {
        
    }

    public Integer getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(Integer iddoctor) {
        this.iddoctor = iddoctor;
    }

    public String getTipo_doc_doctor() {
        return tipo_doc_doctor;
    }

    public void setTipo_doc_doctor(String tipo_doc_doctor) {
        this.tipo_doc_doctor = tipo_doc_doctor;
    }

    public String getNro_doc_doctor() {
        return nro_doc_doctor;
    }

    public void setNro_doc_doctor(String nro_doc_doctor) {
        this.nro_doc_doctor = nro_doc_doctor;
    }

    public String getNombres_doctor() {
        return nombres_doctor;
    }

    public void setNombres_doctor(String nombres_doctor) {
        this.nombres_doctor = nombres_doctor;
    }

    public String getApellidos_doctor() {
        return apellidos_doctor;
    }

    public void setApellidos_doctor(String apellidos_doctor) {
        this.apellidos_doctor = apellidos_doctor;
    }

    public String getEspecialidad_doctor() {
        return especialidad_doctor;
    }

    public void setEspecialidad_doctor(String especialidad_doctor) {
        this.especialidad_doctor = especialidad_doctor;
    }

    public String getTelefono_doctor() {
        return telefono_doctor;
    }

    public void setTelefono_doctor(String telefono_doctor) {
        this.telefono_doctor = telefono_doctor;
    }

    public String getDireccion_doctor() {
        return direccion_doctor;
    }

    public void setDireccion_doctor(String direccion_doctor) {
        this.direccion_doctor = direccion_doctor;
    }

    public String getCorreo_doctor() {
        return correo_doctor;
    }

    public void setCorreo_doctor(String correo_doctor) {
        this.correo_doctor = correo_doctor;
    }

    public String getPassword_doctor() {
        return password_doctor;
    }

    public void setPassword_doctor(String password_doctor) {
        this.password_doctor = password_doctor;
    }

    public LocalDate getFecha_nacimiento_doctor() {
        return fecha_nacimiento_doctor;
    }

    public void setFecha_nacimiento_doctor(LocalDate fecha_nacimiento_doctor) {
        this.fecha_nacimiento_doctor = fecha_nacimiento_doctor;
    }

    public Integer getEdad_doctor() {
        return edad_doctor;
    }

    public void setEdad_doctor(Integer edad_doctor) {
        this.edad_doctor = edad_doctor;
    }
    
    
    
}

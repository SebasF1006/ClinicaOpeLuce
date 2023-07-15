package entidades;

import java.time.LocalDate;

public class Paciente {

    private Integer idpacientes;
    private String tipo_doc_paciente;
    private String nro_doc_paciente;
    private String nombres_paciente;
    private String apellidos_paciente;
    private String telefono_paciente;
    private String direccion_paciente;
    private String correo_paciente;
    private String password_paciente;
    private LocalDate fecha_nacimiento_paciente;
    private Integer edad_paciente;

    public Paciente() {

    }

    public Integer getIdpacientes() {
        return idpacientes;
    }

    public void setIdpacientes(Integer idpacientes) {
        this.idpacientes = idpacientes;
    }


    public String getTipo_doc_paciente() {
        return tipo_doc_paciente;
    }

    public void setTipo_doc_paciente(String tipo_doc_paciente) {
        this.tipo_doc_paciente = tipo_doc_paciente;
    }

    public String getNro_doc_paciente() {
        return nro_doc_paciente;
    }

    public void setNro_doc_paciente(String nro_doc_paciente) {
        this.nro_doc_paciente = nro_doc_paciente;
    }

    public String getNombres_paciente() {
        return nombres_paciente;
    }

    public void setNombres_paciente(String nombres_paciente) {
        this.nombres_paciente = nombres_paciente;
    }

    public String getApellidos_paciente() {
        return apellidos_paciente;
    }

    public void setApellidos_paciente(String apellidos_paciente) {
        this.apellidos_paciente = apellidos_paciente;
    }

    public String getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(String telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public String getDireccion_paciente() {
        return direccion_paciente;
    }

    public void setDireccion_paciente(String direccion_paciente) {
        this.direccion_paciente = direccion_paciente;
    }

    public String getCorreo_paciente() {
        return correo_paciente;
    }

    public void setCorreo_paciente(String correo_paciente) {
        this.correo_paciente = correo_paciente;
    }

    public String getPassword_paciente() {
        return password_paciente;
    }

    public void setPassword_paciente(String password_paciente) {
        this.password_paciente = password_paciente;
    }

    public LocalDate getFecha_nacimiento_paciente() {
        return fecha_nacimiento_paciente;
    }

    public void setFecha_nacimiento_paciente(LocalDate fecha_nacimiento_paciente) {
        this.fecha_nacimiento_paciente = fecha_nacimiento_paciente;
    }

    public Integer getEdad_paciente() {
        return edad_paciente;
    }

    public void setEdad_paciente(Integer edad_paciente) {
        this.edad_paciente = edad_paciente;
    }
    
    
}

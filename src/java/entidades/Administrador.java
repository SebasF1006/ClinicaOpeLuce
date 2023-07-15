
package entidades;

import java.time.LocalDate;

public class Administrador {
    
    private Integer idadministrador;
    private String tipo_doc_administrador;
    private String nro_doc_administrador;
    private String nombres_administrador;
    private String apellidos_administrador;
    private String telefono_administrador;
    private String direccion_administrador;
    private String correo_administrador;
    private String password_administrador;
    private LocalDate fecha_nacimiento_administrador;
    private Integer edad_administrador;
    
    public Administrador(){
        
    }

    public Integer getIdadministrador() {
        return idadministrador;
    }

    public void setIdadministrador(Integer idadministrador) {
        this.idadministrador = idadministrador;
    }

    public String getTipo_doc_administrador() {
        return tipo_doc_administrador;
    }

    public void setTipo_doc_administrador(String tipo_doc_administrador) {
        this.tipo_doc_administrador = tipo_doc_administrador;
    }

    public String getNro_doc_administrador() {
        return nro_doc_administrador;
    }

    public void setNro_doc_administrador(String nro_doc_administrador) {
        this.nro_doc_administrador = nro_doc_administrador;
    }

    public String getNombres_administrador() {
        return nombres_administrador;
    }

    public void setNombres_administrador(String nombres_administrador) {
        this.nombres_administrador = nombres_administrador;
    }

    public String getApellidos_administrador() {
        return apellidos_administrador;
    }

    public void setApellidos_administrador(String apellidos_administrador) {
        this.apellidos_administrador = apellidos_administrador;
    }

    public String getTelefono_administrador() {
        return telefono_administrador;
    }

    public void setTelefono_administrador(String telefono_administrador) {
        this.telefono_administrador = telefono_administrador;
    }

    public String getDireccion_administrador() {
        return direccion_administrador;
    }

    public void setDireccion_administrador(String direccion_administrador) {
        this.direccion_administrador = direccion_administrador;
    }

    public String getCorreo_administrador() {
        return correo_administrador;
    }

    public void setCorreo_administrador(String correo_administrador) {
        this.correo_administrador = correo_administrador;
    }

    public String getPassword_administrador() {
        return password_administrador;
    }

    public void setPassword_administrador(String password_administrador) {
        this.password_administrador = password_administrador;
    }

    public LocalDate getFecha_nacimiento_administrador() {
        return fecha_nacimiento_administrador;
    }

    public void setFecha_nacimiento_administrador(LocalDate fecha_nacimiento_administrador) {
        this.fecha_nacimiento_administrador = fecha_nacimiento_administrador;
    }

    public Integer getEdad_administrador() {
        return edad_administrador;
    }

    public void setEdad_administrador(Integer edad_administrador) {
        this.edad_administrador = edad_administrador;
    }

    
    
    
    
}

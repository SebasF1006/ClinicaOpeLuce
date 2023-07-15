
package DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaPacienteDTO {
    private Integer idcita;
    private Integer idpacientes;
    private String doctor;
    private String tipo_cita;
    private Double costo_cita;
    private LocalDate fecha_cita;
    private LocalTime hora_cita;
    
    public  CitaPacienteDTO() {
        
    }

    public Integer getIdcita() {
        return idcita;
    }

    public void setIdcita(Integer idcita) {
        this.idcita = idcita;
    }

    public Integer getIdpacientes() {
        return idpacientes;
    }

    public void setIdpacientes(Integer idpacientes) {
        this.idpacientes = idpacientes;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getTipo_cita() {
        return tipo_cita;
    }

    public void setTipo_cita(String tipo_cita) {
        this.tipo_cita = tipo_cita;
    }

    public Double getCosto_cita() {
        return costo_cita;
    }

    public void setCosto_cita(Double costo_cita) {
        this.costo_cita = costo_cita;
    }

    public LocalDate getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(LocalDate fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public LocalTime getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(LocalTime hora_cita) {
        this.hora_cita = hora_cita;
    }

    
    
    
}

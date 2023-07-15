package dao.impl;

import dao.DaoDoctor;
import entidades.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoDoctorImpl implements DaoDoctor {

    private final ConexionBD conectaDb;
    private String mensaje;

    public DaoDoctorImpl() {
        this.conectaDb = new ConexionBD();
    }

    /**
     * Selecciona todos los pacientes de la base de datos
     *
     * @param -
     * @return Lista de Doctores
     */
    @Override
    public List<Doctor> doctorSel() {
        List<Doctor> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("iddoctor,")
                .append("tipo_doc_doctor,")
                .append("nro_doc_doctor,")
                .append("nombres_doctor,")
                .append("apellidos_doctor,")
                .append("especialidad_doctor,")
                .append("telefono_doctor,")
                .append("direccion_doctor,")
                .append("correo_doctor,")
                .append("password_doctor,")
                .append("fecha_nacimiento_doctor,")
                .append("edad_doctor")
                .append(" FROM doctor");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setIddoctor(rs.getInt(1));
                doctor.setTipo_doc_doctor(rs.getString(2));
                doctor.setNro_doc_doctor(rs.getString(3));
                doctor.setNombres_doctor(rs.getString(4));
                doctor.setApellidos_doctor(rs.getString(5));
                doctor.setEspecialidad_doctor(rs.getString(6));
                doctor.setTelefono_doctor(rs.getString(7));
                doctor.setDireccion_doctor(rs.getString(8));
                doctor.setCorreo_doctor(rs.getString(9));
                doctor.setPassword_doctor(rs.getString(10));
                doctor.setFecha_nacimiento_doctor(LocalDate.parse(rs.getString(11)));
                doctor.setEdad_doctor(rs.getInt(12));
                list.add(doctor);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }
    
    @Override
    public List<Doctor> doctorSel2(String nro_doc) {
        List<Doctor> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("iddoctor,")
                .append("tipo_doc_doctor,")
                .append("nro_doc_doctor,")
                .append("nombres_doctor,")
                .append("apellidos_doctor,")
                .append("especialidad_doctor,")
                .append("telefono_doctor,")
                .append("direccion_doctor,")
                .append("correo_doctor,")
                .append("password_doctor,")
                .append("fecha_nacimiento_doctor,")
                .append("edad_doctor")
                .append(" FROM doctor")
                .append(" WHERE nro_doc_doctor = ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, nro_doc);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setIddoctor(rs.getInt(1));
                doctor.setTipo_doc_doctor(rs.getString(2));
                doctor.setNro_doc_doctor(rs.getString(3));
                doctor.setNombres_doctor(rs.getString(4));
                doctor.setApellidos_doctor(rs.getString(5));
                doctor.setEspecialidad_doctor(rs.getString(6));
                doctor.setTelefono_doctor(rs.getString(7));
                doctor.setDireccion_doctor(rs.getString(8));
                doctor.setCorreo_doctor(rs.getString(9));
                doctor.setPassword_doctor(rs.getString(10));
                doctor.setFecha_nacimiento_doctor(LocalDate.parse(rs.getString(11)));
                doctor.setEdad_doctor(rs.getInt(12));
                list.add(doctor);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * Buscar los datos de un doctor en especifico usando el id del doctor en la
     * base de datos
     *
     * @param id Int id identificador de doctores
     * @return Variable de tipo Doctor
     */
    @Override
    public Doctor doctorGet(Integer id) {
        Doctor doctor = new Doctor();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("iddoctor,")
                .append("tipo_doc_doctor,")
                .append("nro_doc_doctor,")
                .append("nombres_doctor,")
                .append("apellidos_doctor,")
                .append("especialidad_doctor,")
                .append("telefono_doctor,")
                .append("direccion_doctor,")
                .append("correo_doctor,")
                .append("password_doctor,")
                .append("fecha_nacimiento_doctor,")
                .append("edad_doctor")
                .append(" FROM doctor WHERE iddoctor = ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    doctor.setIddoctor(rs.getInt(1));
                    doctor.setTipo_doc_doctor(rs.getString(2));
                    doctor.setNro_doc_doctor(rs.getString(3));
                    doctor.setNombres_doctor(rs.getString(4));
                    doctor.setApellidos_doctor(rs.getString(5));
                    doctor.setEspecialidad_doctor(rs.getString(6));
                    doctor.setTelefono_doctor(rs.getString(7));
                    doctor.setDireccion_doctor(rs.getString(8));
                    doctor.setCorreo_doctor(rs.getString(9));
                    doctor.setPassword_doctor(rs.getString(10));
                    doctor.setFecha_nacimiento_doctor(LocalDate.parse(rs.getString(11)));
                    doctor.setEdad_doctor(rs.getInt(12));
                } else {
                    doctor = null;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return doctor;
    }

    /**
     * Insetar doctores a la base de datos
     *
     * @param doctor Doctor doctor
     * @return El mensaje correspondiente y datos insertados a la base de datos
     */
    @Override
    public String doctorIns(Doctor doctor) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO doctor( ")
                .append("tipo_doc_doctor,")
                .append("nro_doc_doctor,")
                .append("nombres_doctor,")
                .append("apellidos_doctor,")
                .append("especialidad_doctor,")
                .append("telefono_doctor,")
                .append("direccion_doctor,")
                .append("correo_doctor,")
                .append("password_doctor,")
                .append("fecha_nacimiento_doctor,")
                .append("edad_doctor")
                .append(") VALUES (?,?,?,?,?,?,?,?,?,?,?) ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, doctor.getTipo_doc_doctor());
            ps.setString(2, doctor.getNro_doc_doctor());
            ps.setString(3, doctor.getNombres_doctor());
            ps.setString(4, doctor.getApellidos_doctor());
            ps.setString(5, doctor.getEspecialidad_doctor());
            ps.setString(6, doctor.getTelefono_doctor());
            ps.setString(7, doctor.getDireccion_doctor());
            ps.setString(8, doctor.getCorreo_doctor());
            ps.setString(9, doctor.getPassword_doctor());
            ps.setString(10, doctor.getFecha_nacimiento_doctor().toString());
            ps.setInt(11, doctor.getEdad_doctor());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "cero filas insertadas";
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * Actualizar la informacion de doctores en la base de datos
     *
     * @param doctor Doctor doctor
     * @return El mensaje correspondiente y datos modificados del doctor en
     * especifico
     */
    @Override
    public String doctorUpd(Doctor doctor) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE doctor SET ")
                .append("tipo_doc_doctor = ?,")
                .append("nro_doc_doctor = ?,")
                .append("nombres_doctor = ?,")
                .append("apellidos_doctor = ?,")
                .append("especialidad_doctor = ?,")
                .append("telefono_doctor = ?,")
                .append("direccion_doctor = ?,")
                .append("correo_doctor = ?,")
                .append("password_doctor = ?,")
                .append("fecha_nacimiento_doctor = ?,")
                .append("edad_doctor = ? ")
                .append("WHERE iddoctor = ?  ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, doctor.getTipo_doc_doctor());
            ps.setString(2, doctor.getNro_doc_doctor());
            ps.setString(3, doctor.getNombres_doctor());
            ps.setString(4, doctor.getApellidos_doctor());
            ps.setString(5, doctor.getEspecialidad_doctor());
            ps.setString(6, doctor.getTelefono_doctor());
            ps.setString(7, doctor.getDireccion_doctor());
            ps.setString(8, doctor.getCorreo_doctor());
            ps.setString(9, doctor.getPassword_doctor());
            ps.setString(10, doctor.getFecha_nacimiento_doctor().toString());
            ps.setInt(11, doctor.getEdad_doctor());
            ps.setInt(12, doctor.getIddoctor());
            int ctos = ps.executeUpdate();
            if (ctos == 0) {
                mensaje = "No se pudo actualizar";
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * Borrar doctores de la base de datos siendo buscados por el id del doctor
     *
     * @param ids List Integer ids Lista de Identificador de doctor
     * @return El mensaje correspondiente y elimina los doctores de la base de
     * datos
     */
    @Override
    public String doctorDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM doctor WHERE ")
                .append("iddoctor = ? ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            cn.setAutoCommit(false);
            boolean ok = true;
            for (int id = 0; id < ids.size(); id++) {
                ps.setInt(1, ids.get(id));
                int ctos = ps.executeUpdate();
                if (ctos == 0) {
                    ok = false;
                    mensaje = "ID: " + ids.get(id) + " no existe";
                }
            }
            if (ok) {
                cn.commit();
            } else {
                cn.rollback();
            }
            cn.setAutoCommit(true);
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    /**
     * Retorna true si el usuario y contraseña existen o retona false si el
     * usuario y contraseña no existen
     *
     * @param correo String correo Correo del doctor
     * @param pass String pass Contrseña del doctor
     * @return Varible de tipo Boolean
     *
     */
    @Override
    public Boolean doctorLogin(String correo, String pass) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("correo_doctor,")
                .append("password_doctor")
                .append(" FROM doctor");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String correoDB = rs.getString(1);
                String passBD = rs.getString(2);
                if (correoDB.equals(correo) && passBD.equals(pass)) {
                    return true;
                }
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return null;
    }

    /**
     * Retorna un objeto Doctor
     *
     * @param correo String correo Correo del doctor
     * @param pass String pass Contrseña del doctor
     * @return Variable de tipo doctor
     */
    @Override
    public Doctor doctorGetLogin(String correo, String pass) {
        Doctor doctor = new Doctor();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("iddoctor,")
                .append("tipo_doc_doctor,")
                .append("nro_doc_doctor,")
                .append("nombres_doctor,")
                .append("apellidos_doctor,")
                .append("especialidad_doctor,")
                .append("telefono_doctor,")
                .append("direccion_doctor,")
                .append("correo_doctor,")
                .append("password_doctor,")
                .append("fecha_nacimiento_doctor,")
                .append("edad_doctor")
                .append(" FROM doctor WHERE correo_doctor = ?")
                .append(" AND password_doctor = ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, correo);
            ps.setString(2, pass);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    doctor.setIddoctor(rs.getInt(1));
                    doctor.setTipo_doc_doctor(rs.getString(2));
                    doctor.setNro_doc_doctor(rs.getString(3));
                    doctor.setNombres_doctor(rs.getString(4));
                    doctor.setApellidos_doctor(rs.getString(5));
                    doctor.setEspecialidad_doctor(rs.getString(6));
                    doctor.setTelefono_doctor(rs.getString(7));
                    doctor.setDireccion_doctor(rs.getString(8));
                    doctor.setCorreo_doctor(rs.getString(9));
                    doctor.setPassword_doctor(rs.getString(10));
                    doctor.setFecha_nacimiento_doctor(LocalDate.parse(rs.getString(11)));
                    doctor.setEdad_doctor(rs.getInt(12));
                } else {
                    doctor = null;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return doctor;
    }

    /**
     * Retorna el mensaje
     *
     * @param -
     * @return Mensaje
     */
    @Override
    public String getMessage() {
        return mensaje;
    }
    
    
    
    @Override
    public Integer doctorTieneCita(Integer iddoctor) {
        Integer rspta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("d.iddoctor")
                .append(" FROM doctor d INNER JOIN cita c")
                .append(" ON d.iddoctor=c.iddoctor")
                .append(" WHERE d.iddoctor= ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, iddoctor);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    rspta = rs.getInt(1);
                } else {
                    rspta = null;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return rspta;
    }
    
    
    @Override
    public Integer doctorNro_docDuplicado(String Nro_doc) {
        Integer rspta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("iddoctor")
                .append(" FROM doctor ")
                .append(" WHERE nro_doc_doctor= ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, Nro_doc);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    rspta = rs.getInt(1);
                } else {
                    rspta = null;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return rspta;
    }
    
    @Override
    public Integer doctorCorreoDuplicado(String correo) {
        Integer rspta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("iddoctor")
                .append(" FROM doctor ")
                .append(" WHERE correo_doctor= ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, correo);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    rspta = rs.getInt(1);
                } else {
                    rspta = null;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return rspta;
    }
    
    
    

}

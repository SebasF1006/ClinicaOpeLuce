package dao.impl;

import dao.DaoPaciente;
import entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoPacienteImpl implements DaoPaciente {

    private final ConexionBD conectaDb;
    private String mensaje;

    public DaoPacienteImpl() {
        this.conectaDb = new ConexionBD();
    }

    /**
     * Selecciona todos los pacientes de la base de datos
     *
     * @param -
     * @return Lista de pacientes
     */
    @Override
    public List<Paciente> pacienteSel() {
        List<Paciente> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idpacientes,")
                .append("tipo_doc_paciente,")
                .append("nro_doc_paciente,")
                .append("nombres_paciente,")
                .append("apellidos_paciente,")
                .append("telefono_paciente,")
                .append("direccion_paciente,")
                .append("correo_paciente,")
                .append("password_paciente,")
                .append("fecha_nacimiento_paciente,")
                .append("edad_paciente")
                .append(" FROM paciente");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdpacientes(rs.getInt(1));
                paciente.setTipo_doc_paciente(rs.getString(2));
                paciente.setNro_doc_paciente(rs.getString(3));
                paciente.setNombres_paciente(rs.getString(4));
                paciente.setApellidos_paciente(rs.getString(5));
                paciente.setTelefono_paciente(rs.getString(6));
                paciente.setDireccion_paciente(rs.getString(7));
                paciente.setCorreo_paciente(rs.getString(8));
                paciente.setPassword_paciente(rs.getString(9));
                paciente.setFecha_nacimiento_paciente(LocalDate.parse(rs.getString(10)));
                paciente.setEdad_paciente(rs.getInt(11));
                list.add(paciente);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    @Override
    public List<Paciente> pacienteSel2(String nro_doc) {
        List<Paciente> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idpacientes,")
                .append("tipo_doc_paciente,")
                .append("nro_doc_paciente,")
                .append("nombres_paciente,")
                .append("apellidos_paciente,")
                .append("telefono_paciente,")
                .append("direccion_paciente,")
                .append("correo_paciente,")
                .append("password_paciente,")
                .append("fecha_nacimiento_paciente,")
                .append("edad_paciente")
                .append(" FROM paciente")
                .append(" WHERE nro_doc_paciente = ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, nro_doc);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdpacientes(rs.getInt(1));
                paciente.setTipo_doc_paciente(rs.getString(2));
                paciente.setNro_doc_paciente(rs.getString(3));
                paciente.setNombres_paciente(rs.getString(4));
                paciente.setApellidos_paciente(rs.getString(5));
                paciente.setTelefono_paciente(rs.getString(6));
                paciente.setDireccion_paciente(rs.getString(7));
                paciente.setCorreo_paciente(rs.getString(8));
                paciente.setPassword_paciente(rs.getString(9));
                paciente.setFecha_nacimiento_paciente(LocalDate.parse(rs.getString(10)));
                paciente.setEdad_paciente(rs.getInt(11));
                list.add(paciente);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * Buscar los datos de un paciente en especifico usando el id del paciente
     * en la base de datos
     *
     * @param id Int id identificador de pacientes
     * @return Variable de tipo Paciente
     */
    @Override
    public Paciente pacienteGet(Integer id) {
        Paciente paciente = new Paciente();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idpacientes,")
                .append("tipo_doc_paciente,")
                .append("nro_doc_paciente,")
                .append("nombres_paciente,")
                .append("apellidos_paciente,")
                .append("telefono_paciente,")
                .append("direccion_paciente,")
                .append("correo_paciente,")
                .append("password_paciente,")
                .append("fecha_nacimiento_paciente,")
                .append("edad_paciente")
                .append(" FROM paciente WHERE idpacientes = ?");// Selecciona todos los datos que coincidan con el id solicitado
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery()) { //Llama a todos los elementos seleccionados y los transforma en Strings
                if (rs.next()) {
                    paciente.setIdpacientes(rs.getInt(1));
                    paciente.setTipo_doc_paciente(rs.getString(2));
                    paciente.setNro_doc_paciente(rs.getString(3));
                    paciente.setNombres_paciente(rs.getString(4));
                    paciente.setApellidos_paciente(rs.getString(5));
                    paciente.setTelefono_paciente(rs.getString(6));
                    paciente.setDireccion_paciente(rs.getString(7));
                    paciente.setCorreo_paciente(rs.getString(8));
                    paciente.setPassword_paciente(rs.getString(9));
                    paciente.setFecha_nacimiento_paciente(LocalDate.parse(rs.getString(10)));
                    paciente.setEdad_paciente(rs.getInt(11));
                } else {
                    paciente = null; // En caso no encuentre el id solicitado se considerará que el paciente no existe
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return paciente;
    }

    /**
     * Insetar pacientes a la base de datos
     *
     * @param paciente Paciente paciente
     * @return El mensaje correspondiente y datos insertados a la base de datos
     */
    @Override
    public String pacienteIns(Paciente paciente) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO paciente( ")
                .append("tipo_doc_paciente,")
                .append("nro_doc_paciente,")
                .append("nombres_paciente,")
                .append("apellidos_paciente,")
                .append("telefono_paciente,")
                .append("direccion_paciente,")
                .append("correo_paciente,")
                .append("password_paciente,")
                .append("fecha_nacimiento_paciente,")
                .append("edad_paciente")
                .append(") VALUES (?,?,?,?,?,?,?,?,?,?) ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());//Ingresa la informacion recibida a la base de datos 
            ps.setString(1, paciente.getTipo_doc_paciente());
            ps.setString(2, paciente.getNro_doc_paciente());
            ps.setString(3, paciente.getNombres_paciente());
            ps.setString(4, paciente.getApellidos_paciente());
            ps.setString(5, paciente.getTelefono_paciente());
            ps.setString(6, paciente.getDireccion_paciente());
            ps.setString(7, paciente.getCorreo_paciente());
            ps.setString(8, paciente.getPassword_paciente());
            ps.setString(9, paciente.getFecha_nacimiento_paciente().toString());
            ps.setInt(10, paciente.getEdad_paciente());
            int ctos = ps.executeUpdate();//Contador de la cantidad de datos ingresados
            if (ctos == 0) {
                mensaje = "cero filas insertadas";//Si no se ingresan datos nos mandara el mensaje de "cero filas insertadas"
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;//retorna el mensaje 
    }

    /**
     * Actualizar la informacion de pacientes en la base de datos
     *
     * @param paciente Paciente paciente
     * @return El mensaje correspondiente y datos modificados del paciente en
     * especifico
     */
    @Override
    public String pacienteUpd(Paciente paciente) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE paciente SET ")
                .append("tipo_doc_paciente = ?,")
                .append("nro_doc_paciente = ?,")
                .append("nombres_paciente = ?,")
                .append("apellidos_paciente = ?,")
                .append("telefono_paciente = ?,")
                .append("direccion_paciente = ?,")
                .append("correo_paciente = ?,")
                .append("password_paciente = ?,")
                .append("fecha_nacimiento_paciente = ?,")
                .append("edad_paciente = ? ")
                .append("WHERE idpacientes = ? ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());//Modifica la informacion recibida en la base de datos
            ps.setString(1, paciente.getTipo_doc_paciente());
            ps.setString(2, paciente.getNro_doc_paciente());
            ps.setString(3, paciente.getNombres_paciente());
            ps.setString(4, paciente.getApellidos_paciente());
            ps.setString(5, paciente.getTelefono_paciente());
            ps.setString(6, paciente.getDireccion_paciente());
            ps.setString(7, paciente.getCorreo_paciente());
            ps.setString(8, paciente.getPassword_paciente());
            ps.setString(9, paciente.getFecha_nacimiento_paciente().toString());
            ps.setInt(10, paciente.getEdad_paciente());
            ps.setInt(11, paciente.getIdpacientes());
            int ctos = ps.executeUpdate();//Contador de la cantidad de datos actualizados
            if (ctos == 0) {
                mensaje = "No se pudo actualizar";//Si no se modifican datos nos mandara el mensaje de "no se pudo actualizar"
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return mensaje;//retorna el mensaje 
    }

    /**
     * Borrar pacientes de la base de datos siendo buscados por el id del
     * paciente
     *
     * @param ids List Integer ids Lista de Identificador de paciente
     * @return El mensaje correspondiente y elimina los pacientes de la base de
     * datos
     */
    @Override
    public String pacienteDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM paciente WHERE ")
                .append("idpacientes = ? "); //
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
     * @param correo String correo Correo del paciente
     * @param pass String pass Contrseña del paciente
     * @return Varible de tipo Boolean
     */
    @Override
    public Boolean pacienteLogin(String correo, String pass) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("correo_paciente,")
                .append("password_paciente")
                .append(" FROM paciente");
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

    @Override
    public Paciente RecuperarPassword(String correo) {
        Paciente paciente = new Paciente();
        StringBuilder sql = new StringBuilder();
        String pass = null;
        sql.append("SELECT ")
                .append("idpacientes,")
                .append("tipo_doc_paciente,")
                .append("nro_doc_paciente,")
                .append("nombres_paciente,")
                .append("apellidos_paciente,")
                .append("telefono_paciente,")
                .append("direccion_paciente,")
                .append("correo_paciente,")
                .append("password_paciente,")
                .append("fecha_nacimiento_paciente,")
                .append("edad_paciente")
                .append(" FROM paciente")
                .append(" where correo_paciente = ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, correo);
            try ( ResultSet rs = ps.executeQuery()) { //Llama a todos los elementos seleccionados y los transforma en Strings
                if (rs.next()) {
                    paciente.setIdpacientes(rs.getInt(1));
                    paciente.setTipo_doc_paciente(rs.getString(2));
                    paciente.setNro_doc_paciente(rs.getString(3));
                    paciente.setNombres_paciente(rs.getString(4));
                    paciente.setApellidos_paciente(rs.getString(5));
                    paciente.setTelefono_paciente(rs.getString(6));
                    paciente.setDireccion_paciente(rs.getString(7));
                    paciente.setCorreo_paciente(rs.getString(8));
                    paciente.setPassword_paciente(rs.getString(9));
                    paciente.setFecha_nacimiento_paciente(LocalDate.parse(rs.getString(10)));
                    paciente.setEdad_paciente(rs.getInt(11));
                } else {
                    paciente = null; // En caso no encuentre el id solicitado se considerará que el paciente no existe
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return paciente;
    }

    /**
     * Retorna un objeto Paciente
     *
     * @param correo String correo Correo del paciente
     * @param pass String pass Contrseña del paciente
     * @return Variable de tipo paciente
     */
    @Override
    public Paciente pacienteGetLogin(String correo, String pass) {
        Paciente paciente = new Paciente();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idpacientes,")
                .append("tipo_doc_paciente,")
                .append("nro_doc_paciente,")
                .append("nombres_paciente,")
                .append("apellidos_paciente,")
                .append("telefono_paciente,")
                .append("direccion_paciente,")
                .append("correo_paciente,")
                .append("password_paciente,")
                .append("fecha_nacimiento_paciente,")
                .append("edad_paciente")
                .append(" FROM paciente WHERE correo_paciente = ?")
                .append(" AND password_paciente = ?");// Selecciona todos los datos que coincidan con el id solicitado
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, correo);
            ps.setString(2, pass);
            try ( ResultSet rs = ps.executeQuery()) { //Llama a todos los elementos seleccionados y los transforma en Strings
                if (rs.next()) {
                    paciente.setIdpacientes(rs.getInt(1));
                    paciente.setTipo_doc_paciente(rs.getString(2));
                    paciente.setNro_doc_paciente(rs.getString(3));
                    paciente.setNombres_paciente(rs.getString(4));
                    paciente.setApellidos_paciente(rs.getString(5));
                    paciente.setTelefono_paciente(rs.getString(6));
                    paciente.setDireccion_paciente(rs.getString(7));
                    paciente.setCorreo_paciente(rs.getString(8));
                    paciente.setPassword_paciente(rs.getString(9));
                    paciente.setFecha_nacimiento_paciente(LocalDate.parse(rs.getString(10)));
                    paciente.setEdad_paciente(rs.getInt(11));
                } else {
                    paciente = null; // En caso no encuentre el id solicitado se considerará que el paciente no existe
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return paciente;
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
    public Integer pacienteTieneCita(Integer idpacientes) {
        Integer rspta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("p.idpacientes")
                .append(" FROM paciente p INNER JOIN cita c")
                .append(" ON p.idpacientes=c.idpacientes")
                .append(" WHERE p.idpacientes= ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, idpacientes);
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
    public Integer pacienteNro_docDuplicado(String Nro_doc) {
        Integer rspta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idpacientes")
                .append(" FROM paciente ")
                .append(" WHERE nro_doc_paciente= ?");
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
    public Integer pacienteCorreoDuplicado(String correo) {
        Integer rspta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idpacientes")
                .append(" FROM paciente ")
                .append(" WHERE correo_paciente= ?");
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

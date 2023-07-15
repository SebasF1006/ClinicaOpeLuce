package dao.impl;

import dao.DaoAdministrador;
import entidades.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import util.ConexionBD;

public class DaoAdministradorImpl implements DaoAdministrador {

    private final ConexionBD conectaDb;
    private String mensaje;

    public DaoAdministradorImpl() {
        this.conectaDb = new ConexionBD();
    }

    /**
     * Selecciona todos los administradores de la base de datos
     *
     * @param -
     * @return Lista de Administradores
     */
    @Override
    public List<Administrador> administradorSel() {
        List<Administrador> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idadministrador,")
                .append("tipo_doc_administrador,")
                .append("nro_doc_administrador,")
                .append("nombres_administrador,")
                .append("apellidos_administrador,")
                .append("telefono_administrador,")
                .append("direccion_administrador,")
                .append("correo_administrador,")
                .append("password_administrador,")
                .append("fecha_nacimiento_administrador,")
                .append("edad_administrador")
                .append(" FROM administrador");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Administrador administrador = new Administrador();
                administrador.setIdadministrador(rs.getInt(1));
                administrador.setTipo_doc_administrador(rs.getString(2));
                administrador.setNro_doc_administrador(rs.getString(3));
                administrador.setNombres_administrador(rs.getString(4));
                administrador.setApellidos_administrador(rs.getString(5));
                administrador.setTelefono_administrador(rs.getString(6));
                administrador.setDireccion_administrador(rs.getString(7));
                administrador.setCorreo_administrador(rs.getString(8));
                administrador.setPassword_administrador(rs.getString(9));
                administrador.setFecha_nacimiento_administrador(LocalDate.parse(rs.getString(10)));
                administrador.setEdad_administrador(rs.getInt(11));
                list.add(administrador);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }
    
    @Override
    public List<Administrador> administradorSel2(String nro_doc) {
        List<Administrador> list = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idadministrador,")
                .append("tipo_doc_administrador,")
                .append("nro_doc_administrador,")
                .append("nombres_administrador,")
                .append("apellidos_administrador,")
                .append("telefono_administrador,")
                .append("direccion_administrador,")
                .append("correo_administrador,")
                .append("password_administrador,")
                .append("fecha_nacimiento_administrador,")
                .append("edad_administrador")
                .append(" FROM administrador")
                .append(" where nro_doc_administrador = ? ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, nro_doc);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Administrador administrador = new Administrador();
                administrador.setIdadministrador(rs.getInt(1));
                administrador.setTipo_doc_administrador(rs.getString(2));
                administrador.setNro_doc_administrador(rs.getString(3));
                administrador.setNombres_administrador(rs.getString(4));
                administrador.setApellidos_administrador(rs.getString(5));
                administrador.setTelefono_administrador(rs.getString(6));
                administrador.setDireccion_administrador(rs.getString(7));
                administrador.setCorreo_administrador(rs.getString(8));
                administrador.setPassword_administrador(rs.getString(9));
                administrador.setFecha_nacimiento_administrador(LocalDate.parse(rs.getString(10)));
                administrador.setEdad_administrador(rs.getInt(11));
                list.add(administrador);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
        }
        return list;
    }

    /**
     * Buscar los datos de un administrador en especifico usando el id del
     * administrador en la base de datos
     *
     * @param id Int id identificador de administrador
     * @return Variable de tipo Administrador
     */
    @Override
    public Administrador administradorGet(Integer id) {
        Administrador administrador = new Administrador();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idadministrador,")
                .append("tipo_doc_administrador,")
                .append("nro_doc_administrador,")
                .append("nombres_administrador,")
                .append("apellidos_administrador,")
                .append("telefono_administrador,")
                .append("direccion_administrador,")
                .append("correo_administrador,")
                .append("password_administrador,")
                .append("fecha_nacimiento_administrador,")
                .append("edad_administrador")
                .append(" FROM administrador WHERE idadministrador = ?");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setInt(1, id);
            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    administrador.setIdadministrador(rs.getInt(1));
                    administrador.setTipo_doc_administrador(rs.getString(2));
                    administrador.setNro_doc_administrador(rs.getString(3));
                    administrador.setNombres_administrador(rs.getString(4));
                    administrador.setApellidos_administrador(rs.getString(5));
                    administrador.setTelefono_administrador(rs.getString(6));
                    administrador.setDireccion_administrador(rs.getString(7));
                    administrador.setCorreo_administrador(rs.getString(8));
                    administrador.setPassword_administrador(rs.getString(9));
                    administrador.setFecha_nacimiento_administrador(LocalDate.parse(rs.getString(10)));
                    administrador.setEdad_administrador(rs.getInt(11));
                } else {
                    administrador = null;
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return administrador;
    }

    /**
     * Insetar administradores a la base de datos
     *
     * @param administrador Administrador administrador
     * @return El mensaje correspondiente y datos insertados a la base de datos
     */
    @Override
    public String administradorIns(Administrador administrador) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO administrador( ")
                .append("tipo_doc_administrador,")
                .append("nro_doc_administrador,")
                .append("nombres_administrador,")
                .append("apellidos_administrador,")
                .append("telefono_administrador,")
                .append("direccion_administrador,")
                .append("correo_administrador,")
                .append("password_administrador,")
                .append("fecha_nacimiento_administrador,")
                .append("edad_administrador")
                .append(") VALUES (?,?,?,?,?,?,?,?,?,?) ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, administrador.getTipo_doc_administrador());
            ps.setString(2, administrador.getNro_doc_administrador());
            ps.setString(3, administrador.getNombres_administrador());
            ps.setString(4, administrador.getApellidos_administrador());
            ps.setString(5, administrador.getTelefono_administrador());
            ps.setString(6, administrador.getDireccion_administrador());
            ps.setString(7, administrador.getCorreo_administrador());
            ps.setString(8, administrador.getPassword_administrador());
            ps.setString(9, administrador.getFecha_nacimiento_administrador().toString());
            ps.setInt(10, administrador.getEdad_administrador());
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
     * Actualizar la informacion de administradores en la base de datos
     *
     * @param administrador
     * @return El mensaje correspondiente y datos modificados del administrador
     * en especifico
     */
    @Override
    public String administradorUpd(Administrador administrador) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE administrador SET ")
                .append("tipo_doc_administrador = ?,")
                .append("nro_doc_administrador = ?,")
                .append("nombres_administrador = ?,")
                .append("apellidos_administrador = ?,")
                .append("telefono_administrador = ?,")
                .append("direccion_administrador = ?,")
                .append("correo_administrador = ?,")
                .append("password_administrador = ?,")
                .append("fecha_nacimiento_administrador = ?,")
                .append("edad_administrador = ? ")
                .append("WHERE idadministrador = ?  ");
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, administrador.getTipo_doc_administrador());
            ps.setString(2, administrador.getNro_doc_administrador());
            ps.setString(3, administrador.getNombres_administrador());
            ps.setString(4, administrador.getApellidos_administrador());
            ps.setString(5, administrador.getTelefono_administrador());
            ps.setString(6, administrador.getDireccion_administrador());
            ps.setString(7, administrador.getCorreo_administrador());
            ps.setString(8, administrador.getPassword_administrador());
            ps.setString(9, administrador.getFecha_nacimiento_administrador().toString());
            ps.setInt(10, administrador.getEdad_administrador());
            ps.setInt(11, administrador.getIdadministrador());
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
     * Borrar administradores de la base de datos siendo buscados por el id del
     * administrador
     *
     * @param ids List Integer ids Lista de Identificador de administrador
     * @return El mensaje correspondiente y elimina los administradores de la
     * base de datos
     */
    @Override
    public String administradorDel(List<Integer> ids) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM administrador WHERE ")
                .append("idadministrador = ? ");
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
     * @param correo String correo Correo del administrador
     * @param pass String pass Contrseña del administrador
     * @return Varible de tipo Boolean
     */
    @Override
    public Boolean administradorLogin(String correo, String pass) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("correo_administrador,")
                .append("password_administrador")
                .append(" FROM administrador");
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
    public Integer administradorNro_docDuplicado(String Nro_doc) {
        Integer rspta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idadministrador")
                .append(" FROM administrador ")
                .append(" WHERE nro_doc_administrador= ?");
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
    public Integer administradorCorreoDuplicado(String correo) {
        Integer rspta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idadministrador")
                .append(" FROM administrador ")
                .append(" WHERE correo_administrador= ?");
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
    
    
    @Override
    public Administrador administradorGetLogin(String correo, String pass) {
        Administrador admin = new Administrador();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("idadministrador,")
                .append("tipo_doc_administrador,")
                .append("nro_doc_administrador,")
                .append("nombres_administrador,")
                .append("apellidos_administrador,")
                .append("telefono_administrador,")
                .append("direccion_administrador,")
                .append("correo_administrador,")
                .append("password_administrador,")
                .append("fecha_nacimiento_administrador,")
                .append("edad_administrador")
                .append(" FROM administrador WHERE correo_administrador = ?")
                .append(" AND password_administrador = ?");// Selecciona todos los datos que coincidan con el id solicitado
        try ( Connection cn = conectaDb.conexionDB()) {
            PreparedStatement ps = cn.prepareStatement(sql.toString());
            ps.setString(1, correo);
            ps.setString(2, pass);
            try ( ResultSet rs = ps.executeQuery()) { //Llama a todos los elementos seleccionados y los transforma en Strings
                if (rs.next()) {
                    admin.setIdadministrador(rs.getInt(1));
                    admin.setTipo_doc_administrador(rs.getString(2));
                    admin.setNro_doc_administrador(rs.getString(3));
                    admin.setNombres_administrador(rs.getString(4));
                    admin.setApellidos_administrador(rs.getString(5));
                    admin.setTelefono_administrador(rs.getString(6));
                    admin.setDireccion_administrador(rs.getString(7));
                    admin.setCorreo_administrador(rs.getString(8));
                    admin.setPassword_administrador(rs.getString(9));
                    admin.setFecha_nacimiento_administrador(LocalDate.parse(rs.getString(10)));
                    admin.setEdad_administrador(rs.getInt(11));
                } else {
                    admin = null; // En caso no encuentre el id solicitado se considerará que el paciente no existe
                }
            } catch (SQLException e) {
                mensaje = e.getMessage();
            }
        } catch (SQLException e) {
            mensaje = e.getMessage();
        }
        return admin;
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

}

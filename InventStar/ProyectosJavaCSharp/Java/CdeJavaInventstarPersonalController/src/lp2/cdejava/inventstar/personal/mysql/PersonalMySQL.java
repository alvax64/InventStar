/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.personal.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.personal.dao.PersonalDAO;
import lp2.cdejava.inventstar.personal.model.Cargo;
import lp2.cdejava.inventstar.personal.model.Personal;
import lp2.cdejava.inventstar.personal.model.Sucursal;

/**
 *
 * @author Usuario
 */
public class PersonalMySQL implements PersonalDAO {
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    @Override
    public int insertar(Personal personal) {
        int rpta = 0;
        try{
            
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL INSERTAR_PERSONAL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_idPersonal", java.sql.Types.INTEGER);
            cs.setString("_nombresPersona", personal.getNombres());
            cs.setString("_apellidoPatPersona", personal.getApellidoPat());
            cs.setString("_apellidoMatPersona", personal.getApellidoMat());
            cs.setString("_numDocumentoPersona", personal.getNumDocumento());
            cs.setString("_telefono1Persona", personal.getTelefono1());
            cs.setString("_telefono2Persona", personal.getTelefono2());
            cs.setString("_emailPersona", personal.getEmail());
            cs.setString("_domicilioPersona", personal.getDomicilio());
            cs.setDate("_fechaRegistroPersona", new java.sql.Date(personal.getFechaRegistro().getTime()));
            cs.setDate("_fechaNacimientoPersona", new java.sql.Date(personal.getFechaCumpleanhos().getTime()));
            cs.setString("_estadoPersonal", personal.getEstado());
            cs.setInt("_fidCargo", personal.getCargo().getIdCargo());
            cs.setInt("_fidSucursal", personal.getSucursal().getId_sucursal());
            int i = cs.executeUpdate();
            rpta = cs.getInt("_idPersonal");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    @Override
    public int modificar(Personal personal) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL MODIFICAR_PERSONAL(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_idPersonal", personal.getIdPersona());
            cs.setString("_nombresPersona", personal.getNombres());
            cs.setString("_apellidoPatPersona", personal.getApellidoPat());
            cs.setString("_apellidoMatPersona", personal.getApellidoMat());
            cs.setString("_numDocumentoPersona", personal.getNumDocumento());
            cs.setString("_telefono1Persona", personal.getTelefono1());
            cs.setString("_telefono2Persona", personal.getTelefono2());
            cs.setString("_emailPersona", personal.getEmail());
            cs.setString("_domicilioPersona", personal.getDomicilio());
            cs.setDate("_fechaRegistroPersona", new java.sql.Date(personal.getFechaRegistro().getTime()));
            cs.setDate("_fechaNacimientoPersona", new java.sql.Date(personal.getFechaCumpleanhos().getTime()));
            cs.setString("_estadoPersonal", personal.getEstado());
            cs.setInt("_fidCargo", personal.getCargo().getIdCargo());
            cs.setInt("_fidSucursal", personal.getSucursal().getId_sucursal());
            int i = cs.executeUpdate();
            rpta = i;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    @Override
    public int eliminar(int idPersonal) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL ELIMINAR_PERSONAL(?)}");
            cs.setInt("_idPersonal", idPersonal);
            int i = cs.executeUpdate();
            rpta = i;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    @Override
    public ArrayList<Personal> listarPersonal() {
        ArrayList<Personal> personal = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL LISTAR_PERSONAL()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Personal p = new Personal();
                p.setIdPersona(rs.getInt("idPersona"));
                p.setNombres(rs.getString("nombresPersona"));
                p.setApellidoPat(rs.getString("apellidoPatPersona"));
                p.setApellidoMat(rs.getString("apellidoMatPersona"));
                p.setNumDocumento(rs.getString("numDocumentoPersona"));
                p.setTelefono1(rs.getString("telefono1Persona"));
                p.setTelefono2(rs.getString("telefono2Persona"));
                p.setEmail(rs.getString("emailPersona"));
                p.setDomicilio(rs.getString("domicilioPersona"));
                p.setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                p.setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                p.setEstado(rs.getString("estadoPersonal"));
                p.setCargo(new Cargo());
                p.getCargo().setIdCargo(rs.getInt("id_cargo"));
                p.getCargo().setNombre(rs.getString("nombreCargo"));
                p.getCargo().setDescripcion(rs.getString("descripcionCargo"));
                p.getCargo().setSalario(rs.getDouble("salarioCargo"));
                p.getCargo().setModificaInventario(rs.getBoolean("modificaInventarioCargo"));
                p.setSucursal(new Sucursal());
                p.getSucursal().setId_sucursal(rs.getInt("id_sucursal"));
                p.getSucursal().setNombre(rs.getString("nombreSucursal"));
                p.getSucursal().setDireccion(rs.getString("direccionSucursal"));
                p.getSucursal().setAforo(rs.getInt("aforoSucursal"));
                p.getSucursal().setTelefono(rs.getString("telefonoSucursal"));
                p.getSucursal().setEmail(rs.getString("emailSucursal"));
                personal.add(p);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return personal;
    }

    @Override
    public Personal obtenerPorId(int idPersonal) {
        Personal personal = new Personal();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call OBTENER_PERSONAL_X_ID(?)}");
            cs.setInt("_id_personal", idPersonal);
            rs = cs.executeQuery();
            if(rs.next()){
                personal.setIdPersona(rs.getInt("idPersona"));
                personal.setNombres(rs.getString("nombresPersona"));
                personal.setApellidoPat(rs.getString("apellidoPatPersona"));
                personal.setApellidoMat(rs.getString("apellidoMatPersona"));
                personal.setNumDocumento(rs.getString("numDocumentoPersona"));
                personal.setTelefono1(rs.getString("telefono1Persona"));
                personal.setTelefono2(rs.getString("telefono2Persona"));
                personal.setEmail(rs.getString("emailPersona"));
                personal.setDomicilio(rs.getString("domicilioPersona"));
                personal.setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                personal.setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                personal.setEstado(rs.getString("estadoPersonal"));
                personal.setCargo(new Cargo());
                personal.getCargo().setIdCargo(rs.getInt("id_cargo"));
                personal.getCargo().setNombre(rs.getString("nombreCargo"));
                personal.getCargo().setDescripcion(rs.getString(("descripcionCargo")));
                personal.getCargo().setSalario(rs.getDouble("salarioCargo"));
                personal.getCargo().setModificaInventario(rs.getBoolean("modificaInventarioCargo"));            
                personal.setSucursal(new Sucursal());
                personal.getSucursal().setId_sucursal(rs.getInt("id_sucursal"));
                personal.getSucursal().setNombre(rs.getString("nombreSucursal"));
                personal.getSucursal().setDireccion(rs.getString("direccionSucursal"));
                personal.getSucursal().setAforo(rs.getInt("aforoSucursal"));
                personal.getSucursal().setTelefono(rs.getString("telefonoSucursal"));
                personal.getSucursal().setEmail(rs.getString("emailSucursal"));
                personal.setActivo(true);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return personal;
    }

    @Override
    public ArrayList<Personal> listarPersonalesPorNombre_Apellido_DNI(String nombre_Apellido_DNI) {
        ArrayList<Personal> personal = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL LISTAR_PERSONAL_POR_NOMBRE_APELLIDO_DNI(?)}");
            cs.setString("_nombre_apellido_DNI", nombre_Apellido_DNI);
            rs = cs.executeQuery();
            while(rs.next()){
                Personal p = new Personal();
                p.setIdPersona(rs.getInt("idPersona"));
                p.setNombres(rs.getString("nombresPersona"));
                p.setApellidoPat(rs.getString("apellidoPatPersona"));
                p.setApellidoMat(rs.getString("apellidoMatPersona"));
                p.setNumDocumento(rs.getString("numDocumentoPersona"));
                p.setTelefono1(rs.getString("telefono1Persona"));
                p.setTelefono2(rs.getString("telefono2Persona"));
                p.setEmail(rs.getString("emailPersona"));
                p.setDomicilio(rs.getString("domicilioPersona"));
                p.setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                p.setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                p.setEstado(rs.getString("estadoPersonal"));
                p.setCargo(new Cargo());
                p.getCargo().setIdCargo(rs.getInt("id_cargo"));
                p.getCargo().setNombre(rs.getString("nombreCargo"));
                p.getCargo().setDescripcion(rs.getString("descripcionCargo"));
                p.getCargo().setSalario(rs.getDouble("salarioCargo"));
                p.getCargo().setModificaInventario(rs.getBoolean("modificaInventarioCargo"));
                p.setSucursal(new Sucursal());
                p.getSucursal().setId_sucursal(rs.getInt("id_sucursal"));
                p.getSucursal().setNombre(rs.getString("nombreSucursal"));
                p.getSucursal().setDireccion(rs.getString("direccionSucursal"));
                p.getSucursal().setAforo(rs.getInt("aforoSucursal"));
                p.getSucursal().setTelefono(rs.getString("telefonoSucursal"));
                p.getSucursal().setEmail(rs.getString("emailSucursal"));
                personal.add(p);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return personal; 
    }

    @Override
    public int modificarPermisosCargo(int idPersonal, int fidCargo) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL MODIFICAR_PERMISOS_CARGO(?,?)}");
            cs.setInt("_idPersonal", idPersonal);
            cs.setInt("_fidCargo", fidCargo);
            int i = cs.executeUpdate();
            rpta = i;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
}

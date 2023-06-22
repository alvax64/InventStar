/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.personal.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.personal.dao.CuentaPersonalDAO;
import lp2.cdejava.inventstar.personal.model.CuentaPersonal;
import lp2.cdejava.inventstar.personal.model.Personal;

/**
 *
 * @author Lenovo
 */
public class CuentaPersonalMySQL implements CuentaPersonalDAO {
    private Connection con;
    private CallableStatement cst;
    private ResultSet rs;
    public int insertar(CuentaPersonal cuenta) {
        int filas = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL INSERTAR_CUENTA_PERSONAL(?,?,?,?)}");
            cst.registerOutParameter("_id_cuenta_personal", java.sql.Types.INTEGER);
            cst.setString("_usernameCuentaPersonal", cuenta.getUsername());
            cst.setString("_passwordCuentaPersonal", cuenta.getPassword());
            cst.setInt("_fidPersonal", cuenta.getPersonal().getIdPersona());
            filas = cst.executeUpdate();
            cuenta.setIdCuentaPersonal(cst.getInt("_id_cuenta_personal"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return filas;
    }
 
    public int modificar(CuentaPersonal cuenta) {
        int filas = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL MODIFICAR_CUENTA_PERSONAL(?,?,?,?)}");
            cst.setInt("_id_cuenta_personal", cuenta.getIdCuentaPersonal());
            cst.setString("_usernameCuentaPersonal", cuenta.getUsername());
            cst.setString("_passwordCuentaPersonal", cuenta.getPassword());
            cst.setInt("_fidPersonal", cuenta.getPersonal().getIdPersona());
            filas = cst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return filas;
    }
 
    public int eliminar(CuentaPersonal cuenta) {
        int filas = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL ELIMINAR_CUENTA_PERSONAL(?)}");
            cst.setInt("_id_cuenta_personal", cuenta.getIdCuentaPersonal());
            filas = cst.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return filas;
    }
    public ArrayList<CuentaPersonal> listarCuentas() {
        ArrayList<CuentaPersonal> cuentas = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL LISTAR_CUENTA_PERSONAL()}");
            rs = cst.executeQuery();
            while(rs.next()){
                CuentaPersonal cuenta = new CuentaPersonal();
                cuenta.setIdCuentaPersonal(rs.getInt("id_cuenta_personal"));
                cuenta.setUsername(rs.getString("usernameCuentaPersonal"));
                cuenta.setPassword(rs.getString("passwordCuentaPersonal"));
                cuenta.setPersonal(new Personal());
                cuenta.getPersonal().setIdPersona(rs.getInt("idPersona"));
                cuenta.getPersonal().setNombres(rs.getString("nombresPersona"));
                cuenta.getPersonal().setApellidoPat(rs.getString("apellidoPatPersona"));
                cuenta.getPersonal().setApellidoMat(rs.getString("apellidoMatPersona"));
                cuenta.getPersonal().setNumDocumento(rs.getString("numDocumentoPersona"));
                cuenta.getPersonal().setTelefono1(rs.getString("telefono1Persona"));
                cuenta.getPersonal().setTelefono2(rs.getString("telefono2Persona"));
                cuenta.getPersonal().setEmail(rs.getString("emailPersona"));
                cuenta.getPersonal().setDomicilio(rs.getString("domicilioPersona"));
                cuenta.getPersonal().setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                cuenta.getPersonal().setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                cuenta.getPersonal().setEstado(rs.getString("estadoPersonal"));
                cuentas.add(cuenta);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cuentas;
    }

    @Override
    public int verificar(CuentaPersonal cuentaPersonal) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{call VERIFICAR_CUENTA_PERSONAL"
                    + "(?,?)}");
            cst.setString("_username", cuentaPersonal.getUsername());
            cst.setString("_password", cuentaPersonal.getPassword());
            rs = cst.executeQuery();
            if(rs.next()){
                resultado = rs.getInt("fidPersonal");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int verificarPermisos(CuentaPersonal cuentaPersonal) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{call VERIFICAR_CUENTA_PERSONAL_CON_PERMISOS"
                    + "(?,?)}");
            cst.setString("_username", cuentaPersonal.getUsername());
            cst.setString("_password", cuentaPersonal.getPassword());
            rs = cst.executeQuery();
            if(rs.next()){
                resultado = rs.getInt("fidPersonal");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado; 
    }
}

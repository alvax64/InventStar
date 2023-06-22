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
import lp2.cdejava.inventstar.personal.dao.SucursalDAO;
import lp2.cdejava.inventstar.personal.model.Matriz;
import lp2.cdejava.inventstar.personal.model.Sucursal;

/**
 *
 * @author Usuario
 */
public class SucursalMySQL implements SucursalDAO{
    Connection con = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    public int insertar(Sucursal sucursal) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_SUCURSAL(?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_sucursal", java.sql.Types.INTEGER);
            cs.setString("_nombreSucursal", sucursal.getNombre());
            cs.setString("_direccionSucursal", sucursal.getDireccion());
            cs.setInt("_aforoSucursal", sucursal.getAforo());
            cs.setString("_telefonoSucursal", sucursal.getTelefono());
            cs.setString("_emailSucursal", sucursal.getEmail());
            cs.setInt("_fid_matriz", sucursal.getMatriz().getId_matriz());
            rpta = cs.executeUpdate();
            sucursal.setId_sucursal(cs.getInt("_id_sucursal"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    public int modificar(Sucursal sucursal) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_SUCURSAL(?,?,?,?,?,?,?)}");
            cs.setInt("_id_sucursal", sucursal.getId_sucursal());
            cs.setString("_nombreSucursal", sucursal.getNombre());
            cs.setString("_direccionSucursal", sucursal.getDireccion());
            cs.setInt("_aforoSucursal", sucursal.getAforo());
            cs.setString("_telefonoSucursal", sucursal.getTelefono());
            cs.setString("_emailSucursal", sucursal.getEmail());
            cs.setInt("_fid_matriz", sucursal.getMatriz().getId_matriz());
            rpta = cs.executeUpdate();
            sucursal.setId_sucursal(cs.getInt("_id_sucursal"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    public int eliminar(Sucursal sucursal) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_SUCURSAL(?)}");
            cs.setInt("_id_sucursal", sucursal.getId_sucursal());
            rpta = cs.executeUpdate();
            sucursal.setId_sucursal(cs.getInt("_id_sucursal"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    public ArrayList<Sucursal> listarSucursal() {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_SUCURSAL_TODOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Sucursal sucursal = new Sucursal();
                sucursal.setId_sucursal(rs.getInt("id_sucursal"));
                sucursal.setNombre(rs.getString("nombreSucursal"));
                sucursal.setDireccion(rs.getString("direccionSucursal"));
                sucursal.setAforo(rs.getInt("aforoSucursal"));
                sucursal.setTelefono(rs.getString("telefonoSucursal"));
                sucursal.setEmail(rs.getString("emailSucursal"));
                sucursal.setMatriz(new Matriz());
                sucursal.getMatriz().setId_matriz(rs.getInt("id_matriz"));
                sucursal.getMatriz().setNombreMatriz(rs.getString("nombreMatriz"));
                sucursal.getMatriz().setRazonsocialMatriz(rs.getString("razonsocialMatriz"));
                sucursal.getMatriz().setDireccionMatriz(rs.getString("direccionMatriz"));
                sucursal.getMatriz().setTelefonoMatriz(rs.getString("telefonoMatriz"));
                sucursal.getMatriz().setEmailMatriz(rs.getString("emailMatriz"));
                sucursal.setActivo(true);
                sucursales.add(sucursal);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return sucursales;
    }

    @Override
    public ArrayList<Sucursal> listarSucursalPorNombre(String nombre) {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_SUCURSAL_POR_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Sucursal sucursal = new Sucursal();
                sucursal.setId_sucursal(rs.getInt("id_sucursal"));
                sucursal.setNombre(rs.getString("nombreSucursal"));
                sucursal.setDireccion(rs.getString("direccionSucursal"));
                sucursal.setAforo(rs.getInt("aforoSucursal"));
                sucursal.setTelefono(rs.getString("telefonoSucursal"));
                sucursal.setEmail(rs.getString("emailSucursal"));
                sucursal.setMatriz(new Matriz());
                sucursal.getMatriz().setId_matriz(rs.getInt("id_matriz"));
                sucursal.getMatriz().setNombreMatriz(rs.getString("nombreMatriz"));
                sucursal.getMatriz().setRazonsocialMatriz(rs.getString("razonsocialMatriz"));
                sucursal.getMatriz().setDireccionMatriz(rs.getString("direccionMatriz"));
                sucursal.getMatriz().setTelefonoMatriz(rs.getString("telefonoMatriz"));
                sucursal.getMatriz().setEmailMatriz(rs.getString("emailMatriz"));
                sucursal.setActivo(true);
                sucursales.add(sucursal);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return sucursales;
    }
}            

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.dao.ContactoDAO;
import lp2.cdejava.inventstar.inventario.model.Contacto;
import lp2.cdejava.inventstar.config.DBManager;

/**
 *
 * @author Arian
 */
public class ContactoMySQL implements ContactoDAO {
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Contacto contacto) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_CONTACTO(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_idContacto", java.sql.Types.INTEGER);
            cs.setString("_nombresPersona", contacto.getNombres());
            cs.setString("_apellidoPatPersona", contacto.getApellidoPat());
            cs.setString("_apellidoMatPersona", contacto.getApellidoMat());
            cs.setString("_numDocumentoPersona", contacto.getNumDocumento());
            cs.setString("_telefono1Persona", contacto.getTelefono1());
            cs.setString("_telefono2Persona", contacto.getTelefono2());
            cs.setString("_emailPersona", contacto.getEmail());
            cs.setString("_domicilioPersona", contacto.getDomicilio());
            cs.setDate("_fechaRegistroPersona", new java.sql.Date(contacto.getFechaRegistro().getTime()));
            cs.setDate("_fechaNacimientoPersona", new java.sql.Date(contacto.getFechaCumpleanhos().getTime()));
            cs.setString("_puestoContacto", contacto.getPuesto());
            cs.setInt("_fid_proveedor", contacto.getProveedor().getIdProveedor());
            
            cs.executeUpdate();
            contacto.setIdPersona(cs.getInt("_idContacto"));
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Contacto contacto) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CONTACTO(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_idContacto", contacto.getIdPersona());
            cs.setString("_nombresPersona", contacto.getNombres());
            cs.setString("_apellidoPatPersona", contacto.getApellidoPat());
            cs.setString("_apellidoMatPersona", contacto.getApellidoMat());
            cs.setString("_numDocumentoPersona", contacto.getNumDocumento());
            cs.setString("_telefono1Persona", contacto.getTelefono1());
            cs.setString("_telefono2Persona", contacto.getTelefono2());
            cs.setString("_emailPersona", contacto.getEmail());
            cs.setString("_domicilioPersona", contacto.getDomicilio());
            cs.setDate("_fechaRegistroPersona", new java.sql.Date(contacto.getFechaRegistro().getTime()));
            cs.setDate("_fechaNacimientoPersona", new java.sql.Date(contacto.getFechaCumpleanhos().getTime()));
            cs.setString("_puestoContacto", contacto.getPuesto());
            cs.setInt("_fid_proveedor", contacto.getProveedor().getIdProveedor());
            
            cs.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idContacto) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_CONTACTO(?)}");
            cs.setInt("_idComida", idContacto);
            cs.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Contacto> listarTodosContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CONTACTO()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Contacto contacto = new Contacto();
                contacto.setIdPersona(rs.getInt("idPersona"));
                contacto.setNombres(rs.getString("nombresPersona"));
                contacto.setApellidoPat(rs.getString("apellidoPatPersona"));
                contacto.setApellidoMat(rs.getString("apellidoMatPersona"));
                contacto.setNumDocumento(rs.getString("numDocumentoPersona"));
                contacto.setTelefono1(rs.getString("telefono1Persona"));
                contacto.setTelefono2(rs.getString("telefono2Persona"));
                contacto.setEmail(rs.getString("emailPersona"));
                contacto.setDomicilio(rs.getString("domicilioPersona"));
                contacto.setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                contacto.setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                contacto.setPuesto(rs.getString("puestoContacto"));
                contacto.getProveedor().setIdProveedor(rs.getInt("fid_proveedor"));
                        
                contactos.add(contacto);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return contactos;
    }
    
}

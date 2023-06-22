/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.inventario.dao.InsumoPerecibleDAO;
import lp2.cdejava.inventstar.inventario.model.Comida;
import lp2.cdejava.inventstar.inventario.model.Ingrediente;
import lp2.cdejava.inventstar.inventario.model.InsumoPerecible;

/**
 *
 * @author Lenovo
 */
public class InsumoPerecibleMySQL implements InsumoPerecibleDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
     public int insertar(InsumoPerecible insumoPerecible) {
        int respuesta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL INSERTAR_INSUMOPERECIBLE(?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_insumoPerecible", java.sql.Types.INTEGER);
            cs.setString("_nombre", insumoPerecible.getNombre());
            cs.setDouble("_cantidad", insumoPerecible.getCantidad());
            cs.setInt("_fid_compra", insumoPerecible.getOrdenCompra().getIdCompra());
            cs.setDate("_fechaProduccion", new java.sql.Date(insumoPerecible.getFechaIngeso().getTime()));
            cs.setDate("_fechaVencimiento", new java.sql.Date(insumoPerecible.getFechaVencimiento().getTime()));
            cs.setInt("_fid_comida", insumoPerecible.getComida().getIdItemVenta());
            cs.setInt("_fid_ingrediente", insumoPerecible.getIngrediente().getIdIngrediente());
            respuesta = cs.executeUpdate();
            insumoPerecible.setIdLote(cs.getInt("_id_insumoPerecible"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return respuesta;
    }

    public int modificar(InsumoPerecible insumoPerecible) {
        int respuesta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL MODIFICAR_INSUMOPERECIBLE(?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_insumoPerecible", insumoPerecible.getIdLote());
            cs.setString("_nombre", insumoPerecible.getNombre());
            cs.setDouble("_cantidad", insumoPerecible.getCantidad());
            cs.setInt("_fid_compra", insumoPerecible.getOrdenCompra().getIdCompra());
            cs.setDate("_fechaProduccion", new java.sql.Date(insumoPerecible.getFechaIngeso().getTime()));
            cs.setDate("_fechaVencimiento", new java.sql.Date(insumoPerecible.getFechaVencimiento().getTime()));
            cs.setInt("_fid_comida", insumoPerecible.getComida().getIdItemVenta());
            cs.setInt("_fid_ingrediente", insumoPerecible.getIngrediente().getIdIngrediente());
            respuesta = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return respuesta;
    }

    public int eliminar(InsumoPerecible insumoPerecible) {
        int respuesta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL ELIMINAR_INSUMOPERECIBLE(?)}");
            cs.setInt("_id_insumoPerecible", insumoPerecible.getIdLote());
            respuesta = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return respuesta;
    }

    public ArrayList<InsumoPerecible> listar() {
        ArrayList<InsumoPerecible> insumosPerecibles = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL LISTAR_INSUMOPERECIBLE()}");
            rs = cs.executeQuery();
            while(rs.next()){
                InsumoPerecible insumoPerecible = new InsumoPerecible();
                insumoPerecible.setIdLote(rs.getInt("id_lote"));
                insumoPerecible.setNombre(rs.getString("nombreLote"));
                insumoPerecible.setCantidad(rs.getDouble("cantidadLote"));
                insumoPerecible.setFechaIngeso(rs.getDate("fechaProduccionInsumoPerecible"));
                insumoPerecible.setFechaVencimiento(rs.getDate("fechaVencimientoInsumoPerecible"));
                insumoPerecible.setComida(new Comida());
                insumoPerecible.getComida().setIdItemVenta(rs.getInt("fid_comida"));
                insumoPerecible.setIngrediente(new Ingrediente());
                insumoPerecible.getIngrediente().setIdIngrediente(rs.getInt("fid_ingrediente"));
                insumosPerecibles.add(insumoPerecible);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return insumosPerecibles;
    }
    
}

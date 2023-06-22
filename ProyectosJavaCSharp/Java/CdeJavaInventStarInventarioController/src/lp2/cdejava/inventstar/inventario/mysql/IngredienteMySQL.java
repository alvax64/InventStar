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
import lp2.cdejava.inventstar.inventario.dao.IngredienteDAO;
import lp2.cdejava.inventstar.inventario.model.Bebida;
import lp2.cdejava.inventstar.inventario.model.Ingrediente;

/**
 *
 * @author Lenovo
 */
public class IngredienteMySQL implements IngredienteDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public int insertarIngrediente(Ingrediente ingrediente) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL INSERTAR_INGREDIENTE(?,?,?,?,?)}");
            cs.registerOutParameter("_idIngrediente", java.sql.Types.INTEGER);
            cs.setString("_nombreIngrediente", ingrediente.getNombre());
            cs.setDouble("_cantidadIngrediente", ingrediente.getCantidad());
            cs.setString("_unidadMedidaIngrediente", ingrediente.getUnidadMedida());
            cs.setInt("_fid_bebida", ingrediente.getBebida().getIdItemVenta());
            cs.executeUpdate();
            ingrediente.setIdIngrediente(cs.getInt("_idIngrediente"));
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;         
    }

    @Override
    public int modificarIngrediente(Ingrediente ingrediente) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL MODIFICAR_INGREDIENTE(?,?,?,?,?)}");
            cs.setInt("_idIngrediente", ingrediente.getIdIngrediente());
            cs.setString("_nombreIngrediente", ingrediente.getNombre());
            cs.setDouble("_cantidadIngrediente", ingrediente.getCantidad());
            cs.setString("_unidadMedidaIngrediente", ingrediente.getUnidadMedida());
            cs.setInt("_fid_bebida", ingrediente.getBebida().getIdItemVenta());
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
    public int eliminarIngrediente(int idIngrediente) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL ELIMINAR_INGREDIENTE(?)}");
            cs.setInt("_idIngrediente", idIngrediente);
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
    public ArrayList<Ingrediente> listarIngrediente() {
        ArrayList<Ingrediente> lista = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL LISTAR_INGREDIENTE()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(rs.getInt("id_ingrediente"));
                ingrediente.setNombre(rs.getString("nombreIngrediente"));
                ingrediente.setCantidad(rs.getDouble("cantidadIngrediente"));
                ingrediente.setUnidadMedida(rs.getString("unidadMedidaIngrediente"));
                ingrediente.setBebida(new Bebida());
                ingrediente.getBebida().setIdItemVenta(rs.getInt("fid_bebida"));
                lista.add(ingrediente);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return lista;
    }
    
}

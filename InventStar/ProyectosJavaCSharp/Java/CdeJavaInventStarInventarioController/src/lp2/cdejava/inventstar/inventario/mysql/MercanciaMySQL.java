/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.dao.MercanciaDAO;
import lp2.cdejava.inventstar.inventario.model.Mercancia;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.inventario.model.CategoriaMercancia;
import lp2.cdejava.inventstar.inventario.model.Lote;

/**
 *
 * @author Arian
 */
public class MercanciaMySQL implements MercanciaDAO {
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Mercancia mercancia) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_MERCANCIA(?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_idMercancia", java.sql.Types.INTEGER);
            cs.setString("_nombreItemventa", mercancia.getNombre());
            cs.setString("_descripcionItemventa", mercancia.getDescripcion());
            cs.setDouble("_precioUnitarioItemventa", mercancia.getPrecioUnitario());
            cs.setString("_categoriaMercancia", String.valueOf(mercancia.getCategoria()));
            cs.setString("_codigoBarrasMercancia", mercancia.getCodigoBarras());
            cs.setInt("_fid_lote", mercancia.getLote().getIdLote());
            
            cs.executeUpdate();
            mercancia.setIdItemVenta(cs.getInt("_idMercancia"));
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Mercancia mercancia) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_MERCANCIA(?,?,?,?,?,?,?)}");
            cs.setInt("_idMercancia", mercancia.getIdItemVenta());
            cs.setString("_nombreItemventa", mercancia.getNombre());
            cs.setString("_descripcionItemventa", mercancia.getDescripcion());
            cs.setDouble("_precioUnitarioItemventa", mercancia.getPrecioUnitario());
            cs.setString("_categoriaMercancia", String.valueOf(mercancia.getCategoria()));
            cs.setString("_codigoBarrasMercancia", mercancia.getCodigoBarras());
            cs.setInt("_fid_lote", mercancia.getLote().getIdLote());
            
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
    public int eliminar(int idMercancia) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_MERCANCIA(?)}");
            cs.setInt("_idComida", idMercancia);
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
    public ArrayList<Mercancia> listarTodasMercancias() {
        ArrayList<Mercancia> mercancias = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_MERCANCIA()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Mercancia mercancia = new Mercancia();
                mercancia.setIdItemVenta(rs.getInt("idItemVenta"));
                mercancia.setNombre(rs.getString("nombreItemventa"));
                mercancia.setDescripcion(rs.getString("descripcionItemventa"));
                mercancia.setPrecioUnitario(rs.getDouble("precioUnitarioItemventa"));
                mercancia.setCategoria(CategoriaMercancia.valueOf(rs.getString("categoriaMercancia")));
                mercancia.setCodigoBarras(rs.getString("codigoBarrasMercancia"));
                mercancia.setLote(new Lote());
                mercancia.getLote().setIdLote(rs.getInt("fid_lote"));
                        
                mercancias.add(mercancia);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return mercancias;
    }
    
}

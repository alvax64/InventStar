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
import lp2.cdejava.inventstar.inventario.dao.MermaDAO;
import lp2.cdejava.inventstar.inventario.model.Lote;
import lp2.cdejava.inventstar.inventario.model.Merma;

/**
 *
 * @author Lenovo
 */
public class MermaMySQL implements MermaDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;

    
    public int insertarMerma(Merma merma) {
        int rpta = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL INSERTAR_MERMA(?,?,?,?,?)}");
            cs.registerOutParameter("_idMerma", java.sql.Types.INTEGER);
            cs.setDate("_fechaRegistroMerma", new java.sql.Date(merma.getFechaRegistro().getTime()));
            cs.setDouble("_cantidadMerma", merma.getCantidad());
            cs.setString("_motivoMerma", merma.getMotivo());
            cs.setInt("_fid_lote", merma.getLote().getIdLote());
            rpta = cs.executeUpdate();
            merma.setIdMerma(cs.getInt("_idMerma"));
        } catch (Exception e) {
            System.out.println("Error al insertar merma: " + e.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }

    public int modificarMerma(Merma merma) {
        int rpta = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL MODIFICAR_MERMA(?,?,?,?,?)}");
            cs.setInt("_idMerma", merma.getIdMerma());
            cs.setDate("_fechaRegistroMerma", new java.sql.Date(merma.getFechaRegistro().getTime()));
            cs.setDouble("_cantidadMerma", merma.getCantidad());
            cs.setString("_motivoMerma", merma.getMotivo());
            cs.setInt("_fid_lote", merma.getLote().getIdLote());
            rpta = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al modificar merma: " + e.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }

    public int eliminarMerma(int idMerma) {
        int rpta = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL ELIMINAR_MERMA(?)}");
            cs.setInt("_idMerma", idMerma);
            rpta = cs.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al eliminar merma: " + e.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }

    public ArrayList<Merma> listarMerma() {
        ArrayList<Merma> mermaList = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL LISTAR_MERMA()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Merma merma = new Merma();
                merma.setIdMerma(rs.getInt("id_merma"));
                merma.setFechaRegistro(rs.getDate("fechaRegistroMerma"));
                merma.setCantidad(rs.getDouble("cantidadMerma"));
                merma.setMotivo(rs.getString("motivoMerma"));
                Lote lote = new Lote();
                lote.setIdLote(rs.getInt("fid_lote"));
                merma.setLote(lote);
                mermaList.add(merma);
            }
        } catch (Exception e) {
            System.out.println("Error al listar merma: " + e.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return mermaList;
    }
    
}

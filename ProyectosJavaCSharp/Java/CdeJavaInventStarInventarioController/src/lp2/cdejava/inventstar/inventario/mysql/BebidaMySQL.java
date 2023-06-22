/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.dao.BebidaDAO;
import lp2.cdejava.inventstar.inventario.model.Bebida;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.inventario.model.TamanhoBebida;
import lp2.cdejava.inventstar.inventario.model.TipoDeBebida;

/**
 *
 * @author Arian
 */
public class BebidaMySQL implements BebidaDAO {
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Bebida bebida) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_BEBIDA(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_idBebida", java.sql.Types.INTEGER);
            cs.setString("_nombreItemventa", bebida.getNombre());
            cs.setString("_descripcionItemventa", bebida.getDescripcion());
            cs.setDouble("_precioUnitarioItemventa", bebida.getPrecioUnitario());
            cs.setDouble("_cantidadAlimento", bebida.getCantidad());
            cs.setString("_unidadMedidaAlimento", bebida.getUnidadMedida());
            cs.setInt("_caloriasAlimento", bebida.getCalorias());
            cs.setString("_tipoDeBebida", String.valueOf(bebida.getTipo()));
            cs.setBoolean("_esFriaBebida", bebida.isEsFria());
            cs.setString("_tamanhoBebida", String.valueOf(bebida.getTamanho()));
            cs.setString("_instruccionesPreparacionBebida", bebida.getInstrucciones());
            cs.setInt("_tiempoPreparacionBebida", bebida.getTiempoPreparacion());
            
            cs.executeUpdate();
            bebida.setIdItemVenta(cs.getInt("_idBebida"));
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Bebida bebida) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_BEBIDA(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_idBebida", bebida.getIdItemVenta());
            cs.setString("_nombreItemventa", bebida.getNombre());
            cs.setString("_descripcionItemventa", bebida.getDescripcion());
            cs.setDouble("_precioUnitarioItemventa", bebida.getPrecioUnitario());
            cs.setDouble("_cantidadAlimento", bebida.getCantidad());
            cs.setString("_unidadMedidaAlimento", bebida.getUnidadMedida());
            cs.setInt("_caloriasAlimento", bebida.getCalorias());
            cs.setString("_tipoDeBebida", String.valueOf(bebida.getTipo()));
            cs.setBoolean("_esFriaBebida", bebida.isEsFria());
            cs.setString("_tamanhoBebida", String.valueOf(bebida.getTamanho()));
            cs.setString("_instruccionesPreparacionBebida", bebida.getInstrucciones());
            cs.setInt("_tiempoPreparacionBebida", bebida.getTiempoPreparacion());
            
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
    public int eliminar(int idBebida) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_BEBIDA(?)}");
            cs.setInt("_idBebida", idBebida);
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
    public ArrayList<Bebida> listarTodasBebidas() {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_BEBIDA()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Bebida bebida = new Bebida();
                bebida.setIdItemVenta(rs.getInt("idItemVenta"));
                bebida.setNombre(rs.getString("nombreItemventa"));
                bebida.setDescripcion(rs.getString("descripcionItemventa"));
                bebida.setPrecioUnitario(rs.getDouble("precioUnitarioItemventa"));
                bebida.setCantidad(rs.getDouble("cantidadAlimento"));
                bebida.setUnidadMedida(rs.getString("unidadMedidaAlimento"));
                bebida.setCalorias(rs.getInt("caloriasAlimento"));
                bebida.setTipo(TipoDeBebida.valueOf(rs.getString("tipoDeBebida")));
                bebida.setEsFria(rs.getBoolean("esFriaBebida"));
                bebida.setTamanho(TamanhoBebida.valueOf(rs.getString("tamanhoBebida")));
                bebida.setInstrucciones(rs.getString("instruccionesPreparacionBebida"));
                bebida.setTiempoPreparacion(rs.getInt("tiempoPreparacionBebida"));
                bebidas.add(bebida);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return bebidas;
    }
    
}

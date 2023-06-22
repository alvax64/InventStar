/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.dao.ComidaDAO;
import lp2.cdejava.inventstar.inventario.model.Comida;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.inventario.model.TipoDeComida;

/**
 *
 * @author Arian
 */
public class ComidaMySQL implements ComidaDAO {
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Comida comida) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_COMIDA(?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_idComida", java.sql.Types.INTEGER);
            cs.setString("_nombreItemventa", comida.getNombre());
            cs.setString("_descripcionItemventa", comida.getDescripcion());
            cs.setDouble("_precioUnitarioItemventa", comida.getPrecioUnitario());
            cs.setDouble("_cantidadAlimento", comida.getCantidad());
            cs.setString("_unidadMedidaAlimento", comida.getUnidadMedida());
            cs.setInt("_caloriasAlimento", comida.getCalorias());
            cs.setString("_tipoDeComida", String.valueOf(comida.getTipo()));
            cs.setInt("_segundosACalentarComida", comida.getSegundosACalentar());
            
            cs.executeUpdate();
            comida.setIdItemVenta(cs.getInt("_idComida"));
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Comida comida) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_COMIDA(?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_idComida", comida.getIdItemVenta());
            cs.setString("_nombreItemventa", comida.getNombre());
            cs.setString("_descripcionItemventa", comida.getDescripcion());
            cs.setDouble("_precioUnitarioItemventa", comida.getPrecioUnitario());
            cs.setDouble("_cantidadAlimento", comida.getCantidad());
            cs.setString("_unidadMedidaAlimento", comida.getUnidadMedida());
            cs.setInt("_caloriasAlimento", comida.getCalorias());
            cs.setString("_tipoDeComida", String.valueOf(comida.getTipo()));
            cs.setInt("_segundosACalentarComida", comida.getSegundosACalentar());
            
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
    public int eliminar(int idComida) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_COMIDA(?)}");
            cs.setInt("_idComida", idComida);
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
    public ArrayList<Comida> listarTodasComidas() {
        ArrayList<Comida> comidas = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_COMIDA()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Comida comida = new Comida();
                comida.setIdItemVenta(rs.getInt("idItemVenta"));
                comida.setNombre(rs.getString("nombreItemventa"));
                comida.setDescripcion(rs.getString("descripcionItemventa"));
                comida.setPrecioUnitario(rs.getDouble("precioUnitarioItemventa"));
                comida.setCantidad(rs.getDouble("cantidadAlimento"));
                comida.setUnidadMedida(rs.getString("unidadMedidaAlimento"));
                comida.setCalorias(rs.getInt("caloriasAlimento"));
                comida.setTipo(TipoDeComida.valueOf(rs.getString("tipoDeComida")));
                comida.setSegundosACalentar(rs.getInt("segundosACalentarComida"));
                comida.setActivo(true);
                comidas.add(comida);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return comidas;
    }
    
}

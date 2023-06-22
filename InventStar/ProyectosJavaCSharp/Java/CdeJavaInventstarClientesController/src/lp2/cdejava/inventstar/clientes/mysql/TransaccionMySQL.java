/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.clientes.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.dao.TransaccionDAO;
import lp2.cdejava.inventstar.clientes.model.TipoDePago;
import lp2.cdejava.inventstar.clientes.model.Transaccion;
import lp2.cdejava.inventstar.config.DBManager;


/**
 *
 * @author Usuario
 */
public class TransaccionMySQL implements TransaccionDAO {
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(Transaccion transaccion) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_TRANSACCION(?,?,?,?,?)}");
            cs.registerOutParameter("_idTransaccion",java.sql.Types.INTEGER);
            cs.setDate("_fechaTransaccion", new java.sql.Date(transaccion.getFecha().getTime()));
            cs.setTime("_horaTransaccion", java.sql.Time.valueOf(transaccion.getHora()));
            cs.setString("_monedaTransaccion",transaccion.getMoneda());
            cs.setString("_tipoDePagoTransaccion",String.valueOf(transaccion.getTipo()));
            
            cs.executeUpdate();
            transaccion.setIdTransaccion(cs.getInt("_idTransaccion"));
            resultado = transaccion.getIdTransaccion();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Transaccion transaccion) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_TRANSACCION(?,?,?,?,?)}");
            cs.setInt("_idTransaccion", transaccion.getIdTransaccion());
            cs.setDate("_fechaTransaccion", new java.sql.Date(transaccion.getFecha().getTime()));
            cs.setTime("_horaTransaccion", java.sql.Time.valueOf(transaccion.getHora()));
            cs.setString("_monedaTransaccion",transaccion.getMoneda());
            cs.setString("_tipoDePagoTransaccion",String.valueOf(transaccion.getTipo()));
            
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idTransaccion) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_TRANSACCION(?)}");
            cs.setInt("_idTransaccion", idTransaccion);
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Transaccion> listarTodasTransacciones() {
        ArrayList<Transaccion> transacciones = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TRANSACCION()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                Transaccion tran= new Transaccion();
                tran.setIdTransaccion(rs.getInt("idTransaccion"));
                tran.setFecha(rs.getDate("fechaTransaccion"));
                tran.setHora(rs.getTime("horaTransaccion").toLocalTime());
                tran.setMoneda(rs.getString("monedaTransaccion"));
                tran.setTipo(TipoDePago.valueOf(rs.getString("tipoDePagoTransaccion")));
                tran.setActivo(true);
                transacciones.add(tran);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return transacciones;
    }
    
}

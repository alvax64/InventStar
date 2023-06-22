/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.clientes.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.dao.PromocionPersonalizadaDAO;
import lp2.cdejava.inventstar.clientes.model.Cliente;
import lp2.cdejava.inventstar.clientes.model.PromocionPersonalizada;
import lp2.cdejava.inventstar.clientes.model.TarjetaInventstar;
import lp2.cdejava.inventstar.clientes.model.TipoDePromocion;
import lp2.cdejava.inventstar.config.DBManager;

/**
 *
 * @author Usuario
 */
public class PromocionPersonalizadaMySQL implements PromocionPersonalizadaDAO {
    private Connection con;
    private CallableStatement cst;
    private ResultSet rs;
    
    public int insertar(PromocionPersonalizada promocion) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL INSERTAR_PROMOCIONPERSONALIZADA(?,?,?,?,?,?,?,?,?)}");
            cst.registerOutParameter("idPromocionPersonalizada", java.sql.Types.INTEGER);
            cst.setString("_nombreItemventa", promocion.getNombre());
            cst.setString("_descripcionItemventa", promocion.getDescripcion());
            cst.setDouble("_precioUnitarioItemventa", promocion.getPrecioUnitario());
            cst.setDate("_fechaInicioPromocion", new java.sql.Date(promocion.getFechaInicio().getTime()));
            cst.setDate("_fechaFinPromocion", new java.sql.Date(promocion.getFechaFin().getTime()));
            cst.setString("_tipoPromocion", String.valueOf(promocion.getTipoPromocion()));
            cst.setString("_mensajePromocionPersonalizada", promocion.getMensaje());
            cst.setInt("_fidTarjeta", promocion.getTarjeta().getIdTarjeta());
            cst.executeUpdate();
            promocion.setIdItemVenta(cst.getInt("idPromocionPersonalizada"));
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    public int modificar(PromocionPersonalizada promocion) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL MODIFICAR_PROMOCIONPERSONALIZADA(?,?,?)}");
            cst.setInt("_idPromocionPersonalizada", promocion.getIdItemVenta());
            cst.setString("_mensajePromocionPersonalizada", promocion.getMensaje());
            cst.setInt("_fidTarjeta", promocion.getTarjeta().getIdTarjeta());
            cst.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    public int eliminar(int idpromocion) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL ELIMINAR_PROMOCIONPERSONALIZADA(?)}");
            cst.setInt("_idPromocionPersonalizada", idpromocion);
            cst.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
    public ArrayList<PromocionPersonalizada> listarTodasPromocionPersonalizadaPorTarjeta(int id_tarjeta) {
        ArrayList<PromocionPersonalizada> promociones = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL LISTAR_PROMOCIONPERSONALIZADA_POR_TARJETA(?)}");
            cst.setInt("_id_tarjeta", id_tarjeta);
            rs = cst.executeQuery();
            while(rs.next()){
                PromocionPersonalizada promocion = new PromocionPersonalizada();
                promocion.setIdItemVenta(rs.getInt("idPromocionPersonalizada"));
                promocion.setMensaje(rs.getString("mensajePromocionPersonalizada"));
                promocion.setFechaInicio(rs.getDate("fechaInicioPromocion"));
                promocion.setFechaFin(rs.getDate("fechaFinPromocion"));
                promocion.setTipoPromocion(TipoDePromocion.valueOf(rs.getString("tipoPromocion")));
                promocion.setNombre(rs.getString("nombreItemventa"));
                promocion.setDescripcion(rs.getString("descripcionItemventa"));
                promocion.setPrecioUnitario(rs.getDouble("precioUnitarioItemventa"));
                promocion.setTarjeta(new TarjetaInventstar());
                promocion.getTarjeta().setIdTarjeta(rs.getInt("idTarjeta"));
                promocion.getTarjeta().setPuntosAcumulados(rs.getInt("puntosTarjetastar"));
                promocion.getTarjeta().setFechaRegistro(rs.getDate("fechaRegistroTarjetastar"));
                promocion.getTarjeta().setCliente(new Cliente());
                promocion.getTarjeta().getCliente().setIdPersona(rs.getInt("idPersona"));
                promocion.getTarjeta().getCliente().setNombres(rs.getString("nombresPersona"));
                promocion.getTarjeta().getCliente().setApellidoPat(rs.getString("apellidoPatPersona"));
                promocion.getTarjeta().getCliente().setApellidoMat(rs.getString("apellidoMatPersona"));
                promocion.getTarjeta().getCliente().setNumDocumento(rs.getString("numDocumentoPersona"));
                promocion.getTarjeta().getCliente().setTelefono1(rs.getString("telefono1Persona"));
                promocion.getTarjeta().getCliente().setTelefono2(rs.getString("telefono2Persona"));
                promocion.getTarjeta().getCliente().setEmail(rs.getString("emailPersona"));
                promocion.getTarjeta().getCliente().setDomicilio(rs.getString("domicilioPersona"));
                promocion.getTarjeta().getCliente().setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                promocion.getTarjeta().getCliente().setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                promocion.getTarjeta().getCliente().setAceptaPublicidad(rs.getBoolean("aceptaPublicidadCliente"));
                promociones.add(promocion);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return promociones;
    }
   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.personal.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.model.Cliente;
import lp2.cdejava.inventstar.clientes.model.Reseña;
import lp2.cdejava.inventstar.clientes.model.TipoDePago;
import lp2.cdejava.inventstar.clientes.model.Transaccion;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.personal.dao.OrdenVentaDAO;
import lp2.cdejava.inventstar.personal.model.OrdenVenta;
import lp2.cdejava.inventstar.personal.model.Personal;
import lp2.cdejava.inventstar.personal.model.Sucursal;
import lp2.cdejava.inventstar.personal.model.TipoDeVenta;

/**
 *
 * @author Usuario
 */
public class OrdenVentaMySQL implements OrdenVentaDAO {
    private Connection con;
    private CallableStatement cst;
    private ResultSet rs;
    public int insertar(OrdenVenta ordenVenta) {
        int respuesta = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL INSERTAR_ORDENVENTA(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cst.registerOutParameter("_idOrdenVenta", java.sql.Types.INTEGER);
            cst.setDate("_fechaOrdenventa", new java.sql.Date(ordenVenta.getFecha().getTime()));
            cst.setTime("_horaVentaOrdenventa", java.sql.Time.valueOf(ordenVenta.getHoraVenta()));
            cst.setTime("_horaFinPedidoOrdenventa", java.sql.Time.valueOf(ordenVenta.getHoraFinPedido()));
            cst.setString("_tipoOrdenventa", ordenVenta.getTipo().toString());
            cst.setString("_estadoOrdenventa", ordenVenta.getEstado());
            cst.setDouble("_totalOrdenventa", ordenVenta.getTotal());
            cst.setInt("_fidPersonal", ordenVenta.getPersonal().getIdPersona());
            cst.setInt("_fidCliente", ordenVenta.getCliente().getIdPersona());
            cst.setInt("_fid_sucursal", ordenVenta.getSucursal().getId_sucursal());
            cst.setInt("_fid_transaccion", ordenVenta.getTransaccion().getIdTransaccion());
            cst.setInt("_fid_resenha", ordenVenta.getResenha().getIdReseña());
            
            respuesta = cst.executeUpdate();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return respuesta;
    }
    public int modificar(OrdenVenta ordenVenta) {
        int respuesta = 0;
        try {
            con = DBManager.getInstance().getConnection();
        cst = con.prepareCall("{CALL MODIFICAR_ORDENVENTA(?,?,?,?,?,?,?,?,?,?,?)}");
        cst.setInt("_idOrdenVenta", ordenVenta.getIdVenta());
        cst.setDate("_fechaOrdenventa", new java.sql.Date(ordenVenta.getFecha().getTime()));
        cst.setTime("_horaVentaOrdenventa", java.sql.Time.valueOf(ordenVenta.getHoraVenta()));
        cst.setTime("_horaFinPedidoOrdenventa", java.sql.Time.valueOf(ordenVenta.getHoraFinPedido()));
        cst.setString("_tipoOrdenventa", ordenVenta.getTipo().toString());
        cst.setString("_estadoOrdenventa", ordenVenta.getEstado());
        cst.setDouble("_totalOrdenventa", ordenVenta.getTotal());
        cst.setInt("_fidPersonal", ordenVenta.getPersonal().getIdPersona());
        cst.setInt("_fidCliente", ordenVenta.getCliente().getIdPersona());
        cst.setInt("_fid_sucursal", ordenVenta.getSucursal().getId_sucursal());
        cst.setInt("_fid_transaccion", ordenVenta.getTransaccion().getIdTransaccion());
        cst.setInt("_fid_resenha", ordenVenta.getResenha().getIdReseña());

        respuesta = cst.executeUpdate();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        } finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return respuesta;
    }
    public int eliminar(OrdenVenta ordenVenta) {
        int respuesta = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL ELIMINAR_ORDENVENTA(?)}");
            cst.setInt("_idOrdenVenta", ordenVenta.getIdVenta());
            respuesta = cst.executeUpdate();
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        } finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return respuesta;
    }
    public ArrayList<OrdenVenta> listarOrdenVenta() {
        ArrayList<OrdenVenta> ordenesVenta = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL LISTAR_ORDENVENTA()}");
            rs = cst.executeQuery();
            while(rs.next()) {
                OrdenVenta ordenVenta = new OrdenVenta();
                ordenVenta.setIdVenta(rs.getInt("idOrdenVenta"));
                ordenVenta.setFecha(rs.getDate("fechaOrdenventa"));
                ordenVenta.setHoraVenta(rs.getTime("horaVentaOrdenventa").toLocalTime());
                ordenVenta.setHoraFinPedido(rs.getTime("horaFinPedidoOrdenventa").toLocalTime());
                ordenVenta.setTipo(TipoDeVenta.valueOf(rs.getString("tipoOrdenventa")));
                ordenVenta.setEstado(rs.getString("estadoOrdenventa"));
                ordenVenta.setTotal(rs.getDouble("totalOrdenventa"));
                ordenVenta.setPersonal(new Personal());
                ordenVenta.getPersonal().setIdPersona(rs.getInt("idPersonaPersonal"));
                ordenVenta.getPersonal().setNombres(rs.getString("nombresPersonaPersonal"));
                ordenVenta.getPersonal().setApellidoPat(rs.getString("apellidoPatPersonaPersonal"));
                ordenVenta.getPersonal().setApellidoMat(rs.getString("apellidoMatPersonaPersonal"));
                ordenVenta.getPersonal().setNumDocumento(rs.getString("numDocumentoPersonaPersonal"));
                ordenVenta.getPersonal().setTelefono1(rs.getString("telefono1PersonaPersonal"));
                ordenVenta.getPersonal().setTelefono2(rs.getString("telefono2PersonaPersonal"));
                ordenVenta.getPersonal().setEmail(rs.getString("emailPersonaPersonal"));
                ordenVenta.getPersonal().setDomicilio(rs.getString("domicilioPersonaPersonal"));
                ordenVenta.getPersonal().setFechaRegistro(rs.getDate("fechaRegistroPersonaPersonal"));
                ordenVenta.getPersonal().setFechaCumpleanhos(rs.getDate("fechaNacimientoPersonaPersonal"));
                ordenVenta.getPersonal().setEstado(rs.getString("estadoPersonal"));
                ordenVenta.setCliente(new Cliente());
                ordenVenta.getCliente().setIdPersona(rs.getInt("idPersona"));
                ordenVenta.getCliente().setAceptaPublicidad(rs.getBoolean("aceptaPublicidadCliente"));
                ordenVenta.getCliente().setNombres(rs.getString("nombresPersona"));
                ordenVenta.getCliente().setApellidoPat(rs.getString("apellidoPatPersona"));
                ordenVenta.getCliente().setApellidoMat(rs.getString("apellidoMatPersona"));
                ordenVenta.getCliente().setNumDocumento(rs.getString("numDocumentoPersona"));
                ordenVenta.getCliente().setTelefono1(rs.getString("telefono1Persona"));
                ordenVenta.getCliente().setTelefono2(rs.getString("telefono2Persona"));
                ordenVenta.getCliente().setEmail(rs.getString("emailPersona"));
                ordenVenta.getCliente().setDomicilio(rs.getString("domicilioPersona"));
                ordenVenta.getCliente().setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                ordenVenta.getCliente().setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                
                ordenVenta.setSucursal(new Sucursal());
                ordenVenta.getSucursal().setId_sucursal(rs.getInt("id_sucursal"));
                ordenVenta.getSucursal().setNombre(rs.getString("nombreSucursal"));
                ordenVenta.getSucursal().setDireccion(rs.getString("direccionSucursal"));
                ordenVenta.getSucursal().setAforo(rs.getInt("aforoSucursal"));
                ordenVenta.getSucursal().setTelefono(rs.getString("telefonoSucursal"));
                ordenVenta.getSucursal().setEmail(rs.getString("emailSucursal"));
                ordenVenta.setTransaccion(new Transaccion());
                ordenVenta.getTransaccion().setIdTransaccion(rs.getInt("idTransaccion"));
                ordenVenta.getTransaccion().setFecha(rs.getDate("fechaTransaccion"));
                ordenVenta.getTransaccion().setHora(rs.getTime("horaTransaccion").toLocalTime());
                ordenVenta.getTransaccion().setMoneda(rs.getString("monedaTransaccion"));
                ordenVenta.getTransaccion().setTipo(TipoDePago.valueOf(rs.getString("tipoDePagoTransaccion")));
                ordenVenta.setResenha(new Reseña());
                ordenVenta.getResenha().setIdReseña(rs.getInt("idResenha"));
                ordenVenta.getResenha().setComentario(rs.getString("comentarioResenha"));
                ordenVenta.getResenha().setValoracion(rs.getInt("valoracionResenha"));
                
                ordenesVenta.add(ordenVenta);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        } finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ordenesVenta;
    }
    
    @Override
    public ArrayList<OrdenVenta> listarOrdenVentaPorCliente(int idCliente){
        ArrayList<OrdenVenta> ordenesVenta = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL LISTAR_ORDENVENTA_POR_ID(?)}");
            cst.setInt("_idCliente", idCliente);
            rs = cst.executeQuery();
            while(rs.next()) {
                OrdenVenta ordenVenta = new OrdenVenta();
                ordenVenta.setIdVenta(rs.getInt("idOrdenVenta"));
                ordenVenta.setFecha(rs.getDate("fechaOrdenventa"));
                ordenVenta.setHoraVenta(rs.getTime("horaVentaOrdenventa").toLocalTime());
                ordenVenta.setHoraFinPedido(rs.getTime("horaFinPedidoOrdenventa").toLocalTime());
                ordenVenta.setTipo(TipoDeVenta.valueOf(rs.getString("tipoOrdenventa")));
                ordenVenta.setEstado(rs.getString("estadoOrdenventa"));
                ordenVenta.setTotal(rs.getDouble("totalOrdenventa"));
                ordenVenta.setPersonal(new Personal());
                ordenVenta.getPersonal().setIdPersona(rs.getInt("idPersonaPersonal"));
                ordenesVenta.add(ordenVenta);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        } finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ordenesVenta;
    }
}

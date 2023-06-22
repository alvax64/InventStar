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
import lp2.cdejava.inventstar.clientes.model.ItemVenta;
import lp2.cdejava.inventstar.clientes.model.Reseña;
import lp2.cdejava.inventstar.clientes.model.TipoDePago;
import lp2.cdejava.inventstar.clientes.model.Transaccion;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.personal.dao.LineaOrdenVentaDAO;
import lp2.cdejava.inventstar.personal.model.LineaOrdenVenta;
import lp2.cdejava.inventstar.personal.model.OrdenVenta;
import lp2.cdejava.inventstar.personal.model.Personal;
import lp2.cdejava.inventstar.personal.model.Sucursal;
import lp2.cdejava.inventstar.personal.model.TipoDeVenta;

/**
 *
 * @author Usuario
 */
public class LineaOrdenVentaMySQL implements LineaOrdenVentaDAO {
    private Connection con;
    private CallableStatement cst;
    private ResultSet rs;
    @Override
    public int insertar(LineaOrdenVenta lineaOrdenVenta) {
        int respuesta = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL INSERTAR_LINEAORDENVENTA(?,?,?,?,?)}");
            cst.registerOutParameter("_idLineaOrdenVenta", java.sql.Types.INTEGER);
            cst.setInt("_cantidadLineaordenventa", lineaOrdenVenta.getCantidad());
            cst.setDouble("_subtotalLineaordenventa", lineaOrdenVenta.getSubtotal());
            cst.setInt("_fidOrdenVenta", lineaOrdenVenta.getOrden().getIdVenta());
            cst.setInt("_fidItemVenta", lineaOrdenVenta.getItem().getIdItemVenta());
            cst.executeUpdate();
            lineaOrdenVenta.setIdLineaOrdenVenta(cst.getInt("_idLineaOrdenVenta"));
            respuesta = 1;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta = 0;
        } finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return respuesta;
    }
    @Override
    public int modificar(LineaOrdenVenta lineaOrdenVenta) {
        int respuesta = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL MODIFICAR_LINEAORDENVENTA(?,?,?,?,?)}");
            cst.setInt("_idLineaOrdenVenta", lineaOrdenVenta.getIdLineaOrdenVenta());
            cst.setInt("_cantidadLineaordenventa", lineaOrdenVenta.getCantidad());
            cst.setDouble("_subtotalLineaordenventa", lineaOrdenVenta.getSubtotal());
            cst.setInt("_fidOrdenVenta", lineaOrdenVenta.getOrden().getIdVenta());
            cst.setInt("_fidItemVenta", lineaOrdenVenta.getItem().getIdItemVenta());
            cst.executeUpdate();
            respuesta = 1;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta = 0;
        } finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return respuesta;
    }
    @Override
    public int eliminar(LineaOrdenVenta lineaOrdenVenta) {
        int respuesta = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL ELIMINAR_LINEAORDENVENTA(?)}");
            cst.setInt("_idLineaOrdenVenta", lineaOrdenVenta.getIdLineaOrdenVenta());
            cst.executeUpdate();
            respuesta = 1;
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            respuesta = 0;
        } finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return respuesta;
    }
    @Override
    public ArrayList<LineaOrdenVenta> listarLineaOrdenVenta() {
        ArrayList<LineaOrdenVenta> lineasOrdenVenta = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cst = con.prepareCall("{CALL LISTAR_LINEAORDENVENTA()}");
            rs = cst.executeQuery();
            while(rs.next()){
                LineaOrdenVenta lineaOrdenVenta = new LineaOrdenVenta();
                lineaOrdenVenta.setIdLineaOrdenVenta(rs.getInt("idLineaOrdenVenta"));
                lineaOrdenVenta.setCantidad(rs.getInt("cantidadLineaordenventa"));
                lineaOrdenVenta.setSubtotal(rs.getDouble("subtotalLineaordenventa"));
                lineaOrdenVenta.setFechaHoraRegistro(rs.getDate("fecha_hora_registro"));
                lineaOrdenVenta.setOrden(new OrdenVenta());
                lineaOrdenVenta.getOrden().setIdVenta(rs.getInt("idOrdenVenta"));
                lineaOrdenVenta.getOrden().setFecha(rs.getDate("fechaOrdenventa"));
                lineaOrdenVenta.getOrden().setHoraVenta(rs.getTime("horaVentaOrdenventa").toLocalTime());
                lineaOrdenVenta.getOrden().setHoraFinPedido(rs.getTime("horaFinPedidoOrdenventa").toLocalTime());
                lineaOrdenVenta.getOrden().setTipo(TipoDeVenta.valueOf(rs.getString("tipoOrdenventa")));
                lineaOrdenVenta.getOrden().setEstado(rs.getString("estadoOrdenventa"));
                lineaOrdenVenta.getOrden().setTotal(rs.getDouble("totalOrdenventa"));
                lineaOrdenVenta.getOrden().setPersonal(new Personal());
                lineaOrdenVenta.getOrden().getPersonal().setIdPersona(rs.getInt("idPersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setNombres(rs.getString("nombresPersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setApellidoPat(rs.getString("apellidoPatPersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setApellidoMat(rs.getString("apellidoMatPersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setNumDocumento(rs.getString("numDocumentoPersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setTelefono1(rs.getString("telefono1PersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setTelefono2(rs.getString("telefono2PersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setEmail(rs.getString("emailPersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setDomicilio(rs.getString("domicilioPersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setFechaRegistro(rs.getDate("fechaRegistroPersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setFechaCumpleanhos(rs.getDate("fechaNacimientoPersonaPersonal"));
                lineaOrdenVenta.getOrden().getPersonal().setEstado(rs.getString("estadoPersonal"));
                lineaOrdenVenta.getOrden().setCliente(new Cliente());
                lineaOrdenVenta.getOrden().getCliente().setIdPersona(rs.getInt("idPersona"));
                lineaOrdenVenta.getOrden().getCliente().setAceptaPublicidad(rs.getBoolean("aceptaPublicidadCliente"));
                lineaOrdenVenta.getOrden().getCliente().setNombres(rs.getString("nombresPersona"));
                lineaOrdenVenta.getOrden().getCliente().setApellidoPat(rs.getString("apellidoPatPersona"));
                lineaOrdenVenta.getOrden().getCliente().setApellidoMat(rs.getString("apellidoMatPersona"));
                lineaOrdenVenta.getOrden().getCliente().setNumDocumento(rs.getString("numDocumentoPersona"));
                lineaOrdenVenta.getOrden().getCliente().setTelefono1(rs.getString("telefono1Persona"));
                lineaOrdenVenta.getOrden().getCliente().setTelefono2(rs.getString("telefono2Persona"));
                lineaOrdenVenta.getOrden().getCliente().setEmail(rs.getString("emailPersona"));
                lineaOrdenVenta.getOrden().getCliente().setDomicilio(rs.getString("domicilioPersona"));
                lineaOrdenVenta.getOrden().getCliente().setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                lineaOrdenVenta.getOrden().getCliente().setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                lineaOrdenVenta.getOrden().setSucursal(new Sucursal());
                lineaOrdenVenta.getOrden().getSucursal().setId_sucursal(rs.getInt("id_sucursal"));
                lineaOrdenVenta.getOrden().getSucursal().setNombre(rs.getString("nombreSucursal"));
                lineaOrdenVenta.getOrden().getSucursal().setDireccion(rs.getString("direccionSucursal"));
                lineaOrdenVenta.getOrden().getSucursal().setAforo(rs.getInt("aforoSucursal"));
                lineaOrdenVenta.getOrden().getSucursal().setTelefono(rs.getString("telefonoSucursal"));
                lineaOrdenVenta.getOrden().getSucursal().setEmail(rs.getString("emailSucursal"));
                lineaOrdenVenta.getOrden().setTransaccion(new Transaccion());
                lineaOrdenVenta.getOrden().getTransaccion().setIdTransaccion(rs.getInt("idTransaccion"));
                lineaOrdenVenta.getOrden().getTransaccion().setFecha(rs.getDate("fechaTransaccion"));
                lineaOrdenVenta.getOrden().getTransaccion().setHora(rs.getTime("horaTransaccion").toLocalTime());
                lineaOrdenVenta.getOrden().getTransaccion().setMoneda(rs.getString("monedaTransaccion"));
                lineaOrdenVenta.getOrden().getTransaccion().setTipo(TipoDePago.valueOf(rs.getString("tipoDePagoTransaccion")));
                lineaOrdenVenta.getOrden().setResenha(new Reseña());
                lineaOrdenVenta.getOrden().getResenha().setIdReseña(rs.getInt("idResenha"));
                lineaOrdenVenta.getOrden().getResenha().setIdReseña(rs.getInt("idResenha"));
                lineaOrdenVenta.getOrden().getResenha().setComentario(rs.getString("comentarioResenha"));
                lineaOrdenVenta.getOrden().getResenha().setValoracion(rs.getInt("valoracionResenha"));
                lineaOrdenVenta.setItem(new ItemVenta());
                lineaOrdenVenta.getItem().setIdItemVenta(rs.getInt("idItemVenta"));
                lineaOrdenVenta.getItem().setNombre(rs.getString("nombreItemventa"));
                lineaOrdenVenta.getItem().setDescripcion(rs.getString("descripcionItemventa"));
                lineaOrdenVenta.getItem().setPrecioUnitario(rs.getDouble("precioUnitarioItemventa"));
                lineasOrdenVenta.add(lineaOrdenVenta);
            }   
        } catch(Exception ex){
            System.out.println(ex.getMessage());
            lineasOrdenVenta = new ArrayList<>();
        } finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return lineasOrdenVenta;
    }
}
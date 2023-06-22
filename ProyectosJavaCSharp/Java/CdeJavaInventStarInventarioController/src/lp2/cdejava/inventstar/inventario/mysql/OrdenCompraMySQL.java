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
import lp2.cdejava.inventstar.inventario.dao.OrdenCompraDAO;
import lp2.cdejava.inventstar.inventario.model.OrdenCompra;
import lp2.cdejava.inventstar.inventario.model.Proveedor;
import lp2.cdejava.inventstar.personal.model.Matriz;
import lp2.cdejava.inventstar.personal.model.Sucursal;

/**
 *
 * @author Lenovo
 */
public class OrdenCompraMySQL implements OrdenCompraDAO{
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;

    @Override
    public int insertarOrdenCompra(OrdenCompra ordenCompra) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL INSERTAR_ORDENCOMPRA(?,?,?,?,?)}");
            cs.registerOutParameter("_id_compra", java.sql.Types.INTEGER);
            cs.setDate("_fechaCompraOrdenCompra", new java.sql.Date(ordenCompra.getFechaCompra().getTime()));
            cs.setString("_estadoOrdenCompra", ordenCompra.getEstado());
            cs.setInt("_fid_proveedor", ordenCompra.getProveedor().getIdProveedor());
            if(ordenCompra.getSucursal() != null)
                cs.setInt("_fid_sucursal", ordenCompra.getSucursal().getId_sucursal());
            else cs.setInt("_fid_sucursal", 0);
            cs.executeUpdate();
            ordenCompra.setIdCompra(cs.getInt("_id_compra"));
            resultado = 1;
        } catch (Exception e) {
            System.out.println("Error al insertar orden de compra: " + e.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificarOrdenCompra(OrdenCompra ordenCompra) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL MODIFICAR_ORDENCOMPRA(?,?,?,?,?)}");
            cs.setInt("_id_compra", ordenCompra.getIdCompra());
            cs.setDate("_fechaCompraOrdenCompra", new java.sql.Date(ordenCompra.getFechaCompra().getTime()));
            cs.setString("_estadoOrdenCompra", ordenCompra.getEstado());
            cs.setInt("_fid_proveedor", ordenCompra.getProveedor().getIdProveedor());
            cs.setInt("_fid_sucursal", ordenCompra.getSucursal().getId_sucursal());
            cs.executeUpdate();
            resultado = 1;
        } catch (Exception e) {
            System.out.println("Error al modificar orden de compra: " + e.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminarOrdenCompra(int idOrdenCompra) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL ELIMINAR_ORDENCOMPRA(?)}");
            cs.setInt("_id_compra", idOrdenCompra);
            cs.executeUpdate();
            resultado = 1;
        } catch (Exception e) {
            System.out.println("Error al eliminar orden de compra: " + e.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<OrdenCompra> listarOrdenCompra() {
        ArrayList<OrdenCompra> ordenesCompra = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL LISTAR_ORDENCOMPRA()}");
            rs = cs.executeQuery();
            while(rs.next()){
                OrdenCompra ordenCompra = new OrdenCompra();
                ordenCompra.setIdCompra(rs.getInt("id_compra"));
                ordenCompra.setFechaCompra(rs.getDate("fechaCompraOrdenCompra"));
                ordenCompra.setEstado(rs.getString("estadoOrdenCompra"));
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                proveedor.setRUC(rs.getString("RUCProveedor"));
                proveedor.setRazonSocial(rs.getString("razon_socialProveedor"));
                proveedor.setDireccion(rs.getString("direccionProveedor"));
                proveedor.setEmail(rs.getString("emailProveedor"));
                proveedor.setTelefono(rs.getString("telefonoProveedor"));
                ordenCompra.setProveedor(proveedor);
                Sucursal sucursal = new Sucursal();
                sucursal.setId_sucursal(rs.getInt("id_sucursal"));
                sucursal.setNombre(rs.getString("nombreSucursal"));
                sucursal.setDireccion(rs.getString("direccionSucursal"));
                sucursal.setAforo(rs.getInt("aforoSucursal"));
                sucursal.setTelefono(rs.getString("telefonoSucursal"));
                sucursal.setEmail(rs.getString("emailSucursal"));
                Matriz matriz = new Matriz();
                matriz.setId_matriz(rs.getInt("id_matriz"));
                matriz.setNombreMatriz(rs.getString("nombreMatriz"));
                matriz.setRazonsocialMatriz(rs.getString("razonsocialMatriz"));
                matriz.setDireccionMatriz(rs.getString("direccionMatriz"));
                matriz.setTelefonoMatriz(rs.getString("telefonoMatriz"));
                matriz.setEmailMatriz(rs.getString("emailMatriz"));
                sucursal.setMatriz(matriz);
                ordenCompra.setSucursal(sucursal);
                ordenesCompra.add(ordenCompra);
            }
        } catch (Exception e) {
            System.out.println("Error al listar ordenes de compra: " + e.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ordenesCompra;
    }
    
    @Override
    public ArrayList<OrdenCompra> listarOrdenCompraPorProveedor(Proveedor _proveedor){
        ArrayList<OrdenCompra> ordenesCompra = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{CALL LISTAR_ORDENCOMPRA_POR_PROVEEDOR(?)}");
            cs.setInt("_id_proveedor", _proveedor.getIdProveedor());
            rs = cs.executeQuery();
            while(rs.next()){
                OrdenCompra ordenCompra = new OrdenCompra();
                ordenCompra.setIdCompra(rs.getInt("id_compra"));
                ordenCompra.setFechaCompra(rs.getDate("fechaCompraOrdenCompra"));
                ordenCompra.setEstado(rs.getString("estadoOrdenCompra"));
                Proveedor proveedor = new Proveedor();
                proveedor = _proveedor;
                ordenCompra.setProveedor(proveedor);
                ordenesCompra.add(ordenCompra);
            }
        } catch (Exception e) {
            System.out.println("Error al listar ordenes de compra: " + e.getMessage());
        } finally {
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ordenesCompra;
    }
}
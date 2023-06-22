/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.OrdenCompra;
import lp2.cdejava.inventstar.inventario.model.Proveedor;

/**
 *
 * @author Lenovo
 */
public interface OrdenCompraDAO {
    public int insertarOrdenCompra(OrdenCompra ordenCompra);
    public int modificarOrdenCompra(OrdenCompra ordenCompra);
    public int eliminarOrdenCompra(int idOrdenCompra);
    public ArrayList<OrdenCompra> listarOrdenCompra();
    public ArrayList<OrdenCompra> listarOrdenCompraPorProveedor(Proveedor _proveedor);
}

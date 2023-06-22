/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.Proveedor;

/**
 *
 * @author Lenovo
 */
public interface ProveedorDAO {
    public int insertarProveedor(Proveedor proveedor);
    public ArrayList<Proveedor> listarProveedor();
    public int modificarProveedor(Proveedor proveedor);
    public int eliminarProveedor(int idProveedor);
}

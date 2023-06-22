/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.personal.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.personal.model.Sucursal;

/**
 *
 * @author Usuario
 */
public interface SucursalDAO {
    public int insertar(Sucursal sucursal);
    public int modificar(Sucursal sucursal);
    public int eliminar(Sucursal sucursal);
    public ArrayList<Sucursal> listarSucursal();
    public ArrayList<Sucursal> listarSucursalPorNombre(String nombre);
}

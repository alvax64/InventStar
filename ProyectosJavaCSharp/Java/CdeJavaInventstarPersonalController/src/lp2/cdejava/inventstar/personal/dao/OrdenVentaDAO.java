/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.personal.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.personal.model.OrdenVenta;

/**
 *
 * @author Usuario
 */
public interface OrdenVentaDAO {
    public int insertar(OrdenVenta ordenVenta);
    public int modificar(OrdenVenta ordenVenta);
    public int eliminar(OrdenVenta ordenVenta);
    public ArrayList<OrdenVenta> listarOrdenVenta();
    public ArrayList<OrdenVenta> listarOrdenVentaPorCliente(int idCliente);
}

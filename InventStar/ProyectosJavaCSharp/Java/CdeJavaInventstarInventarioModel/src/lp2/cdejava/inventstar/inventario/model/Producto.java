/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.model;

import lp2.cdejava.inventstar.clientes.model.ItemVenta;

/**
 *
 * @author Lenovo
 */
public  class Producto extends ItemVenta {
    //private static int idProducto = 0;
    public Producto(){}
    
    public Producto(String nombre, double precioUnitario, String descripcion) {
        super(nombre, precioUnitario, descripcion);
        //this.idProducto++;
    }

    /*public static int getIdProducto() {
        return idProducto;
    }

    public static void setIdProducto(int idProducto) {
        Producto.idProducto = idProducto;
    }*/
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.model;


import lp2.cdejava.inventstar.clientes.model.Promocion;

/**
 *
 * @author Lenovo
 */
public class ProductoXPromocion {
    private static int id = 0;
    private Promocion promocion;
    private Producto producto;
    private boolean activo;

    public ProductoXPromocion(Promocion promocion, Producto producto, boolean activo) {
        this.promocion = promocion;
        this.producto = producto;
        this.activo = activo;
        this.id++;
    }

    

    

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        ProductoXPromocion.id = id;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
    
}

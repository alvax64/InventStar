/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.model;

/**
 *
 * @author Lenovo
 */
public class UtensiliosDeServicio extends Lote{
    
    private Producto producto;
    private boolean activo;

    public UtensiliosDeServicio(){}
    
    public UtensiliosDeServicio(String nombre, double cantidad) {
        super(nombre,cantidad);
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

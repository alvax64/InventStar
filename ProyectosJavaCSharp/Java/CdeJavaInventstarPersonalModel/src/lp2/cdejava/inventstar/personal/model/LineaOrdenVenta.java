/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.personal.model;


import java.util.Date;
import lp2.cdejava.inventstar.clientes.model.ItemVenta;

public class LineaOrdenVenta {
    private static int idLineaOrdenVenta = 0;
    private int cantidad;
    private double subtotal;
    private Date fechaHoraRegistro;
    private OrdenVenta orden;
    private boolean activo;
    private ItemVenta item;
    public LineaOrdenVenta() {
    }

    public LineaOrdenVenta(int cantidad, double subtotal,Date fechaHoraRegistro) {
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }


    public int getIdLineaOrdenVenta() {
        return idLineaOrdenVenta;
    }

    public void setIdLineaOrdenVenta(int id) {
        this.idLineaOrdenVenta = id;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public OrdenVenta getOrden() {
        return orden;
    }

    public void setOrden(OrdenVenta orden) {
        this.orden = orden;
    }

    /*public ArrayList<ItemVenta> getItemsVenta() {
        return itemsVenta;
    }

    public void setItemsVenta(ArrayList<ItemVenta> itemsVenta) {
        this.itemsVenta = itemsVenta;
    }*/

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ItemVenta getItem() {
        return item;
    }

    public void setItem(ItemVenta item) {
        this.item = item;
    }
    
    
}

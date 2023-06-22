package lp2.cdejava.inventstar.clientes.model;

import lp2.cdejava.inventstar.interfaces.model.IConsultable;



public class ItemVenta implements IConsultable{
    private int idItemVenta;
    private String nombre;
    private double precioUnitario;
    private String descripcion;

    public ItemVenta() {
    }

    
    
    public ItemVenta(String nombre, double precioUnitario, String descripcion) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.descripcion = descripcion;
    }

    public int getIdItemVenta() {
        return idItemVenta;
    }

    public void setIdItemVenta(int id) {
        this.idItemVenta = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}

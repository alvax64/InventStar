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
public abstract class Alimento extends Producto{
	private double cantidad;
	private String unidadMedida;
	private int calorias;

    public Alimento(){}  
        
    public Alimento(double cantidad, String unidadMedida, int calorias, String nombre, double precioUnitario, String descripcion) {
        super(nombre, precioUnitario, descripcion);
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.calorias = calorias;
    }

    

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }
        
        
}

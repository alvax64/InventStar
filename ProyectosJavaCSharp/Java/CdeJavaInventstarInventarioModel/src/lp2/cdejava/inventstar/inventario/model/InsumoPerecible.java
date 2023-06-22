/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.inventario.model;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class InsumoPerecible extends Lote{
	private Date fechaIngeso;
	private Date fechaVencimiento; 
        private Ingrediente ingrediente;
        private Comida comida;
        private boolean activo;

    public InsumoPerecible() {
    }
    
        
        public InsumoPerecible(Date fechaIngeso, Date fechaVencimiento, String nombre, double cantidad) {
        super(nombre, cantidad);
        this.fechaIngeso = fechaIngeso;
        this.fechaVencimiento = fechaVencimiento;
        
    }
    public Date getFechaIngeso() {
        return fechaIngeso;
    }

    public void setFechaIngeso(Date fechaIngeso) {
        this.fechaIngeso = fechaIngeso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
        
        
}

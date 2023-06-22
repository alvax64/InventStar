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
public class Bebida extends Alimento {
    private TipoDeBebida tipo;
    private boolean esFria;
    private TamanhoBebida tamanho;
    private String instrucciones;
    private int tiempoPreparacion;
    private boolean activo;
    
    public Bebida(){}
    
    public Bebida(TipoDeBebida tipo, boolean esFria, TamanhoBebida tamanho, String instrucciones, int tiempoPreparacion, double cantidad, String unidadMedida, int calorias, String nombre, double precioUnitario, String descripcion) {
        super(cantidad, unidadMedida, calorias, nombre, precioUnitario, descripcion);
        this.tipo = tipo;
        this.esFria = esFria;
        this.tamanho = tamanho;
        this.instrucciones = instrucciones;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    

    public TipoDeBebida getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeBebida tipo) {
        this.tipo = tipo;
    }

    public boolean isEsFria() {
        return esFria;
    }

    public void setEsFria(boolean esFria) {
        this.esFria = esFria;
    }

    public TamanhoBebida getTamanho() {
        return tamanho;
    }

    public void setTamanho(TamanhoBebida tamanho) {
        this.tamanho = tamanho;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}

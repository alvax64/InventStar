/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.model;

/**
 *
 * @author Usuario
 */
public class Comida extends Alimento{
    private  TipoDeComida tipo;
    private int segundosACalentar;
    private InsumoPerecible insumo;
    private boolean activo;

    public Comida(){}
    
    public Comida(TipoDeComida tipo, int segundosACalentar, double cantidad, String unidadMedida, int calorias, String nombre, double precioUnitario, String descripcion) {
        super(cantidad, unidadMedida, calorias, nombre, precioUnitario, descripcion);
        this.tipo = tipo;
        this.segundosACalentar = segundosACalentar;
    }
    public TipoDeComida getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeComida tipo) {
        this.tipo = tipo;
    }

    public int getSegundosACalentar() {
        return segundosACalentar;
    }

    public void setSegundosACalentar(int segundosACalentar) {
        this.segundosACalentar = segundosACalentar;
    }

    public InsumoPerecible getInsumo() {
        return insumo;
    }

    public void setInsumo(InsumoPerecible insumo) {
        this.insumo = insumo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}

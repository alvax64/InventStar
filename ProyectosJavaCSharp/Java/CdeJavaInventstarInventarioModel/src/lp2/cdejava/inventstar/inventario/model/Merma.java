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
public class Merma {
    private static int idMerma = 0;
    private Date fechaRegistro;
    private double cantidad;
    private String motivo; 
    private Lote lote;
    private boolean activo; 

    public Merma() {
    }

    
    public Merma(Date fechaRegistro, double cantidad, String motivo) {
        this.fechaRegistro = fechaRegistro;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    

    public int getIdMerma() {
        return idMerma;
    }

    public void setIdMerma(int idMerma) {
        this.idMerma = idMerma;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}

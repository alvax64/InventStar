/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.clientes.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class TarjetaInventstar {
    private int idTarjeta;
    private int puntosAcumulados;
    private Date fechaRegistro;
    private Cliente cliente; 
    private boolean activo;
    

    public TarjetaInventstar() {
        
    }

    public TarjetaInventstar(int puntosAcumulados, Date fechaRegistro) {
        this.puntosAcumulados = puntosAcumulados;
        this.fechaRegistro = fechaRegistro;
    }

    


    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}

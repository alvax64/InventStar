package lp2.cdejava.inventstar.clientes.model;

import java.time.LocalTime;
import java.util.Date;

public class Transaccion {
    private int idTransaccion;
    private Date fecha;
    private LocalTime hora;
    private TipoDePago tipo;
    private String moneda;
    private boolean activo;
    
    public Transaccion(){
        
    }

    public Transaccion(Date fecha, LocalTime hora, TipoDePago tipo, String moneda) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.moneda = moneda;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public TipoDePago getTipo() {
        return tipo;
    }

    public void setTipo(TipoDePago tipo) {
        this.tipo = tipo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

  
    
    
}

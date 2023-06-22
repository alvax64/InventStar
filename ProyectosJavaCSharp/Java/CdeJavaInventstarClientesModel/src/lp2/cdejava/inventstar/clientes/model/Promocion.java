package lp2.cdejava.inventstar.clientes.model;

import java.util.ArrayList;
import java.util.Date;

public class Promocion extends ItemVenta{
    private Date fechaInicio;
    private Date fechaFin;
    private boolean estado;
    private TipoDePromocion tipo;

    public Promocion() {
    }
    
    
    
    public Promocion(Date fechaInicio, Date fechaFin, boolean estado, TipoDePromocion tipo, String nombre, double precioUnitario, String descripcion) {
        super(nombre, precioUnitario, descripcion);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        this.tipo = tipo;
    }
    

    
    

   

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public TipoDePromocion getTipoPromocion() {
        return tipo;
    }

    public void setTipoPromocion(TipoDePromocion tipo) {
        this.tipo = tipo;
    }

  

    
    
}

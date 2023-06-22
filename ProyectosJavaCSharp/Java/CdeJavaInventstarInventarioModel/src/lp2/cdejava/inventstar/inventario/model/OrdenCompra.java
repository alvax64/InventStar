package lp2.cdejava.inventstar.inventario.model;


import java.util.Date;
import lp2.cdejava.inventstar.interfaces.model.IReporte;

import lp2.cdejava.inventstar.personal.model.Sucursal;

public class OrdenCompra implements IReporte{
    private static int idCompra = 0;
    private Date fechaCompra;
    private String estado;
    private Proveedor proveedor;
    private Sucursal sucursal;

    public OrdenCompra() {
    }
    
    

    public OrdenCompra(Date fechaCompra, String estado) {
        this.fechaCompra = fechaCompra;
        this.estado = estado;
    }

    

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    
    
    
}

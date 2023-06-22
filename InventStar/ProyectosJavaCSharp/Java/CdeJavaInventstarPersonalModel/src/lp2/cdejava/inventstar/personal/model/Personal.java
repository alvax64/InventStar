package lp2.cdejava.inventstar.personal.model;

import java.util.Date;
import lp2.cdejava.inventstar.clientes.model.Persona;

public class Personal extends Persona{
    private String estado;
    private Cargo cargo;
    private Sucursal sucursal;
    private boolean activo;

    public Personal() {
    }

    
    public Personal(String estado, String nombres, String apellidoPat, String apellidoMat, String numDocumento, String telefono1, String telefono2, String email, String domicilio, Date fechaRegistro, Date fechaCumpleanhos) {
        super(nombres, apellidoPat, apellidoMat, numDocumento, telefono1, telefono2, email, domicilio, fechaRegistro, fechaCumpleanhos);
        this.estado = estado;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    
    
    
}

package lp2.cdejava.inventstar.clientes.model;

import java.util.Date;
public class Cliente extends Persona{
    private boolean aceptaPublicidad;
    private boolean activo;

    public Cliente() {
    }

    public Cliente(boolean aceptaPublicidad, String nombres, String apellidoPat, String apellidoMat, String numDocumento, String telefono1, String telefono2, String email, String domicilio, Date fechaRegistro, Date fechaCumpleanhos) {
        super(nombres, apellidoPat, apellidoMat, numDocumento, telefono1, telefono2, email, domicilio, fechaRegistro, fechaCumpleanhos);
        this.aceptaPublicidad = aceptaPublicidad;
    }

    public boolean isAceptaPublicidad() {
        return aceptaPublicidad;
    }

    public void setAceptaPublicidad(boolean aceptaPublicidad) {
        this.aceptaPublicidad = aceptaPublicidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

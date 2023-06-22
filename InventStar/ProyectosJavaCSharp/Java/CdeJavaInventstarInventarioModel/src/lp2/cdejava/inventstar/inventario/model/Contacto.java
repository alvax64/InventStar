package lp2.cdejava.inventstar.inventario.model;

import java.util.Date;
import lp2.cdejava.inventstar.clientes.model.Persona;

public class Contacto extends Persona{
    private String puesto;
    private Proveedor proveedor;
    private boolean activo;

    public Contacto(){}
    
    public Contacto(String puesto, String nombres, String apellidoPat, String apellidoMat, String numDocumento, String telefono1, String telefono2, String email, String domicilio, Date fechaRegistro, Date fechaCumpleanhos) {
        super(nombres, apellidoPat, apellidoMat, numDocumento, telefono1, telefono2, email, domicilio, fechaRegistro, fechaCumpleanhos);
        this.puesto = puesto;
        
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
  
    
}

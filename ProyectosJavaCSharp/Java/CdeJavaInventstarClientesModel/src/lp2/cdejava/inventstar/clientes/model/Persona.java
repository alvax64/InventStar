package lp2.cdejava.inventstar.clientes.model;

import java.util.Date;
import lp2.cdejava.inventstar.interfaces.model.IConsultable;

public class Persona implements IConsultable{
    private int idPersona;
    private String nombres;
    private String apellidoPat;
    private String apellidoMat;
    private String numDocumento;
    private String telefono1;
    private String telefono2;
    private String email;
    private String domicilio;
    private Date fechaRegistro;
    private Date fechaCumpleanhos;

    public Persona() {
    }

    
    public Persona(String nombres, String apellidoPat, String apellidoMat, String numDocumento, String telefono1, String telefono2, String email, String domicilio, Date fechaRegistro, Date fechaCumpleanhos) {
        this.nombres = nombres;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.numDocumento = numDocumento;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
        this.domicilio = domicilio;
        this.fechaRegistro = fechaRegistro;
        this.fechaCumpleanhos = fechaCumpleanhos;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaCumpleanhos() {
        return fechaCumpleanhos;
    }

    public void setFechaCumpleanhos(Date fechaCumpleanhos) {
        this.fechaCumpleanhos = fechaCumpleanhos;
    }
    
    
}

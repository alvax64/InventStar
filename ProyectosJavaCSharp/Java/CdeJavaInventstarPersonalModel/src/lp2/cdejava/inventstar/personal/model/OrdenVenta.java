package lp2.cdejava.inventstar.personal.model;

import java.time.LocalTime;

import java.util.Date;
import lp2.cdejava.inventstar.clientes.model.Cliente;
import lp2.cdejava.inventstar.clientes.model.Reseña;
import lp2.cdejava.inventstar.clientes.model.Transaccion;
import lp2.cdejava.inventstar.interfaces.model.IReporte;

public class OrdenVenta implements IReporte{
    private static int idVenta = 0;
    private Date fecha;
    private LocalTime horaVenta;
    private LocalTime horaFinPedido;
    private TipoDeVenta tipo;
    private String estado;
    private double total;
    private Personal personal;
    private Cliente cliente; 
    private Transaccion transaccion;
    private Reseña resenha;
    private Sucursal sucursal;
    private boolean activo;

    public OrdenVenta() {
    }

    public OrdenVenta(Date fecha, LocalTime horaVenta, LocalTime horaFinPedido, TipoDeVenta tipo, String estado, double total) {
        this.fecha = fecha;
        this.horaVenta = horaVenta;
        this.horaFinPedido = horaFinPedido;
        this.tipo = tipo;
        this.estado = estado;
        this.total = total;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    
    

    public Reseña getResenha() {
        return resenha;
    }

    public void setResenha(Reseña resenha) {
        this.resenha = resenha;
    }


    public int getIdVenta() {
        return idVenta;
    }

  public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }


    public void setFechaVenta(Date fechaVenta) {
        this.fecha = fechaVenta;
    }

    public LocalTime getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(LocalTime horaVenta) {
        this.horaVenta = horaVenta;
    }

    public LocalTime getHoraFinPedido() {
        return horaFinPedido;
    }

    public void setHoraFinPedido(LocalTime horaFinPedido) {
        this.horaFinPedido = horaFinPedido;
    }

    public TipoDeVenta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeVenta tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}

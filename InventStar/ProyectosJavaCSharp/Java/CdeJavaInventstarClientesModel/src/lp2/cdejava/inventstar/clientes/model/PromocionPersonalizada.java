package lp2.cdejava.inventstar.clientes.model;

import java.util.Date;


public class PromocionPersonalizada extends Promocion{
    private String mensaje;
    private TarjetaInventstar tarjeta;
    private boolean activo;

    public PromocionPersonalizada() {
    }

    
    
    public PromocionPersonalizada(String mensaje, Date fechaInicio, Date fechaFin, boolean estado, TipoDePromocion tipo, String nombre, double precioUnitario, String descripcion) {
        super(fechaInicio, fechaFin, estado, tipo, nombre, precioUnitario, descripcion);
        this.mensaje = mensaje;
    }


    

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    

    public TarjetaInventstar getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaInventstar tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    
}

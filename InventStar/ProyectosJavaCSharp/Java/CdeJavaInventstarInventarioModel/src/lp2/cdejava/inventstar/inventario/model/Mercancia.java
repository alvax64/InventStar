package lp2.cdejava.inventstar.inventario.model;


public class Mercancia extends Producto{
    //private static int idMercancia = 0;
    private CategoriaMercancia categoria;
    private String codigoBarras;
    private Lote lote;
    private boolean activo;

    public Mercancia(){}
    
    public Mercancia(CategoriaMercancia categoria, String codigoBarras, String nombre, double precioUnitario, String descripcion) {
        super(nombre, precioUnitario, descripcion);
        this.categoria = categoria;
        this.codigoBarras = codigoBarras;
    }

    

    public CategoriaMercancia getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaMercancia categoria) {
        this.categoria = categoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }


    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
    
    
    
}

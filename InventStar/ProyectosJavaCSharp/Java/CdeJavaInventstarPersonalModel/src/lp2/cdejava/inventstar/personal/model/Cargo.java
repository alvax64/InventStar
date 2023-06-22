package lp2.cdejava.inventstar.personal.model;


public class Cargo {
    private int idCargo;
    private String nombre;
    private String descripcion;
    private double salario;
    private boolean modificaInventario;
    private boolean activo;

    public Cargo() {
    }
    
    public Cargo(String nombre, String descripcion, double salario, boolean modificaInventario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.salario = salario;
        this.modificaInventario = modificaInventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean isModificaInventario() {
        return modificaInventario;
    }

    public void setModificaInventario(boolean modificaInventario) {
        this.modificaInventario = modificaInventario;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    
}


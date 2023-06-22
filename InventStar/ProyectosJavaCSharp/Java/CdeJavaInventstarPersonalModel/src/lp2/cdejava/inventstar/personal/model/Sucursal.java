package lp2.cdejava.inventstar.personal.model;

public class Sucursal {
    private int id_sucursal ;
    private String nombre;
    private String direccion;
    private int aforo;
    private String telefono;
    private String email;
    private Matriz matriz;
    private boolean activo;

    public Sucursal() {
    }


    public Sucursal(String nombre, String direccion, int aforo, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.aforo = aforo;
        this.telefono = telefono;
        this.email = email;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Matriz getMatriz() {
        return matriz;
    }

    public void setMatriz(Matriz matriz) {
        this.matriz = matriz;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
    
}

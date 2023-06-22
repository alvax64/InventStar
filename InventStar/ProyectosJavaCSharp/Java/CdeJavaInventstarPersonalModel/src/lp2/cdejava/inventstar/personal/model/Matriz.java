package lp2.cdejava.inventstar.personal.model;

public class Matriz {
    private int id_matriz ;
    private String nombreMatriz ;
    private String razonsocialMatriz ;
    private String direccionMatriz ;
    private String telefonoMatriz ;
    private String emailMatriz ;
    private boolean activo;

    public Matriz() {
    }

    public Matriz(String nombreMatriz, String razonsocialMatriz, String direccionMatriz, String telefonoMatriz, String emailMatriz) {
        
        this.nombreMatriz = nombreMatriz;
        this.razonsocialMatriz = razonsocialMatriz;
        this.direccionMatriz = direccionMatriz;
        this.telefonoMatriz = telefonoMatriz;
        this.emailMatriz = emailMatriz;
    }

    public int getId_matriz() {
        return id_matriz;
    }

    public void setId_matriz(int id_matriz) {
        this.id_matriz = id_matriz;
    }

    public String getNombreMatriz() {
        return nombreMatriz;
    }

    public void setNombreMatriz(String nombreMatriz) {
        this.nombreMatriz = nombreMatriz;
    }

    public String getRazonsocialMatriz() {
        return razonsocialMatriz;
    }

    public void setRazonsocialMatriz(String razonsocialMatriz) {
        this.razonsocialMatriz = razonsocialMatriz;
    }

    public String getDireccionMatriz() {
        return direccionMatriz;
    }

    public void setDireccionMatriz(String direccionMatriz) {
        this.direccionMatriz = direccionMatriz;
    }

    public String getTelefonoMatriz() {
        return telefonoMatriz;
    }

    public void setTelefonoMatriz(String telefonoMatriz) {
        this.telefonoMatriz = telefonoMatriz;
    }

    public String getEmailMatriz() {
        return emailMatriz;
    }

    public void setEmailMatriz(String emailMatriz) {
        this.emailMatriz = emailMatriz;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

   
    
    
}

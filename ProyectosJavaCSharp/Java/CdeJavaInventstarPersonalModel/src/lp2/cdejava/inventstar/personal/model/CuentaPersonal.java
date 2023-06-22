package lp2.cdejava.inventstar.personal.model;

/**
 *
 * @author Usuario
 */
public class CuentaPersonal {
    private int idCuentaPersonal;
    private String username;
    private String password;
    private Personal personal;
    private boolean activo;

    public CuentaPersonal() {
    }

    
    public CuentaPersonal(String username, String password, Personal personal) {
        this.username = username;
        this.password = password;
        this.personal = personal;
    }

    public int getIdCuentaPersonal() {
        return idCuentaPersonal;
    }

    public void setIdCuentaPersonal(int idCuentaPersonal) {
        this.idCuentaPersonal = idCuentaPersonal;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
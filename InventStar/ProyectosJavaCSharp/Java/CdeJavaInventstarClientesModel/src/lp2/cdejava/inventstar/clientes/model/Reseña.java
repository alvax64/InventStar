/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2.cdejava.inventstar.clientes.model;

/**
 *
 * @author Lenovo
 */
public class Reseña {
    private int idReseña;
    private String comentario;
    private int valoracion;
    private boolean activo;
    

    public Reseña() {
    }

    public Reseña(String comentario, int valoracion) {
        this.comentario = comentario;
        this.valoracion = valoracion;
    }

    public int getIdReseña() {
        return idReseña;
    }

    public void setIdReseña(int idReseña) {
        this.idReseña = idReseña;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}

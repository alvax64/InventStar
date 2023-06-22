/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.personal.model;

/**
 *
 * @author Arian
 */
public class Video {
    private int idVideo;
    private String titulo;
    private String descripcion;
    private int duracion;
    private byte[] url;

    public Video() {
    }

    public Video(int idVideo, String titulo, String descripcion, int duracion, byte[] url) {
        this.idVideo = idVideo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.url = url;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public byte[] getUrl() {
        return url;
    }

    public void setUrl(byte[] url) {
        this.url = url;
    }
    
    
}


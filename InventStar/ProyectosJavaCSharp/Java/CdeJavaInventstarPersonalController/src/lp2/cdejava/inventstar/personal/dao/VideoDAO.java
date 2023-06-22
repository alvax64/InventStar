/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.personal.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.personal.model.Video;

/**
 *
 * @author Arian
 */
public interface VideoDAO {
    public ArrayList<Video> listarVideos();
    public byte[] obtenerUrl(int idVideo);
}


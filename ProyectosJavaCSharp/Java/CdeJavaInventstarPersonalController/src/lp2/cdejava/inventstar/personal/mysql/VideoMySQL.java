/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.personal.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.personal.dao.VideoDAO;
import lp2.cdejava.inventstar.personal.model.Video;

/**
 *
 * @author Arian
 */
public class VideoMySQL implements VideoDAO {
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public ArrayList<Video> listarVideos() {
        ArrayList<Video> videos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_VIDEO_TODOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Video video = new Video();
                video.setIdVideo(rs.getInt("id_video"));
                video.setTitulo(rs.getString("titulo"));
                video.setDescripcion(rs.getString("descripcion"));
                video.setDuracion(rs.getInt("duracion"));
                //video.setUrl(rs.getBytes("url"));
                videos.add(video);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return videos;
    }

    @Override
    public byte[] obtenerUrl(int idVideo) {
        byte[] video = null;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call OBTENER_VIDEO_X_ID(?)}");
            cs.setInt("_id_video", idVideo);
            rs = cs.executeQuery();
            if(rs.next()){
                video = rs.getBytes("url");
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return video;
    }
}
    



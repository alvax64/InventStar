/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.clientes.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.dao.ResenhaDAO;
import lp2.cdejava.inventstar.clientes.model.Reseña;
import lp2.cdejava.inventstar.config.DBManager;

/**
 *
 * @author Usuario
 */
public class ResenhaMySQL implements ResenhaDAO{
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    @Override
    public int insertar(Reseña resenha) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_RESENHA(?,?,?)}");
            
            cs.registerOutParameter("_idResenha",java.sql.Types.INTEGER);
            cs.setString("_comentarioResenha",resenha.getComentario());
            cs.setInt("_valoracionResenha", resenha.getValoracion());
            cs.executeUpdate();
            resenha.setIdReseña(cs.getInt("_idResenha"));
            resultado = resenha.getIdReseña();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Reseña resenha) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_RESENHA(?,?,?)}");
            cs.setInt("_idResenha",resenha.getIdReseña());
            cs.setString("_comentarioResenha",resenha.getComentario());
            cs.setInt("_valoracionResenha", resenha.getValoracion());
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idresenha) {
        int resultado = 0;
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_RESENHA(?)}");
            cs.setInt("_idResenha", idresenha);
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Reseña> listarTodasReseñas() {
        ArrayList<Reseña> resenhas = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_RESENHA()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                Reseña resenha= new Reseña();
                resenha.setIdReseña(rs.getInt("idResenha"));
                resenha.setComentario(rs.getString("comentarioResenha"));
                resenha.setValoracion(rs.getInt("valoracionResenha"));
                resenha.setActivo(true);
                resenhas.add(resenha);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resenhas;
    }
    
}

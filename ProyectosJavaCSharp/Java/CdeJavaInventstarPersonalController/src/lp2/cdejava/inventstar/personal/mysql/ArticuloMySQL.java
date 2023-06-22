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
import lp2.cdejava.inventstar.personal.dao.ArticuloDAO;
import lp2.cdejava.inventstar.personal.model.Articulo;

/**
 *
 * @author Arian
 */
public class ArticuloMySQL implements ArticuloDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public ArrayList<Articulo> listarTodos() {
        ArrayList<Articulo> articulos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ARTICULO_TODOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Articulo articulo = new Articulo();
                articulo.setIdArticulo(rs.getInt("id_articulo"));
                articulo.setTitulo(rs.getString("titulo"));
                articulo.setDescripcion(rs.getString("descripcion"));
                articulo.setContenido(rs.getString(("contenido")));

                articulos.add(articulo);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return articulos;
    }
    
}

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
import lp2.cdejava.inventstar.personal.dao.MatrizDAO;
import lp2.cdejava.inventstar.personal.model.Matriz;

/**
 *
 * @author Usuario
 */
public class MatrizMySQL implements MatrizDAO {
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    public int insertar(Matriz matriz) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_MATRIZ(?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_matriz", java.sql.Types.INTEGER);
            cs.setString("_nombreMatriz", matriz.getNombreMatriz());
            cs.setString("_razonsocialMatriz", matriz.getRazonsocialMatriz());
            cs.setString("_direccionMatriz", matriz.getDireccionMatriz());
            cs.setString("_telefonoMatriz", matriz.getTelefonoMatriz());
            cs.setString("_emailMatriz", matriz.getEmailMatriz());
            rpta = cs.executeUpdate();
            matriz.setId_matriz(cs.getInt("_id_matriz"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    public int modificar(Matriz matriz) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_MATRIZ(?,?,?,?,?,?)}");
            cs.setInt("_id_matriz", matriz.getId_matriz());
            cs.setString("_nombreMatriz", matriz.getNombreMatriz());
            cs.setString("_razonsocialMatriz", matriz.getRazonsocialMatriz());
            cs.setString("_direccionMatriz", matriz.getDireccionMatriz());
            cs.setString("_telefonoMatriz", matriz.getDireccionMatriz());
            cs.setString("_emailMatriz", matriz.getEmailMatriz());
            rpta = cs.executeUpdate();
            matriz.setId_matriz(cs.getInt("_id_matriz"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    public int eliminar(Matriz matriz) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_MATRIZ(?)}");
            cs.setInt("_id_matriz", matriz.getId_matriz());
            rpta = cs.executeUpdate();
            matriz.setId_matriz(cs.getInt("_id_matriz"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    public int listarMatrizID() {
        ArrayList<Matriz> lista = new ArrayList<>();
        int resultado=0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_MATRIZ_TODOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Matriz matriz = new Matriz();
                matriz.setNombreMatriz(rs.getString("nombreMatriz"));
                matriz.setRazonsocialMatriz(rs.getString("razonsocialMatriz"));
                matriz.setDireccionMatriz(rs.getString("direccionMatriz"));
                matriz.setTelefonoMatriz(rs.getString("telefonoMatriz"));
                matriz.setEmailMatriz(rs.getString("emailMatriz"));
                matriz.setId_matriz(rs.getInt("id_matriz"));
                matriz.setActivo(true);
                lista.add(matriz);
                resultado= matriz.getId_matriz();
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }
}

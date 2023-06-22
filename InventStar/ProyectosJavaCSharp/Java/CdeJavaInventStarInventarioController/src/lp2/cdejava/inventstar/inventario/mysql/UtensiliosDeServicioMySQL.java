package lp2.cdejava.inventstar.inventario.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.dao.UtensiliosDeServicioDAO;
import lp2.cdejava.inventstar.inventario.model.UtensiliosDeServicio;
import lp2.cdejava.inventstar.config.DBManager;
import lp2.cdejava.inventstar.inventario.model.OrdenCompra;
import lp2.cdejava.inventstar.inventario.model.Producto;

/**
 *
 * @author Arian
 */
public class UtensiliosDeServicioMySQL implements UtensiliosDeServicioDAO {
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(UtensiliosDeServicio utensiliosDeServicio) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_UTENSILIOSDESERVICIO(?,?,?,?,?,?)}");
            cs.registerOutParameter("_idUtensiliosDeServicio", java.sql.Types.INTEGER);
            cs.setString("_nombreLote", utensiliosDeServicio.getNombre());
            cs.setDouble("_cantidadLote", utensiliosDeServicio.getCantidad());
            cs.setInt("_fid_compra", utensiliosDeServicio.getOrdenCompra().getIdCompra());
            cs.setBoolean("_activo", utensiliosDeServicio.isActivo());
            cs.setInt("_fidProducto", utensiliosDeServicio.getProducto().getIdItemVenta());
            
            cs.executeUpdate();
            utensiliosDeServicio.setIdLote(cs.getInt("_idUtensiliosDeServicio"));
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(UtensiliosDeServicio utensiliosDeServicio) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_UTENSILIOSDESERVICIO(?,?,?,?,?,?)}");
            cs.setInt("_idUtensiliosDeServicio", utensiliosDeServicio.getIdLote());
            cs.setString("_nombreLote", utensiliosDeServicio.getNombre());
            cs.setDouble("_cantidadLote", utensiliosDeServicio.getCantidad());
            cs.setInt("_fid_compra", utensiliosDeServicio.getOrdenCompra().getIdCompra());
            cs.setBoolean("_activo", utensiliosDeServicio.isActivo());
            cs.setInt("_fidProducto", utensiliosDeServicio.getProducto().getIdItemVenta());
            
            cs.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idUtensiliosDeServicio) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_UTENSILIOSDESERVICIO(?)}");
            cs.setInt("_idComida", idUtensiliosDeServicio);
            cs.executeUpdate();
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<UtensiliosDeServicio> listarTodosUtensiliosDeServicios() {
        ArrayList<UtensiliosDeServicio> utensilios = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_UTENSILIOSDESERVICIO()}");
            rs = cs.executeQuery();
            while(rs.next()){
                UtensiliosDeServicio utensilio = new UtensiliosDeServicio();
                utensilio.setIdLote(rs.getInt("id_lote"));
                utensilio.setNombre(rs.getString("nombreLote"));
                utensilio.setCantidad(rs.getDouble("cantidadLote"));
                utensilio.setOrdenCompra(new OrdenCompra());
                utensilio.getOrdenCompra().setIdCompra(rs.getInt("fid_compra"));
                utensilio.setActivo(true);
                utensilio.setProducto(new Producto());
                utensilio.getProducto().setIdItemVenta(rs.getInt("fidProducto"));                
                utensilios.add(utensilio);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return utensilios;
    }
    
}

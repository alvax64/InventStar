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
import lp2.cdejava.inventstar.personal.dao.CargoDAO;
import lp2.cdejava.inventstar.personal.model.Cargo;

/**
 *
 * @author Usuario
 */
public class CargoMySQL implements CargoDAO {
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    public int insertar(Cargo cargo) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_CARGO(?,?,?,?,?)}");
            cs.registerOutParameter("_id_cargo", java.sql.Types.INTEGER);
            cs.setString("_nombreCargo", cargo.getNombre());
            cs.setString("_descripcionCargo", cargo.getDescripcion());
            cs.setDouble("_salarioCargo", cargo.getSalario());
            cs.setBoolean("_modificaInventarioCargo", cargo.isModificaInventario());
            rpta = cs.executeUpdate();
            cargo.setIdCargo(cs.getInt("_id_cargo"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    @Override
    public int modificar(Cargo cargo) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CARGO(?,?,?,?,?)}");
            cs.setInt("_id_cargo", cargo.getIdCargo());
            cs.setString("_nombreCargo", cargo.getNombre());
            cs.setString("_descripcionCargo", cargo.getDescripcion());
            cs.setDouble("_salarioCargo", cargo.getSalario());
            cs.setBoolean("_modificaInventarioCargo", cargo.isModificaInventario());
            rpta = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    @Override
    public int eliminar(Cargo cargo) {
        int rpta = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_CARGO(?)}");
            cs.setInt("_id_cargo", cargo.getIdCargo());
            rpta = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return rpta;
    }
    @Override
    public ArrayList<Cargo> listarCargos() {
        ArrayList<Cargo> cargos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CARGO_TODOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Cargo cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("id_cargo"));
                cargo.setNombre(rs.getString("nombreCargo"));
                cargo.setDescripcion(rs.getString("descripcionCargo"));
                cargo.setSalario(rs.getDouble("salarioCargo"));
                cargo.setModificaInventario(rs.getBoolean("modificaInventarioCargo"));
                cargo.setActivo(true);
                cargos.add(cargo);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return cargos;
    }

    @Override
    public ArrayList<Cargo> listarCargosPorNombre(String nombre) {
        ArrayList<Cargo> cargos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CARGO_POR_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Cargo cargo = new Cargo();
                cargo.setIdCargo(rs.getInt("id_cargo"));
                cargo.setNombre(rs.getString("nombreCargo"));
                cargo.setDescripcion(rs.getString("descripcionCargo"));
                cargo.setSalario(rs.getDouble("salarioCargo"));
                cargo.setModificaInventario(rs.getBoolean("modificaInventarioCargo"));
                cargo.setActivo(true);
                cargos.add(cargo);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return cargos;   
    }
}

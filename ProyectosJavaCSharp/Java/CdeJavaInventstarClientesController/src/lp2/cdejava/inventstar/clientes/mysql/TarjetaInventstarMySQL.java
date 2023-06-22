/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lp2.cdejava.inventstar.clientes.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.dao.TarjetaInventstarDAO;
import lp2.cdejava.inventstar.clientes.model.Cliente;
import lp2.cdejava.inventstar.clientes.model.TarjetaInventstar;
import lp2.cdejava.inventstar.config.DBManager;

/**
 *
 * @author Usuario
 */
public class TarjetaInventstarMySQL implements TarjetaInventstarDAO{
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    @Override
    public int insertar(TarjetaInventstar tarjeta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_TARJETASTAR(?,?,?,?)}");
            cs.registerOutParameter("_idTarjeta", java.sql.Types.INTEGER);
            cs.setInt("_puntosTarjetastar", tarjeta.getPuntosAcumulados());
            cs.setDate("_fechaRegistroTarjetastar", new java.sql.Date(tarjeta.getFechaRegistro().getTime()));
            cs.setInt("_fidCliente", tarjeta.getCliente().getIdPersona());
            cs.executeUpdate();
            tarjeta.setIdTarjeta(cs.getInt("_idTarjeta"));
            resultado = tarjeta.getIdTarjeta();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(TarjetaInventstar tarjeta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_TARJETASTAR(?,?,?,?)}");
            cs.setInt("_idTarjeta", tarjeta.getIdTarjeta());
            cs.setInt("_puntosTarjetastar", tarjeta.getPuntosAcumulados());
            cs.setDate("_fechaRegistroTarjetastar", new java.sql.Date(tarjeta.getFechaRegistro().getTime()));
            cs.setInt("_fidCliente", tarjeta.getCliente().getIdPersona());
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idtarjeta) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_TARJETASTAR(?)}");
            cs.setInt("_idTarjeta", idtarjeta);
            resultado = cs.executeUpdate();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(Exception ex) {System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<TarjetaInventstar> listarTodasTarjetas() {
        ArrayList<TarjetaInventstar> tarjetas = new ArrayList<>();
        try {
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TARJETASTAR()}");
            rs = cs.executeQuery();
            while(rs.next()) {
                TarjetaInventstar card = new TarjetaInventstar();
                card.setIdTarjeta(rs.getInt("idTarjeta"));
                card.setPuntosAcumulados(rs.getInt("puntosTarjetastar"));
                card.setFechaRegistro(rs.getDate("fechaRegistroTarjetastar"));
                card.setCliente(new Cliente());
                card.getCliente().setIdPersona(rs.getInt("idPersona"));
                card.getCliente().setNombres(rs.getString("nombresPersona"));
                card.getCliente().setApellidoPat(rs.getString("apellidoPatPersona"));
                card.getCliente().setApellidoMat(rs.getString("apellidoMatPersona"));
                card.getCliente().setNumDocumento(rs.getString("numDocumentoPersona"));
                card.getCliente().setTelefono1(rs.getString("telefono1Persona"));
                card.getCliente().setTelefono2(rs.getString("telefono2Persona"));
                card.getCliente().setEmail(rs.getString("emailPersona"));
                card.getCliente().setDomicilio(rs.getString("domicilioPersona"));
                card.getCliente().setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                card.getCliente().setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                card.getCliente().setAceptaPublicidad(rs.getBoolean("aceptaPublicidadCliente"));
                card.setActivo(true);
                tarjetas.add(card);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return tarjetas; 
    }
    
}

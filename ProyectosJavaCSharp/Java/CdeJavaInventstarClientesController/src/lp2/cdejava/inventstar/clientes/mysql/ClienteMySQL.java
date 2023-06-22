package lp2.cdejava.inventstar.clientes.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.dao.ClienteDAO;
import lp2.cdejava.inventstar.clientes.model.Cliente;
import lp2.cdejava.inventstar.config.DBManager;

/**
 *
 * @author Usuario
 */
public class ClienteMySQL implements ClienteDAO{
    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    @Override
    
    public int insertar(Cliente cliente) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_idCliente", java.sql.Types.INTEGER);
            cs.setString("_nombresPersona", cliente.getNombres());
            cs.setString("_apellidoPatPersona", cliente.getApellidoPat());
            cs.setString("_apellidoMatPersona", cliente.getApellidoMat());
            cs.setString("_numDocumentoPersona", cliente.getNumDocumento());
            cs.setString("_telefono1Persona", cliente.getTelefono1());
            cs.setString("_telefono2Persona", cliente.getTelefono1());
            cs.setString("_emailPersona", cliente.getEmail());
            cs.setString("_domicilioPersona", cliente.getDomicilio());
            cs.setDate("_fechaRegistroPersona", new java.sql.Date(cliente.getFechaRegistro().getTime()));
            cs.setDate("_fechaNacimientoPersona", new java.sql.Date(cliente.getFechaCumpleanhos().getTime()));
            cs.setBoolean("_aceptaPublicidadCliente", true);
            cs.executeUpdate();
            cliente.setIdPersona(cs.getInt("_idCliente"));
            resultado = cliente.getIdPersona();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Cliente cliente) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call MODIFICAR_CLIENTE(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_idCliente", cliente.getIdPersona());
            cs.setString("_nombresPersona", cliente.getNombres());
            cs.setString("_apellidoPatPersona", cliente.getApellidoPat());
            cs.setString("_apellidoMatPersona", cliente.getApellidoMat());
            cs.setString("_numDocumentoPersona", cliente.getNumDocumento());
            cs.setString("_telefono1Persona", cliente.getTelefono1());
            cs.setString("_telefono2Persona", cliente.getTelefono1());
            cs.setString("_emailPersona", cliente.getEmail());
            cs.setString("_domicilioPersona", cliente.getDomicilio());
            cs.setDate("_fechaRegistroPersona", new java.sql.Date(cliente.getFechaRegistro().getTime()));
            cs.setDate("_fechaNacimientoPersona", new java.sql.Date(cliente.getFechaCumpleanhos().getTime()));
            cs.setBoolean("_aceptaPublicidadCliente", true);
            
            cs.executeUpdate();
            resultado = cliente.getIdPersona();;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int idCliente) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_CLIENTE(?)}");
            cs.setInt("_idCliente", idCliente);
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
    public ArrayList<Cliente> listarTodasClientes() {
         ArrayList<Cliente> clientes = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CLIENTE()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setAceptaPublicidad(rs.getBoolean("aceptaPublicidadCliente"));
                cliente.setIdPersona(rs.getInt("idPersona"));
                cliente.setNombres(rs.getString("nombresPersona"));
                cliente.setApellidoPat(rs.getString("apellidoPatPersona"));
                cliente.setApellidoMat(rs.getString("apellidoMatPersona"));
                cliente.setNumDocumento(rs.getString("numDocumentoPersona"));
                cliente.setTelefono1(rs.getString("telefono1Persona"));
                cliente.setTelefono2(rs.getString("telefono2Persona"));
                cliente.setEmail(rs.getString("emailPersona"));
                cliente.setDomicilio(rs.getString("domicilioPersona"));
                cliente.setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                cliente.setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                cliente.setActivo(true);
                clientes.add(cliente);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return clientes;
    }

    @Override
    public ArrayList<Cliente> listarTodasClientesPorNombre_Apellido_DNI(String nombre_Apellido_DNI) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CLIENTE_POR_NOMBRE_APELLIDO_DNI(?)}");
            cs.setString("_nombre_apellido_DNI", nombre_Apellido_DNI);
            rs = cs.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setAceptaPublicidad(rs.getBoolean("aceptaPublicidadCliente"));
                cliente.setIdPersona(rs.getInt("idPersona"));
                cliente.setNombres(rs.getString("nombresPersona"));
                cliente.setApellidoPat(rs.getString("apellidoPatPersona"));
                cliente.setApellidoMat(rs.getString("apellidoMatPersona"));
                cliente.setNumDocumento(rs.getString("numDocumentoPersona"));
                cliente.setTelefono1(rs.getString("telefono1Persona"));
                cliente.setTelefono2(rs.getString("telefono2Persona"));
                cliente.setEmail(rs.getString("emailPersona"));
                cliente.setDomicilio(rs.getString("domicilioPersona"));
                cliente.setFechaRegistro(rs.getDate("fechaRegistroPersona"));
                cliente.setFechaCumpleanhos(rs.getDate("fechaNacimientoPersona"));
                cliente.setActivo(true);
                clientes.add(cliente);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return clientes;
    }
    
}

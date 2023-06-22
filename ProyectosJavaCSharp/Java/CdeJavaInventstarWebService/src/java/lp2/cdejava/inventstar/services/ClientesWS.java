/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package lp2.cdejava.inventstar.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import lp2.cdejava.inventstar.clientes.dao.ClienteDAO;
import lp2.cdejava.inventstar.clientes.dao.PromocionPersonalizadaDAO;
import lp2.cdejava.inventstar.clientes.dao.TarjetaInventstarDAO;
import lp2.cdejava.inventstar.clientes.model.Cliente;
import lp2.cdejava.inventstar.clientes.model.PromocionPersonalizada;
import lp2.cdejava.inventstar.clientes.model.TarjetaInventstar;
import lp2.cdejava.inventstar.clientes.mysql.ClienteMySQL;
import lp2.cdejava.inventstar.clientes.mysql.PromocionPersonalizadaMySQL;
import lp2.cdejava.inventstar.clientes.mysql.TarjetaInventstarMySQL;


/**
 *
 * @author Usuario
 */
@WebService(serviceName = "ClientesWS")
public class ClientesWS {

    //Clientes 
    
    private ClienteDAO daoCliente = new ClienteMySQL();
    private TarjetaInventstarDAO daoTarjeta = new TarjetaInventstarMySQL(); 
    private PromocionPersonalizadaDAO daoPromocion = new PromocionPersonalizadaMySQL();
    
    @WebMethod(operationName = "insertarCliente")
    public int insertarCliente(Cliente cliente) {
        int resultado = 0;
        try {
            resultado = daoCliente.insertar(cliente);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarCliente")
    public int modificarCliente(Cliente cliente) {
        int resultado = 0;
        try {
            resultado = daoCliente.modificar(cliente);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminar")
    public int eliminar(int idCliente) {
        int resultado = 0;
        try {
            resultado = daoCliente.eliminar(idCliente);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodasClientes")
    public ArrayList<Cliente> listarTodasClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            clientes = daoCliente.listarTodasClientes();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
    
    @WebMethod(operationName = "listarTodasClientesPorNombre_Apellido_DNI")
    public ArrayList<Cliente> listarTodasClientesPorNombre_Apellido_DNI(String nombre_Apellido_DNI) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            clientes = daoCliente.listarTodasClientesPorNombre_Apellido_DNI(nombre_Apellido_DNI);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
    
    //Tarjeta
    @WebMethod(operationName = "insertarTarjeta")
    public int insertarTarjeta(TarjetaInventstar tarjeta) {
        int resultado = 0;
        try {
            resultado = daoTarjeta.insertar(tarjeta);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarTarjeta")
    public int modificarTarjeta(TarjetaInventstar tarjeta) {
        int resultado = 0;
        try {
            resultado = daoTarjeta.modificar(tarjeta);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarTarjeta")
    public int eliminarTarjeta(int idTarjeta) {
        int resultado = 0;
        try {
            resultado = daoTarjeta.eliminar(idTarjeta);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    @WebMethod(operationName = "listarTodasTarjetas")
    public ArrayList<TarjetaInventstar> listarTodasTarjetas() {
        ArrayList<TarjetaInventstar> tarjetas = new ArrayList<>();
        try {
            tarjetas = daoTarjeta.listarTodasTarjetas();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return tarjetas;
    }
    
    //Promocion
    @WebMethod(operationName = "insertarPromocion")
    public int insertarPromocion(PromocionPersonalizada promocion) {
        int resultado = 0;
        try {
            resultado = daoPromocion.insertar(promocion);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarPromocion")
    public int modificarPromocion(PromocionPersonalizada promocion) {
        int resultado = 0;
        try {
            resultado = daoPromocion.modificar(promocion);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarPromocion")
    public int eliminarPromocion(int idPromocion) {
        int resultado = 0;
        try {
            resultado = daoPromocion.eliminar(idPromocion);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodasPromociones")
    public ArrayList<PromocionPersonalizada> listarTodasPromociones(int idTarjeta) {
        ArrayList<PromocionPersonalizada> promociones = new ArrayList<>();
        try {
            promociones = daoPromocion.listarTodasPromocionPersonalizadaPorTarjeta(idTarjeta);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return promociones;
    }
}
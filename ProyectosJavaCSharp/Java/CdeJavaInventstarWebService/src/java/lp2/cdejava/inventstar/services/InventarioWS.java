/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package lp2.cdejava.inventstar.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import lp2.cdejava.inventstar.inventario.dao.BebidaDAO;
import lp2.cdejava.inventstar.inventario.dao.ComidaDAO;
import lp2.cdejava.inventstar.inventario.dao.IngredienteDAO;
import lp2.cdejava.inventstar.inventario.dao.OrdenCompraDAO;
import lp2.cdejava.inventstar.inventario.dao.ProveedorDAO;
import lp2.cdejava.inventstar.inventario.model.Bebida;
import lp2.cdejava.inventstar.inventario.model.Comida;
import lp2.cdejava.inventstar.inventario.model.Ingrediente;
import lp2.cdejava.inventstar.inventario.model.OrdenCompra;
import lp2.cdejava.inventstar.inventario.model.Proveedor;
import lp2.cdejava.inventstar.inventario.mysql.BebidaMySQL;
import lp2.cdejava.inventstar.inventario.mysql.ComidaMySQL;
import lp2.cdejava.inventstar.inventario.mysql.IngredienteMySQL;
import lp2.cdejava.inventstar.inventario.mysql.OrdenCompraMySQL;
import lp2.cdejava.inventstar.inventario.mysql.ProveedorMySQL;


/**
 *
 * @author Usuario
 */
@WebService(serviceName = "InventarioWS")
public class InventarioWS {

    /**
     * This is a sample web service operation
     */
    private ComidaDAO daoComida = new ComidaMySQL();
    private BebidaDAO daoBebida = new BebidaMySQL();
    private IngredienteDAO daoIngrediente = new IngredienteMySQL();
    private ProveedorDAO daoProveedor = new ProveedorMySQL();
    private OrdenCompraDAO daoOrdenCompra = new OrdenCompraMySQL();
    
    // Orden Compra
    @WebMethod(operationName = "listarOrdenCompraPorProveedor")
    public ArrayList<OrdenCompra> listarOrdenCompraPorProveedor(Proveedor _proveedor){
        ArrayList<OrdenCompra> ordenes = new ArrayList<>();
        try{
            ordenes = daoOrdenCompra.listarOrdenCompraPorProveedor(_proveedor);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ordenes;
    }
    
    @WebMethod(operationName = "insertarOrdenCompra")
    public int insertarOrdenCompra(OrdenCompra ordenCompra){
        int resultado = 0;
        try {
            resultado = daoOrdenCompra.insertarOrdenCompra(ordenCompra);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
        
    @WebMethod(operationName = "eliminarOrdenCompra")
    public int eliminarOrdenCompra(int idOrdenCompra){
        int resultado = 0;
        try {
            resultado = daoOrdenCompra.eliminarOrdenCompra(idOrdenCompra);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    // Proveedor
    @WebMethod(operationName = "listarProveedor")
    public ArrayList<Proveedor> listarProveedor(){
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try{
            proveedores = daoProveedor.listarProveedor();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return proveedores;
    }
    
    //Comida
    @WebMethod(operationName = "insertarComida")
    public int insertar(Comida comida) {
        int resultado = 0;
        try {
            resultado = daoComida.insertar(comida);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarComida")
    public int modificar(Comida comida) {
        int resultado = 0;
        try {
            resultado = daoComida.modificar(comida);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarComida")
    public int eliminar(int idComida) {
        int resultado = 0;
        try {
            resultado = daoComida.eliminar(idComida);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodasComidas")
    public ArrayList<Comida> listarTodasComidas() {
        ArrayList<Comida> comidas = new ArrayList<>();
        try {
            comidas = daoComida.listarTodasComidas();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return comidas;
    }
    
    //Bebida
    @WebMethod(operationName = "insertarBebida")
    public int insertar(Bebida bebida) {
        int resultado = 0;
        try {
            resultado = daoBebida.insertar(bebida);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarBebida")
    public int modificar(Bebida bebida) {
        int resultado = 0;
        try {
            resultado = daoBebida.modificar(bebida);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarBebida")
    public int eliminarBebida(int idBebida) {
        int resultado = 0;
        try {
            resultado = daoBebida.eliminar(idBebida);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodasBebidas")
    public ArrayList<Bebida> listarTodasBebidas() {
        ArrayList<Bebida> bebidas = new ArrayList<>();
        try {
            bebidas = daoBebida.listarTodasBebidas();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return bebidas;
    }
    
    @WebMethod(operationName = "listarIngrediente")
    public ArrayList<Ingrediente> listarIngrediente() {
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        try {
            ingredientes = daoIngrediente.listarIngrediente();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ingredientes;
    }
}

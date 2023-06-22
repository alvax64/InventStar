/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package lp2.cdejava.inventstar.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import lp2.cdejava.inventstar.personal.dao.ArticuloDAO;
import lp2.cdejava.inventstar.personal.dao.CargoDAO;
import lp2.cdejava.inventstar.personal.dao.CuentaPersonalDAO;
import lp2.cdejava.inventstar.personal.dao.MatrizDAO;
import lp2.cdejava.inventstar.personal.dao.OrdenVentaDAO;
import lp2.cdejava.inventstar.personal.dao.PersonalDAO;
import lp2.cdejava.inventstar.personal.dao.SucursalDAO;
import lp2.cdejava.inventstar.personal.dao.VideoDAO;
import lp2.cdejava.inventstar.personal.model.Articulo;
import lp2.cdejava.inventstar.personal.model.Cargo;
import lp2.cdejava.inventstar.personal.model.CuentaPersonal;
import lp2.cdejava.inventstar.personal.model.Matriz;
import lp2.cdejava.inventstar.personal.model.OrdenVenta;
import lp2.cdejava.inventstar.personal.model.Personal;
import lp2.cdejava.inventstar.personal.model.Sucursal;
import lp2.cdejava.inventstar.personal.model.Video;
import lp2.cdejava.inventstar.personal.mysql.ArticuloMySQL;
import lp2.cdejava.inventstar.personal.mysql.CargoMySQL;
import lp2.cdejava.inventstar.personal.mysql.CuentaPersonalMySQL;
import lp2.cdejava.inventstar.personal.mysql.MatrizMySQL;
import lp2.cdejava.inventstar.personal.mysql.OrdenVentaMySQL;
import lp2.cdejava.inventstar.personal.mysql.PersonalMySQL;
import lp2.cdejava.inventstar.personal.mysql.SucursalMySQL;
import lp2.cdejava.inventstar.personal.mysql.VideoMySQL;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "PersonalWS")
public class PersonalWS {

    /**
     * This is a sample web service operation
     */
    
    private CuentaPersonalDAO daoCuentaPersonal = new CuentaPersonalMySQL();
    private PersonalDAO daoPersonal = new PersonalMySQL();
    private VideoDAO daoVideo = new VideoMySQL();
    private OrdenVentaDAO daoOrdenVenta = new OrdenVentaMySQL();
    private ArticuloDAO daoArticulo = new ArticuloMySQL();
    private SucursalDAO daoSucursal= new SucursalMySQL();
    private MatrizDAO daoMatriz= new MatrizMySQL();
    private CargoDAO daoCargo= new CargoMySQL();
    
    // ORDEN VENTA
    @WebMethod(operationName = "listarOrdenVenta")
    public ArrayList<OrdenVenta> listarOrdenVenta(){
        ArrayList<OrdenVenta> ventas = new ArrayList<>();
        try{
            ventas = daoOrdenVenta.listarOrdenVenta();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ventas;
    }
    
    @WebMethod(operationName = "listarOrdenVentaPorCliente")
    public ArrayList<OrdenVenta> listarOrdenVentaPorCliente(@WebParam(name = "idCliente")int idCliente){
        ArrayList<OrdenVenta> ventas = new ArrayList<>();
        try{
            ventas = daoOrdenVenta.listarOrdenVentaPorCliente(idCliente);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ventas;
    }
    
    @WebMethod(operationName = "verificarCuentaPersonal")
    public int verificarCuentaPersonal(CuentaPersonal cuentaPersonal){
        int resultado = 0;
        try{
            resultado = daoCuentaPersonal.verificar(cuentaPersonal);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
        @WebMethod(operationName = "verificarCuentaPersonalConPermisos")
    public int verificarCuentaPersonalConPermisos(CuentaPersonal cuentaPersonal){
        int resultado = 0;
        try{
            resultado = daoCuentaPersonal.verificarPermisos(cuentaPersonal);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "obtenerPersonalPorId")
    public Personal obtenerPersonalPorId(int idPersonal){
        Personal personal = new Personal();
        try{
            personal = daoPersonal.obtenerPorId(idPersonal);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return personal;
    }
    
    @WebMethod(operationName = "listarTodosVideos")
    public ArrayList<Video> listarTodasVideos() {
        ArrayList<Video> videos = new ArrayList<>();
        try {
            videos = daoVideo.listarVideos();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return videos;
    }
    
    @WebMethod(operationName = "obtenerVideoPorId")
    public byte[] obtenerVideoPorId(int idVideo){
        byte[] url = null;
        try{
            url = daoVideo.obtenerUrl(idVideo);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return url;
    }
    
    @WebMethod(operationName = "listarTodosArticulos")
    public ArrayList<Articulo> listarTodosArticulos() {
        ArrayList<Articulo> articulos = new ArrayList<>();
        try {
            articulos = daoArticulo.listarTodos();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return articulos;
    }
    
    @WebMethod(operationName = "listarTodosSucursales")
    public ArrayList<Sucursal> listarTodosSucursales() {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        try {
            sucursales = daoSucursal.listarSucursal();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucursales;
    } 
    
    @WebMethod(operationName = "listarTodosSucursalesPorNombre")
    public ArrayList<Sucursal> listarTodosSucursalesPorNombre(String nombre) {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        try {
            sucursales = daoSucursal.listarSucursalPorNombre(nombre);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return sucursales;
    }
  
    @WebMethod(operationName = "listarMatriz")
    public int listarMatriz() {
        int resultado=0;
        try {
            resultado = daoMatriz.listarMatrizID();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    } 
    
    @WebMethod(operationName = "insertarSucursal")
    public int insertarSucursal(Sucursal sucursal) {
        int resultado = 0;
        try {
            resultado = daoSucursal.insertar(sucursal);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
        @WebMethod(operationName = "modificarSucursal")
    public int modificarSucursal(Sucursal sucursal) {
        int resultado = 0;
        try {
            resultado = daoSucursal.modificar(sucursal);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarSucursal")
    public int eliminarSucursal(Sucursal sucursal) {
        int resultado = 0;
        try {
            resultado = daoSucursal.eliminar(sucursal);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosPersonales")
    public ArrayList<Personal> listarTodosPersonales() {
        ArrayList<Personal> personales = new ArrayList<>();
        try {
            personales = daoPersonal.listarPersonal();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return personales;
    }
    
    @WebMethod(operationName = "listarTodosPersonalesPorNombre_Apellido_DNI")
    public ArrayList<Personal> listarTodosPersonalesPorNombre_Apellido_DNI(String nombre_Apellido_DNI) {
        ArrayList<Personal> personales = new ArrayList<>();
        try {
            personales = daoPersonal.listarPersonalesPorNombre_Apellido_DNI(nombre_Apellido_DNI);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return personales;
    } 
    
    @WebMethod(operationName = "listarTodosCargos")
    public ArrayList<Cargo> listarTodosCargos() {
        ArrayList<Cargo> cargos = new ArrayList<>();
        try {
            cargos = daoCargo.listarCargos();
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cargos;
    }
    
    @WebMethod(operationName = "listarTodosCargosPorNombre")
    public ArrayList<Cargo> listarTodosCargosPorNombre(String nombre) {
        ArrayList<Cargo> cargos = new ArrayList<>();
        try {
            cargos = daoCargo.listarCargosPorNombre(nombre);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return cargos;
    }
    
    @WebMethod(operationName = "modificarPermisoPersonal")
    public int modificarPermisoPersonal(int idPersonal, int fidCargo) {
        int resultado = 0;
        try {
            resultado = daoPersonal.modificarPermisosCargo(idPersonal,fidCargo);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}

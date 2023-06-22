/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.clientes.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.model.Cliente;

/**
 *
 * @author Usuario
 */
public interface ClienteDAO {
    public int insertar(Cliente cliente);
    public int modificar(Cliente cliente);
    public int eliminar(int idCliente);
    public ArrayList<Cliente> listarTodasClientes();    
    public ArrayList<Cliente> listarTodasClientesPorNombre_Apellido_DNI(String nombre_Apellido_DNI);    
}

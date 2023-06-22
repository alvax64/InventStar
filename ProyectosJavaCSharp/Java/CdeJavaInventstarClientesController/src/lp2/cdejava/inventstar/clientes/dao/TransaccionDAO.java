/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.clientes.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.clientes.model.Transaccion;

/**
 *
 * @author Usuario
 */
public interface TransaccionDAO {
    public int insertar(Transaccion transaccion);
    public int modificar(Transaccion transaccion);
    public int eliminar(int idTransaccion);
    public ArrayList<Transaccion> listarTodasTransacciones();
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.Contacto;

/**
 *
 * @author Arian
 */
public interface ContactoDAO {
    public int insertar(Contacto contacto);
    public int modificar(Contacto contacto);
    public int eliminar(int idContacto);
    public ArrayList<Contacto> listarTodosContactos();
}

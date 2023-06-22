/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.Comida;

/**
 *
 * @author Arian
 */
public interface ComidaDAO {
    public int insertar(Comida comida);
    public int modificar(Comida comida);
    public int eliminar(int idComida);
    public ArrayList<Comida> listarTodasComidas();
}

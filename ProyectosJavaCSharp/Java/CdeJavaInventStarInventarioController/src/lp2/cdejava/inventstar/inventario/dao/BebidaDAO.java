/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.Bebida;

/**
 *
 * @author Arian
 */
public interface BebidaDAO {
    public int insertar(Bebida bebida);
    public int modificar(Bebida bebida);
    public int eliminar(int idBebida);
    public ArrayList<Bebida> listarTodasBebidas();
}

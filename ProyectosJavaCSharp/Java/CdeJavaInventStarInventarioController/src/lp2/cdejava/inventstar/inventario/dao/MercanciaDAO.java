/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lp2.cdejava.inventstar.inventario.dao;

import java.util.ArrayList;
import lp2.cdejava.inventstar.inventario.model.Mercancia;

/**
 *
 * @author Arian
 */
public interface MercanciaDAO {
    public int insertar(Mercancia mercancia);
    public int modificar(Mercancia mercancia);
    public int eliminar(int idMercancia);
    public ArrayList<Mercancia> listarTodasMercancias();
}
